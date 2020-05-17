package com.os.controller;

import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import com.os.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
        System.out.println("path: "+path);
        String imgPath = FileUpload.upload(uploadFile, path);
        return imgPath;
    }


}
