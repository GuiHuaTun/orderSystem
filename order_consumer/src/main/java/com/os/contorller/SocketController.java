package com.os.contorller;

import com.os.util.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

/**
 * @author haohui
 * @create 2020-05-14 20:48
 */
@Controller
public class SocketController {
    @Autowired
    MyHandler handler;

    @RequestMapping("/testLogin/{username}")
    @ResponseBody
    public String testLogin(HttpSession session, @PathVariable("username") String username){
        System.out.println("登录接口，username= "+username);
        session.setAttribute("username",username);
        System.out.println(session.getAttribute("username"));
        return "true";
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(){
        System.out.println("广播");
        boolean flag=handler.sendMessageToAllUsers(new TextMessage("全体起立"));
        System.out.println("flag: "+flag);
        return "广播";
    }

    @RequestMapping("/sendMessageToUser/{username}/{contents}")
    @ResponseBody
    public String sendMessageToUser(@PathVariable("username") String username,@PathVariable("contents") String contents){
        System.out.println("指定用户发送");
        boolean flag=handler.sendMessageToUser(username,new TextMessage(contents));
        System.out.println("flag: "+flag);
        return contents;
    }
}
