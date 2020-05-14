package com.os.contorller;


import com.os.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            session.setAttribute(data[0],userinfo);
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
        int url=restTemplate.postForObject("http://order-provider/uptUser",userinfo,Integer.class);
        return "true";
    }

    /**
     * 图片上传
     * @param uploadFile：上传的图片
     * @param userid：用户编号
     * @param request
     * @return
     */
    @RequestMapping(value = "userModifyImg",method = RequestMethod.POST)
    @ResponseBody
    public String[] userModifyImg(MultipartFile uploadFile, int userid, HttpServletRequest request) throws Exception {
        System.out.println("------------------- uploadImg");
        System.out.println("userid: "+userid);
        ByteArrayResource uFile=new ByteArrayResource(uploadFile.getBytes()){
            @Override
            public long contentLength() {
                return uploadFile.getSize();
            }

            @Override
            public String getFilename() {
                return uploadFile.getOriginalFilename();
            }
        };
        MultiValueMap<String,Object> mvm=new LinkedMultiValueMap<>();
        mvm.add("uploadFile",uFile);
        mvm.add("userid",userid);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String,Object>> requestEntity=new HttpEntity<>(mvm,headers);
        ResponseEntity<Integer> num=restTemplate.postForEntity("http://order-provider/userGetDishesImg",requestEntity,Integer.class);
        System.out.println("num: "+num);
        String[] str=new String[]{"true"};
        return str;
    }
}
