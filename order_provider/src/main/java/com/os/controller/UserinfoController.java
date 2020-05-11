package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 21:11
 */
@RestController
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;


    @PostMapping("login")
    public Userinfo login(@RequestBody Userinfo userinfo) {
        userinfo = userinfoService.loginUser(userinfo);
        System.out.println(userinfo);
        return userinfo;
    }

    @RequestMapping("userinfoPageHelper/{pageIndex}/{pageSize}/{useraccount}")
    public List<Userinfo> pagehelper(@PathVariable int pageIndex,@PathVariable int pageSize,@PathVariable String useraccount) {
        System.out.println(pageIndex+"\t"+pageSize+"\t"+useraccount);
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        if (useraccount.equals("null")||useraccount.equals("")){
            useraccount=null;
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<Userinfo> userlist = userinfoService.selectAll(useraccount);
        userlist.forEach(System.out::println);
        return userlist;
    }

    @RequestMapping("insertUser")
    public int insertUser(@RequestBody Userinfo userinfo) {
        return userinfoService.insertSelective(userinfo);
    }

    @RequestMapping("uptUser")
    public int updateUser(@RequestBody Userinfo userinfo) {
        return userinfoService.updateByPrimaryKeySelective(userinfo);
    }

    @RequestMapping("deleteUser")
    public int deleteUser(@RequestBody int userid) {
        return userinfoService.deleteByPrimaryKey(userid);
    }
}
