package com.os.contorller;

import com.os.entity.Orderdishes;
import com.os.entity.Roleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 详单控制器
 */
@Controller
public class OrderDishesController {
    String url="http://order-provider/";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查找所有经营数据（详单）
     *
     */
    @RequestMapping("/orderDishesFindAll")
    @ResponseBody
    public List orderDishesFindAll(Integer pageIndex, Model model){
        System.out.println("-----------------consumer-- orderDishesFindAll");
        System.out.println("-----------------consumer-- pageIndex: "+pageIndex);
        Integer pageSize=10;
        List list = restTemplate.getForObject(url + "orderDishesFindAll/" + pageIndex + "/" + pageSize, List.class);
        List<Orderdishes> orderdishesList= (List<Orderdishes>) list.get(0);
        if(orderdishesList!=null && orderdishesList.size()>0){
            int maxPage= (int) list.get(2);
            System.out.println("-----------------consumer-- maxPage: "+maxPage);
            System.out.println(orderdishesList.size());
            System.out.println(orderdishesList);
            list.add(pageIndex);
            return list;
        }
        return null;
    }

    @RequestMapping("/orderDishesFindById")
    @ResponseBody
    public List orderDishesFindById(Integer orderid,Model modele){
        System.out.println("-----------------consumer-- orderDishesFindById");
        System.out.println("-----------------consumer-- orderid: "+orderid);
        List list=restTemplate.getForObject(url+"orderDishesFindById/"+orderid,List.class);
        List<Orderdishes> orderbyList= (List<Orderdishes>) list.get(0);
        if(orderbyList!=null && orderbyList.size()>0){
            System.out.println(orderbyList.size());
            System.out.println(orderbyList);
            return list;
        }
        return null;

    }


}
