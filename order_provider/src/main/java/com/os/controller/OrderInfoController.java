package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderdishes;
import com.os.entity.Orderinfo;
import com.os.service.OrderdishesService;
import com.os.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List orderInfoFindAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        System.out.println("-----------------provider-- orderInfoFindAll");
        System.out.println("-----------------provider-- pageIndex: " + pageIndex);
        if (pageIndex == 0 || pageIndex < 1) {
            pageIndex = 1;
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<Orderinfo> orderinfoList = orderinfoService.selectAll();
        List<Orderdishes> orderdishesList = orderdishesService.selectAll();
        if (orderinfoList != null && orderinfoList.size() > 0 && orderdishesList != null && orderdishesList.size() > 0) {
            int totalPage = orderinfoService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: " + totalPage);
            int maxPage = totalPage % pageSize == 0 ? totalPage / pageSize : totalPage / pageSize + 1;
            System.out.println("-----------------provider-- maxPage: " + maxPage);
            List list = new ArrayList();
            list.add(orderinfoList);
            list.add(orderdishesList);
            list.add(maxPage);
            return list;
        }
        System.out.println("---------------------provider--orderInfoFindAll can't");
        return null;
    }

    /**
     * 根据桌号查订单ID
     *
     * @param tableid
     * @return
     */
    @RequestMapping("selectTablesById/{tableid}")
    public Orderinfo selectTablesById(@PathVariable("tableid") int tableid) {
        return orderinfoService.selectTablesByTableId(tableid);
    }


    @RequestMapping(value = "insertOrder", method = RequestMethod.POST)
    public int insertOrder(@RequestBody Orderinfo orderinfo) {
        System.out.println("insertOrder方法");
        return orderinfoService.insertSelective(orderinfo);
    }

    //根据时间查询订单
    @RequestMapping(value = "selectOrdeyBytime/{pageIndex}/{pageSize}", method = RequestMethod.POST)
    public List<Orderinfo> selectOrdeyBytime(@RequestBody Orderinfo orderinfo, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        if (orderinfo.getOrderbegindate().equals("null") || orderinfo.getOrderbegindate().equals("")) {
            orderinfo.setOrderbegindate(null);
        }
        if (orderinfo.getOrderenddate().equals("null") || orderinfo.getOrderenddate().equals("")) {
            orderinfo.setOrderenddate(null);
        }
        int listSize = orderinfoService.selectOrderByTime(orderinfo).size();
        int pageCount = listSize % pageSize == 0 ? listSize / pageSize : listSize / pageSize + 1;
        List<Orderdishes> orderdishesList = orderdishesService.selectAll();
        List list = new ArrayList();
        PageHelper.startPage(pageIndex, pageSize);
        List<Orderinfo> orderinfolist = orderinfoService.selectOrderByTime(orderinfo);
        list.add(orderinfolist);
        list.add(orderdishesList);
        list.add(pageCount);
        return list;
    }

    /**
     * 订单结账
     *
     * @param orderinfo：订单对象
     * @return
     */
    @RequestMapping("/oderAccount")
    public int oderAccount(@RequestBody Orderinfo orderinfo) {
        System.out.println("------------------provider-- oderAccount");
        System.out.println("orderinfo: " + orderinfo);
        int num = orderinfoService.updateByPrimaryKeySelective(orderinfo);
        return num;
    }

    @RequestMapping("/deleteOrder")
    public int deleteOrder(int orderid){
        System.out.println("------------------provider-- deleteOrder");
        int num=orderinfoService.deleteByPrimaryKey(orderid);
        return num;
    }
}
