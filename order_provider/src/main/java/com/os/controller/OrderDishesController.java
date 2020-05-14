package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderdishes;
import com.os.entity.Roleinfo;
import com.os.service.OrderdishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderDishesController {
    @Autowired
    OrderdishesService orderdishesService;

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
        if(orderdishesList!=null && orderdishesList.size()>0){
            int totalPage=orderdishesService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            System.out.println("-----------------provider-- maxPage: "+maxPage);
            List list=new ArrayList();
            list.add(orderdishesList);
            list.add(maxPage);
            System.out.println(orderdishesList);
            return list;
        }
        System.out.println("---------------------provider--orderDishesFindAll can't");
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
        if(orderByList!=null && orderByList.size()>0){
            List list=new ArrayList();
            list.add(orderByList);
            return list;
        }
        System.out.println("---------------------provider--orderDishesFindById can't");
        return null;
    }
}
