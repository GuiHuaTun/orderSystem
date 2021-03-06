package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderdishes;
import com.os.entity.Orderinfo;
import com.os.entity.Roleinfo;
import com.os.service.OrderdishesService;
import com.os.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderDishesController {
    @Autowired
    OrderdishesService orderdishesService;

    @Autowired
    OrderinfoService orderinfoService;

    /**
     * 查找所有经营数据（详单）
     * @return
     */
    @RequestMapping("/orderDishesFindAll/{pageIndex}/{pageSize}")
    public List orderDishesFindAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        System.out.println("-----------------provider-- orderDishesFindAll");
        System.out.println("-----------------provider-- pageIndex: "+pageIndex);
        if(pageIndex==0 || pageIndex<1){
            pageIndex=1;
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<Orderdishes> orderdishesList=orderdishesService.selectAll();
        List<Orderinfo> orderinfoList=orderinfoService.selectAll();
        if(orderdishesList!=null && orderdishesList.size()>0 && orderinfoList!=null && orderinfoList.size()>0){
            int totalPage=orderdishesService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            List list=new ArrayList();
            list.add(orderdishesList);
            list.add(orderinfoList);
            list.add(maxPage);
            return list;
        }
        return null;
    }

    /**
     * 根据订单id查询
     * @return
     */
    @RequestMapping("/orderDishesFindById/{orderid}")
    public List orderDishesFindById(@PathVariable("orderid") int orderid){
        System.out.println("-----------------provider-- orderDishesFindById");
        List<Orderdishes> orderByList=orderdishesService.selectById(orderid);
        if(orderByList!=null && orderByList.size()>0 ){
            List list=new ArrayList();
            list.add(orderByList);
            return list;
        }
        System.out.println("---------------------provider--orderDishesFindById can't");
        return null;
    }

    @RequestMapping(value = "insertOrderDishes",method = RequestMethod.POST)
    public int insertOrderDishes(@RequestBody Orderdishes orderdishes){
        return orderdishesService.insertSelective(orderdishes);
    }

    /**
     * 后厨订单遍历
     * @param status：订单菜品状态
     * @param pageIndex：页码
     * @param pageSize：每页数据描述
     * @return
     */
    @RequestMapping("/selectByStatus/{status}/{pageIndex}/{pageSize}")
    public List<Orderdishes> selectByStatus(@PathVariable("status") int status,@PathVariable("pageIndex") int pageIndex,@PathVariable("pageSize") int pageSize){
        System.out.println("-----------------provider-- selectByStatus");
        System.out.println("status: "+status);
        System.out.println("pageIndex: "+pageIndex);
        System.out.println("pageSize: "+pageSize);
        PageHelper.startPage(pageIndex,pageSize);
        List<Orderdishes> orderdishesList=orderdishesService.selectByStatus(status);
        int totalPage=orderdishesService.selectByStatus(status).size();
        System.out.println("totalPage: "+totalPage);
        int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
        System.out.println("maxPage: "+maxPage);
        System.out.println("orderdishesList: "+orderdishesList);
        if(orderdishesList!=null){
            List list=new ArrayList();
            list.add(orderdishesList);
            list.add(pageIndex);
            list.add(maxPage);
            return list;
        }
        return null;
    }

    /**
     * 后厨上菜
     * @param status:订单菜品状态
     * @param odid：订单编号
     * @return
     */
    @RequestMapping("/updateStatus/{status}/{odid}")
    public int updateStatus(@PathVariable("status") int status,@PathVariable("odid") int odid){
        System.out.println("-----------------provider-- updateStatus");
        System.out.println("status: "+status);
        System.out.println("odid: "+odid);
        Orderdishes orderdishes=new Orderdishes();
        orderdishes.setOdid(odid);
        orderdishes.setStatus(status);
        int num=orderdishesService.updateByPrimaryKeySelective(orderdishes);
        if(num>0){
            return num;
        }
        return 0;
    }
}
