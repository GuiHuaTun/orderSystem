package com.os.contorller;


import com.os.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author R
 * @date 2020/5/7 - 17:13
 */
@Controller
public class UserinfoController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @param useraccount 账号
     * @param userpass    密码
     * @param codetext    验证码
     * @return json类型String数组
     */
    @RequestMapping(value = "loginUser/{useraccount}/{userpass}/{codetext}", method = RequestMethod.POST)
    @ResponseBody
    public String[] login(@PathVariable("useraccount") String useraccount, @PathVariable("userpass") String userpass,
                          @PathVariable("codetext") String codetext, HttpSession session,HttpServletRequest request) {
        String checkCodes = (String) session.getAttribute("checkCodes");
        String[] data = new String[1];
        System.out.println(checkCodes);
        System.out.println(codetext + "\t" + useraccount + "\t" + userpass);
        if (!(checkCodes.toLowerCase().equals(codetext.toLowerCase()))) {
            System.out.println("codeError");
            data[0] = "codeError";
            return data;
        }
        Userinfo userinfo = new Userinfo(useraccount, userpass);
        userinfo = restTemplate.postForObject("http://order-provider/login", userinfo, Userinfo.class);

        System.out.println(userinfo);
        if (userinfo == null) {
            data[0] = "false";
        } else {
            session.setAttribute("userInfo",userinfo);
            switch (userinfo.getRoleinfo().getRoleid()) {
                case 1://后厨
                    data[0] = "chef";
                    break;
                case 2://管理员
                    System.out.println("admin");
                    data[0] = "admin";
                    break;
                case 3://点餐员
                    System.out.println("waiter");
                    data[0] = "waiter";
                    break;
            }
        }
        return data;
    }

    @RequestMapping("userinfomation")
    @ResponseBody
    public Userinfo userinfoMation(HttpSession session){
        Userinfo userinfo= (Userinfo) session.getAttribute("userInfo");
        System.out.println(userinfo);
        return userinfo;
    }


    /**
     * 页面跳转
     * @param url 路径
     * @return
     */
    @RequestMapping("URL/{url}")
    public String gotoURL(@PathVariable("url") String url){
     return "/pages/page/"+url;
    }


    /**
     * 修改信息
     * @param userinfo
     * @return
     */
    @RequestMapping(value = "modifyuser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUserInfo(Userinfo userinfo){
        System.out.println(userinfo);
        String url=restTemplate.postForObject("http://order-provider/dishesGetDishesImg",userinfo.getFaceimg(),String.class);
        return "true";
    }



    @RequestMapping(value = "uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String[] uploadimg(MultipartFile uploadFile, int userid, HttpServletRequest request){
        System.out.println("userid: "+userid);
        String originalname=uploadFile.getOriginalFilename();//获取pic的文件名
        System.out.println("originalname: "+originalname);
        String imgname= UUID.randomUUID().toString();//生成随机数用于组成文件名
        System.out.println("imgname_UUID"+imgname);
        String extraname=originalname.substring(originalname.lastIndexOf("."));//截取pic的后缀名
        System.out.println("extraname: "+extraname);
        String dishesimg=imgname+extraname;//新组成的文件名
        String path=request.getServletContext().getRealPath("/img/upload");//获取上传文件夹/img/upload的绝对路径
        System.out.println("path: "+path);
        String imgPath="/img/upload/"+dishesimg;//生成图片在项目中的相对路径
        System.out.println("imgPath: "+imgPath);
        File file=new File(path+"/"+dishesimg);//生成文件
        if(!file.getParentFile().exists()){//判断上传文件夹upload是否存在
            file.getParentFile().mkdirs();//创建上传文件夹upload文件夹
        }
        try {
            uploadFile.transferTo(file);//将pic文件转到file文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        Userinfo userinfo=new Userinfo();
        userinfo.setUserid(userid);
        userinfo.setFaceimg(imgPath);
        int num=restTemplate.postForObject("http://order-provider/uptUser",userinfo,Integer.class);
        if(num>0){
            String[] str=new String[]{"true"};
            return str;
        }
        String[] str=new String[]{"false"};
        return str;
    }
}
