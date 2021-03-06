package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import com.os.util.FileUpload;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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


    /**
     * 登陆
     *
     * @param userinfo
     * @return
     */
    @PostMapping("login")
    public Userinfo login(@RequestBody Userinfo userinfo) {
        userinfo = userinfoService.loginUser(userinfo);
        System.out.println(userinfo);
        return userinfo;
    }

    /**
     * 查询所有员工
     *
     * @param useraccount
     * @param roleid
     * @return
     */
    @RequestMapping("getAllUser/{useraccount}/{roleid}")
    public List<Userinfo> getAllUser(@PathVariable("useraccount") String useraccount, @PathVariable("roleid") int roleid) {
        System.out.println("----------------------------------------getAllUser");
        if (useraccount.equals("null")) {
            useraccount = null;
        }
        System.out.println(useraccount + "\t" + roleid + "\t");
        List<Userinfo> userlist = userinfoService.selectAll(useraccount, roleid);
        userlist.forEach(System.out::println);
        System.out.println(userlist.size());
        return userlist;
    }

    /**
     * @param pageIndex   页码
     * @param pageSize    每页大小
     * @param useraccount 姓名
     * @param roleid      角色
     * @return
     */
    @RequestMapping("userinfoPageHelper/{pageIndex}/{pageSize}/{useraccount}/{roleid}")
    public List<Userinfo> pagehelper(@PathVariable int pageIndex, @PathVariable int pageSize, @PathVariable String useraccount, @PathVariable("roleid") int roleid) {
        System.out.println(pageIndex + "\t" + pageSize + "\t" + useraccount);
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        if (useraccount.equals("null") || useraccount.equals("")) {
            useraccount = null;
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<Userinfo> userlist = userinfoService.selectAll(useraccount, roleid);
        return userlist;
    }

    /**
     * 根据userid查询单个员工信息
     *
     * @param userid
     * @return
     */
    @RequestMapping("selectUserByID/{userid}")
    public Userinfo selectUserByID(@PathVariable("userid") int userid) {
        return userinfoService.selectByPrimaryKey(userid);
    }


    /**
     * 添加员工
     *
     * @param userinfo
     * @return
     */
    @RequestMapping("insertUser")
    public int insertUser(@RequestBody Userinfo userinfo) {
        return userinfoService.insertSelective(userinfo);
    }

    /**
     * 修改员工
     *
     * @param userinfo
     * @return
     */
    @RequestMapping("uptUser")
    public int updateUser(@RequestBody Userinfo userinfo) {
        return userinfoService.updateByPrimaryKeySelective(userinfo);
    }

    /**
     * 删除员工
     *
     * @param userid
     * @return
     */
    @RequestMapping("deleteUser/{userid}")
    public int deleteUser(@PathVariable("userid") int userid) {
        return userinfoService.deleteByPrimaryKey(userid);
    }

    /**
     * 上传菜品图片
     *
     * @param ：图片文件
     * @param
     * @return
     */
    @RequestMapping("/userGetDishesImg")
    public int userModifyImg(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("userid") int userid, @RequestParam("path") String path, HttpServletRequest request) {
        System.out.println("-----------------provider-- userModifyImg");
        System.out.println("userid: " + userid);
        System.out.println("path: "+path);
        String imgPath = FileUpload.upload(uploadFile, path);
        System.out.println("imgPath="+imgPath);
        Userinfo userinfo = new Userinfo();
        userinfo.setUserid(userid);
        userinfo.setFaceimg(imgPath);
        return userinfoService.updateByPrimaryKeySelective(userinfo);
    }


    /**
     * 根据用户名称查询
     * @param account
     * @return
     */
    @RequestMapping("selectAccount/{account}")
    public Userinfo selectAccount(@PathVariable("account") String account){
        System.out.println("-----------------provider-- selectAccount");
        return userinfoService.selectAccount(account);
    }

    /**
     * 更改登录状态
     * @param userid
     * @param locked
     * @return
     */
    @RequestMapping("updateLocked/{userid}/{locked}")
    public int updateLocked(@PathVariable("userid") int userid,@PathVariable("locked") int locked){
        System.out.println("更改登录状态");
        Userinfo userinfo=new Userinfo(userid,locked);
        return userinfoService.updateByPrimaryKeySelective(userinfo);
    }
}
