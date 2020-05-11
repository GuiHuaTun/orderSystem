package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Dishesinfo;
import com.os.service.DishesinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    public List<Dishesinfo> dishesInfoFindAll(int pageIndex,int pageSize){
        System.out.println("------------------provider- dishesInfoFindAll");
        PageHelper.startPage(pageIndex,pageSize);
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

    /**
     * 上传菜品图片
     * @param pic：图片文件
     * @param request
     * @return
     */
    @RequestMapping("/dishesGetDishesImg")
    public String getDishesImg(@RequestBody MultipartFile pic, HttpServletRequest request){
        System.out.println("-----------------provider-- dishesGetDishesImg");
        String imgname= UUID.randomUUID().toString();//生成随机数用于组成文件名
        System.out.println("uuid: "+imgname);
        String originalname=pic.getOriginalFilename();//获取pic的文件名
        System.out.println("originalname: "+originalname);
        String extraname=originalname.substring(originalname.lastIndexOf("."));//截取pic的后缀名
        System.out.println("extraname: "+extraname);
        String dishesimg=imgname+extraname;//新组成的文件名
        String path=request.getServletContext().getRealPath("/img/upload");//获取上传文件夹/img/upload的绝对路径
        System.out.println("path:"+path);
        File file=new File(path+"/"+dishesimg);//生成文件
        if(!file.getParentFile().exists()){//判断上传文件夹upload是否存在
            file.getParentFile().mkdirs();//创建上传文件夹upload文件夹
        }
        try {
            pic.transferTo(file);//将pic文件转到file文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishesimg;
    }
}
