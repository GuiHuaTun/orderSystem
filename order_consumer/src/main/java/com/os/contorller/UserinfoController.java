package com.os.contorller;


import com.os.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            request.getSession().setAttribute("user_info",userinfo);
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
}
