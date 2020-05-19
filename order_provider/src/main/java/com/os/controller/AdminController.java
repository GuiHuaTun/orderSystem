package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import com.os.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author R
 * @date 2020/5/16 - 17:08
 */
@RestController
public class AdminController {

    @Autowired
    private UserinfoService userinfoService;


    @RequestMapping("adminGetUserImg")
    public String adminGetUserImg(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("path") String path, HttpServletRequest request) {
        System.out.println("-----------------provider-- userModifyImg");
        System.out.println("path: " + path);
        String imgPath = FileUpload.upload(uploadFile, path);
        return imgPath;
    }

    @RequestMapping("searchOnlinePeople/{pageIndex}/{pageSize}/{roleid}")
    public List searchOnlinePeople(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize, @PathVariable("roleid") int roleid) {
        int size = userinfoService.selectUserByRoleId(0).size();
        int pageCount = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
        List<Userinfo> totality = userinfoService.selectUserByRoleId(roleid);
        PageHelper.startPage(pageIndex, pageSize);
        List<Userinfo> userinfoList = userinfoService.selectUserByRoleId(roleid);
        List list = new ArrayList();
        list.add(userinfoList);
        list.add(size);
        list.add(totality.size());
        list.add(pageCount);
        return list;
    }

}
