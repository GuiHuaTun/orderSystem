package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderinfo;
import com.os.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderInfoController {
    @Autowired
    OrderinfoService orderinfoService;

    /**
     * 查找所有订单
     */

    @RequestMapping("/orderInfoFindAll/{pageIndex}/{pageSize}")
    public List orderInfoFindAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        System.out.println("-----------------provider-- orderInfoFindAll");
        System.out.println("-----------------provider-- pageIndex: "+pageIndex);
        if(pageIndex==0 || pageIndex<1){
            pageIndex=1;
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<Orderinfo> orderinfoList=orderinfoService.selectAll();
        if(orderinfoList!=null && orderinfoList.size()>0){
            int totalPage=orderinfoService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            System.out.println("-----------------provider-- maxPage: "+maxPage);
            List list=new ArrayList();
            list.add(orderinfoList);
            list.add(maxPage);
            System.out.println(orderinfoList);
            return list;
        }
        System.out.println("---------------------provider--orderInfoFindAll can't");
        return null;
    }

    /**
     * 根据桌号查订单ID
     * @param tableid
     * @return
     */
    @RequestMapping("selectTablesById/{tableid}")
    public Orderinfo selectTablesById(@PathVariable("tableid") int tableid){
        return orderinfoService.selectTablesByTableId(tableid);
    }


    @RequestMapping(value = "insertOrder",method = RequestMethod.POST)
    @ResponseBody
    public int insertOrder(@RequestBody Orderinfo orderinfo){
       return    orderinfoService.insertSelective(orderinfo);
    }
}
