package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Dishesinfo;
import com.os.service.DishesinfoService;
import com.os.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
    @RequestMapping("/dishesInfoFindAll/{pageIndex}/{pageSize}")
    public List dishesInfoFindAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        System.out.println("-----------------provider-- dishesInfoFindAll");
        System.out.println("-----------------provider-- pageIndex: "+pageIndex);
        if(pageIndex==0 || pageIndex<1){
            pageIndex=1;
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<Dishesinfo> dishesinfoList=dishesinfoService.selectAll();
        if(dishesinfoList!=null && dishesinfoList.size()>0){
            int totalPage=dishesinfoService.selectAll().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            System.out.println("-----------------provider-- maxPage: "+maxPage);
            List list=new ArrayList();
            list.add(dishesinfoList);
            list.add(maxPage);
            System.out.println(dishesinfoList);
            return list;
        }
        System.err.println("-----------------provider-- dishesInfoFindAll fail");
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
     * @param ：图片文件
     * @param
     * @return
     */
    @RequestMapping("/dishesGetDishesImg")
    public String getDishesImg(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("path") String path, HttpServletRequest request){
        System.out.println("-----------------provider-- dishesGetDishesImg");
        String imgPath= FileUpload.upload(uploadFile,path);
        return imgPath;
    }

    @RequestMapping("/selectDishesByRec/{pageIndex}/{pageSize}")
    public List selectDishesByRec(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        System.out.println("-----------------provider-- selectDishesByRec");
        System.out.println("-----------------provider-- pageIndex: "+pageIndex);
        if(pageIndex==0 || pageIndex<1){
            pageIndex=1;
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<Dishesinfo> dishesinfoList=dishesinfoService.selectDishesByRec();
        if(dishesinfoList!=null && dishesinfoList.size()>0){
            int totalPage=dishesinfoService.selectDishesByRec().size();
            System.out.println("-----------------provider-- totalPage: "+totalPage);
            int maxPage=totalPage%pageSize==0?totalPage/pageSize:totalPage/pageSize+1;
            System.out.println("-----------------provider-- maxPage: "+maxPage);
            List reclist=new ArrayList();
            reclist.add(dishesinfoList);
            reclist.add(maxPage);
            return reclist;
        }
        return null;
    }
}
