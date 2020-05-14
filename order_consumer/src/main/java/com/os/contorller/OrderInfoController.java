package com.os.contorller;

import com.os.entity.Orderdishes;
import com.os.entity.Orderinfo;
import com.os.entity.Tables;
import com.os.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrderInfoController {
    String url = "http://order-provider/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查找所有经营数据（订单）
     */

    @RequestMapping("/orderInfoFindAll")
    @ResponseBody
    public List orderInfoFindAll(Integer pageIndex, Model model) {
        System.out.println("-----------------consumer-- orderInfoFindAll");
        System.out.println("-----------------consumer-- pageIndex: " + pageIndex);
        Integer pageSize = 10;
        List list = restTemplate.getForObject(url + "orderInfoFindAll/" + pageIndex + "/" + pageSize, List.class);
        List<Orderinfo> orderinfoList = (List<Orderinfo>) list.get(0);
        if (orderinfoList != null && orderinfoList.size() > 0) {
            int maxPage = (int) list.get(1);
            System.out.println("-----------------consumer-- maxPage: " + maxPage);
            System.out.println(orderinfoList.size());
            System.out.println(orderinfoList);
            list.add(pageIndex);
            return list;
        }
        return null;
    }


    @RequestMapping(value = "insertOrder/{tableid}", method = RequestMethod.POST)
    @ResponseBody
    public String insertOrder(@RequestBody List<Orderdishes> orderdishes, @PathVariable("tableid") int tableid, HttpSession session) {
        System.out.println(orderdishes);
        Userinfo userinfo = (Userinfo) session.getAttribute("waiter");//获取服务员信息
        Tables tables = new Tables(tableid,1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        Orderinfo orderinfo = new Orderinfo(time, userinfo, 0, tables);
        System.out.println(orderinfo);
        int num = restTemplate.postForObject(url + "insertOrder", orderinfo, Integer.class);
        System.out.println(num > 0 ? "添加成功" : "添加失败");
        orderinfo = restTemplate.getForObject(url + "selectTablesById/" + tableid, Orderinfo.class);//查询订单信息
        System.out.println(orderinfo);

        restTemplate.postForObject(url + "updateTableStatus", tables, Integer.class);//修改餐桌状态
        for (Orderdishes orderdish : orderdishes) {
            orderdish.setOrderinfo(orderinfo);
            num=restTemplate.postForObject(url+"insertOrderDishes",orderdish,Integer.class);
            System.out.println(num > 0 ? "添加成功" : "添加失败");
        }
        return "";
    }


}
