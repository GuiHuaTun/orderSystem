package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderdishes;
import com.os.entity.Orderinfo;
import com.os.service.OrderdishesService;
import com.os.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderInfoController {
    @Autowired
    OrderinfoService orderinfoService;

    @Autowired
    OrderdishesService orderdishesService;

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
        List<Orderdishes> orderdishesList=orderdishesService.selectAll();
        if(orderinfoList!=null && orderinfoList.size()>0 && orderdishesList!=null && orderdishesList.size()>0){
            int totalPage=orderinfoService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            System.out.println("-----------------provider-- maxPage: "+maxPage);
            List list=new ArrayList();
            list.add(orderinfoList);
            list.add(orderdishesList);
            list.add(maxPage);
            System.out.println(orderinfoList);
            return list;
        }
        System.out.println("---------------------provider--orderInfoFindAll can't");
        return null;
    }
}
