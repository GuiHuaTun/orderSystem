package com.os.contorller;

import com.os.entity.Orderdishes;
import com.os.entity.Roleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println("maxPage: "+list.get(2));
            System.out.println("orderdishesList.size: "+orderdishesList.size());
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
            return list;
        }
        return null;

    }

    /**
     * 后厨订单遍历
     * @param pageIndex：页码
     * @return
     */
    @RequestMapping("/selectByStatus")
    @ResponseBody
    public List<Orderdishes> selectByStatus(Integer pageIndex){
        System.out.println("-----------------consumer-- selectByStatus");
        System.out.println("pageIndex: "+pageIndex);
        if(pageIndex==0 || pageIndex<1){
            pageIndex=1;
        }
        Integer pageSize=8;
        Integer status=0;
        List list=restTemplate.getForObject(url+"selectByStatus/"+status+"/"+pageIndex+"/"+pageSize,List.class);
        if(list!=null){
            return list;
        }
        return null;
    }

    /**
     * 后厨上菜
     * @param odid：订单编号
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public int updateStatus(int odid){
        System.out.println("-----------------consumer-- updateStatus");
        System.out.println("odid: "+odid);
        Integer status=1;
        int num=restTemplate.getForObject(url+"updateStatus/"+status+"/"+odid,Integer.class);
        if(num>0){
            return num;
        }
        return 0;
    }
}
