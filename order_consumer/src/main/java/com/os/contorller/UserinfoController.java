package com.os.contorller;


import com.os.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author R
 * @date 2020/5/7 - 17:13
 */
@Controller
public class UserinfoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "loginUser/{useraccount}/{userpass}/{codetext}", method = RequestMethod.POST)
    @ResponseBody
    public String login(@PathVariable("useraccount") String useraccount, @PathVariable("userpass") String userpass,
                        @PathVariable("codetext") String codetext, HttpSession session, HttpServletResponse response) throws Exception{
        String checkCodes = (String) session.getAttribute("checkCodes");
        System.out.println(checkCodes);
        System.out.println(codetext+"\t"+useraccount+"\t"+userpass);
        /*if (!(checkCodes.toLowerCase().equals(codetext.toLowerCase()))) {
            //System.out.println("验证码错误");
            return "1";
        }*/
        Userinfo userinfo=new Userinfo(useraccount,userpass);
        userinfo= restTemplate.postForObject("http://order-provider/login",userinfo, Userinfo.class);
        System.out.println(userinfo);
        return "login";
    };
}
