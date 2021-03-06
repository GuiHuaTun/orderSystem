package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Orderdishes;
import com.os.entity.Orderinfo;
import com.os.entity.Tables;
import com.os.service.OrderdishesService;
import com.os.service.OrderinfoService;
import com.os.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class OrderInfoController {
    @Autowired
    OrderinfoService orderinfoService;

    @Autowired
    OrderdishesService orderdishesService;

    @Autowired
    TableService tableService;

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
        orderinfo = orderinfoService.selectByPrimaryKey(orderinfo.getOrderid());
        Tables tables = new Tables();
        tables.setTableid(orderinfo.getTables().getTableid());
        tables.setTablestatus(0);
        tableService.updateByPrimaryKeySelective(tables);
        return num;
    }

    @RequestMapping("/deleteOrder/{orderid}")
    public int deleteOrder(@PathVariable("orderid") int orderid) {
        System.out.println("------------------provider-- deleteOrder");
        orderdishesService.deleteByPrimaryKey(orderid);
        int num = orderinfoService.deleteByPrimaryKey(orderid);
        return num;
    }


    @RequestMapping("selectCharts")
    public List selectCharts() {
        String[] sevenDay = new String[8];//获取前七天日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance(); //创建Calendar 的实例
        calendar.setTime(date);
        sevenDay[0] = sdf.format(date).toString() + " 00:00:00";
        for (int i = 1; i < sevenDay.length; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, -1); //当前时间减去一天，即一天前的时间
            sevenDay[i] = sdf.format(calendar.getTime()) + " 00:00:00";
        }
        List list = new ArrayList();
        for (int i = 1; i < sevenDay.length; i++) {
            double totalPrice = 0.0, orderdishesPrice = 0.0, price = 0.0;
            int num = 0;
            Orderinfo orderinfo = new Orderinfo(sevenDay[i], sevenDay[i - 1], 1);
            List<Orderinfo> orderinfoList = orderinfoService.selectCharts(orderinfo);
            if (orderinfoList != null) {
                for (int j = 0; j < orderinfoList.size(); j++) {
                    List<Orderdishes> orderdishesList = orderdishesService.selectById(orderinfoList.get(j).getOrderid());
                    if (orderdishesList != null) {
                        for (int k = 0; k < orderdishesList.size(); k++) {
                            num = orderdishesList.get(k).getNum();
                            orderdishesPrice = Double.parseDouble(orderdishesList.get(k).getDishesinfo().getDishesprice());
                            price = num * orderdishesPrice;
                            totalPrice += price;
                            System.out.println("sevenDay=" + sevenDay + "\tprice=" + price+"\t"+totalPrice);
                        }
                    }
                }
            }
            Object[] charts = {totalPrice, sevenDay[i]};
            list.add(charts);
        }
        return list;
    }
}
