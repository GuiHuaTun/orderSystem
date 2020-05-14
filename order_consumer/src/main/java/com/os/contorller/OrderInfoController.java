package com.os.contorller;

import com.os.entity.Orderinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class OrderInfoController {
    String url="http://order-provider/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查找所有经营数据（订单）
     *
     */

    @RequestMapping("/orderInfoFindAll")
    @ResponseBody
    public List orderInfoFindAll(Integer pageIndex, Model model){
        System.out.println("-----------------consumer-- orderInfoFindAll");
        System.out.println("-----------------consumer-- pageIndex: "+pageIndex);
        Integer pageSize=10;
        List list = restTemplate.getForObject(url + "orderInfoFindAll/" + pageIndex + "/" + pageSize, List.class);
        List<Orderinfo> orderinfoList= (List<Orderinfo>) list.get(0);
        if(orderinfoList!=null && orderinfoList.size()>0){
            int maxPage= (int) list.get(1);
            System.out.println("-----------------consumer-- maxPage: "+maxPage);
            System.out.println(orderinfoList.size());
            System.out.println(orderinfoList);
            list.add(pageIndex);
            return list;
        }
        return null;
    }
}
