package com.os.contorller;

import com.os.entity.Dishesinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author haohui
 * @create 2020-05-08 19:21
 * @controller 菜品信息控制器
 */
@Controller
public class DishesInfoController {
    String url="http://order-provider/";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查找所有菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoFindAll")
    @ResponseBody
    public List dishesInfoFindAll(Integer pageIndex, Model model){
        System.out.println("-----------------consumer-- dishesInfoFindAll");
        System.out.println("-----------------consumer-- pageIndex: "+pageIndex);
        Integer pageSize=8;
        List list = restTemplate.getForObject(url + "dishesInfoFindAll/" + pageIndex + "/" + pageSize, List.class);
        List<Dishesinfo> dishesinfoList= (List<Dishesinfo>) list.get(0);
        if(dishesinfoList!=null && dishesinfoList.size()>0){
            int maxPage= (int) list.get(1);
            System.out.println("-----------------consumer-- maxPage: "+maxPage);
            System.out.println(dishesinfoList);
            list.add(pageIndex);
            return list;
        }
        return null;
    }

    /**
     * 根据菜品编号查找菜品
     * @param dishesid：菜品编号
     * @return
     */
    @RequestMapping("/dishesInfoFindById")
    public String dishesInfoFindById(int dishesid, Model model){
        System.out.println("-----------------consumer-- dishesInfoFindById");
        Dishesinfo dishesinfo=restTemplate.postForObject(url+"dishesInfoFindById",dishesid, Dishesinfo.class);
        if(dishesinfo!=null){
            System.out.println(dishesinfo);
            model.addAttribute("dishesinfo",dishesinfo);
            System.out.println("********************************");
            return "pages/admin/modifydishes";
        }
        return "error";
    }

    /**
     * 添加菜品信息
     * @param dishesinfo：菜品信息
     * @return
     */
    @RequestMapping("/dishesInfoAdd")
    public String dishesInfoAdd(Dishesinfo dishesinfo){
        System.out.println("-----------------consumer-- dishesInfoAdd");
        int num=restTemplate.postForObject(url+"dishesInfoAdd",dishesinfo,Integer.class);
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
        int num=restTemplate.postForObject(url+"dishesInfoUpdate",dishesinfo,Integer.class);
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
        int num=restTemplate.postForObject(url+"dishesInfoDelete",dishesid,Integer.class);
        if(num>0){
            return "";
        }
        return "";
    }

    /**
     * 上传菜品图片
     * @param pic：图片文件
     * @return
     */
    @RequestMapping("/dishesGetDishesImg")
    @ResponseBody
    public String getDishesImg(MultipartFile pic){
        System.out.println("-----------------consumer-- dishesGetDishesImg");
        String dishesimg = restTemplate.postForObject(url + "dishesGetDishesImg", pic, String.class);
        return dishesimg;
    }
}
