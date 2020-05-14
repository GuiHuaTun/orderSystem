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
        System.out.println("tableid"+tableid);
        Userinfo userinfo = (Userinfo) session.getAttribute("waiter");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        Orderinfo orderinfo=new Orderinfo();
        int num= restTemplate.postForObject(url + "insertSelective",orderinfo,Integer.class);

        orderinfo = restTemplate.getForObject(url + "selectTablesById/" + tableid, Orderinfo.class);
        System.out.println(orderinfo);
        return "";
    }


}
