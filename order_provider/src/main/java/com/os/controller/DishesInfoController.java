package com.os.controller;

import com.os.entity.Dishesinfo;
import com.os.service.DishesinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haohui
 * @create 2020-05-08 14:39
 * @controller 菜品信息控制器
 */
@RestController
public class DishesInfoController {
    @Autowired
    private DishesinfoService dishesinfoService;

    /**
     * 查找所有菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoFindAll")
    public List<Dishesinfo> dishesInfoFindAll(){
        System.out.println("------------------provider- dishesInfoFindAll");
        List<Dishesinfo> dishesinfoList=dishesinfoService.selectAll();
        if(dishesinfoList!=null && dishesinfoList.size()>0){
            System.out.println(dishesinfoList);
            return dishesinfoList;
        }
        System.err.println("------------------provider- dishesInfoFindAll fail");
        return null;
    }

    /**
     * 根据菜品编号查找菜品
     * @param dishesid：菜品编号
     * @return
     */
    @RequestMapping("/dishesInfoFindById")
    public Dishesinfo dishesInfoFindById(@RequestBody int dishesid){
        System.out.println("-----------------provider-- dishesInfoFindById");
        Dishesinfo dishesinfo=dishesinfoService.selectByPrimaryKey(dishesid);
        if(dishesinfo!=null){
            return dishesinfo;
        }
        System.err.println("-----------------provider-- dishesInfoFindById fail");
        return null;
    }

    /**
     * 添加菜品信息
     * @param dishesinfo：菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoAdd")
    public int dishesInfoAdd(@RequestBody Dishesinfo dishesinfo){
        System.out.println("-----------------provider-- dishesInfoAdd");
        int num=dishesinfoService.insertSelective(dishesinfo);
        if(num>0){
            return num;
        }
        System.err.println("-----------------provider-- dishesInfoAdd fail");
        return 0;
    }

    /**
     * 修改菜品信息
     * @param dishesinfo：菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoUpdate")
    public int dishesInfoUpdate(@RequestBody Dishesinfo dishesinfo){
        System.out.println("-----------------provider-- dishesInfoUpdate");
        int num=dishesinfoService.updateByPrimaryKeySelective(dishesinfo);
        if(num>0){
            return num;
        }
        System.err.println("-----------------provider-- dishesInfoUpdate fail");
        return 0;
    }

    /**
     * 删除菜品信息
     * @param dishesid：菜品编号
     * @return
     */
    @RequestMapping("/dishesInfoDelete")
    public int dishesInfoDelete(@RequestBody int dishesid){
        System.out.println("-----------------provider-- dishesInfoDelete");
        int num=dishesinfoService.deleteByPrimaryKey(dishesid);
        if(num>0){
            return num;
        }
        System.err.println("-----------------provider-- dishesInfoDelete fail");
        return 0;
    }
}
