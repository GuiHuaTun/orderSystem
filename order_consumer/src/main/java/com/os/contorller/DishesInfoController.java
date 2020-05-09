package com.os.contorller;

import com.os.entity.Dishesinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author haohui
 * @create 2020-05-08 19:21
 * @controller 菜品信息控制器
 */
@Controller
public class DishesInfoController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查找所有菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoFindAll")
    public String dishesInfoFindAll(){
        System.out.println("-----------------consumer-- dishesInfoFindAll");
        List<Dishesinfo> dishesinfoList= (List<Dishesinfo>) restTemplate.getForObject("http://order-provider/DishesInfoFindAll",List.class);
        if(dishesinfoList!=null && dishesinfoList.size()>0){
            return "";
        }
        return "";
    }

    /**
     * 根据菜品编号查找菜品
     * @param dishesid：菜品编号
     * @return
     */
    @RequestMapping("/dishesInfoFindById")
    public String dishesInfoFindById(int dishesid){
        System.out.println("-----------------consumer-- dishesInfoFindById");
        Dishesinfo dishesinfo=restTemplate.postForObject("http://order-provider/dishesInfoFindById",dishesid, Dishesinfo.class);
        if(dishesinfo!=null){
            return "";
        }
        return "";
    }

    /**
     * 添加菜品信息
     * @param dishesinfo：菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoAdd")
    public String dishesInfoAdd(Dishesinfo dishesinfo){
        System.out.println("-----------------consumer-- dishesInfoAdd");
        int num=restTemplate.postForObject("http://order-provider/dishesInfoAdd",dishesinfo,Integer.class);
        if(num>0){
            return "";
        }
        return "";
    }

    /**
     * 修改菜品信息
     * @param dishesinfo：菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoUpdate")
    public String dishesInfoUpdate(Dishesinfo dishesinfo){
        System.out.println("-----------------consumer-- dishesInfoUpdate");
        int num=restTemplate.postForObject("http://order-provider/dishesInfoUpdate",dishesinfo,Integer.class);
        if(num>0){
            return "";
        }
        return "";
    }

    /**
     * 删除菜品信息
     * @param dishesid：菜品编号
     * @return
     */
    @RequestMapping("/dishesInfoDelete")
    public String dishesInfoDelete(int dishesid){
        System.out.println("-----------------consumer-- dishesInfoDelete");
        int num=restTemplate.postForObject("http://order-provider/dishesInfoDelete",dishesid,Integer.class);
        if(num>0){
            return "";
        }
        return "";
    }
}
