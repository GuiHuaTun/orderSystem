package com.os.contorller;

import com.os.util.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author haohui
 * @create 2020-05-14 20:48
 */
@Controller
public class SocketController {
    private String message=null;


    @Autowired
    MyHandler handler;

    /**
     * 在WebSocket中注册用户
     * @param session
     * @param username：用户名
     * @return
     */
    @RequestMapping("/webSocketLogin/{username}")
    @ResponseBody
    public String testLogin(HttpSession session, @PathVariable("username") String username){
        System.out.println("登录接口，username= "+username);
        session.setAttribute("username",username);
        System.out.println(session.getAttribute("username"));
        return "true";
    }

    /**
     * 广播
     * @return
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(){
        System.out.println("广播");
        boolean flag=handler.sendMessageToAllUsers(new TextMessage("全体起立"));
        System.out.println("flag: "+flag);
        return "广播";
    }

    /**
     * 给指定用户发送消息
     * @param username：用户名
     * @param contents：消息内容
     * @return
     */
    @RequestMapping("/sendMessageToUser/{username}/{contents}")
    @ResponseBody
    public String sendMessageToUser(@PathVariable("username") String username,@PathVariable("contents") String contents){
        System.out.println("指定用户发送");
        boolean flag=handler.sendMessageToUser(username,new TextMessage(contents));
        message=contents;
        System.out.println("flag: "+flag);
        return "true";
    }

    @RequestMapping("getIp")
    @ResponseBody
    public String[] getIp(){
        String[] ip=new String[1];
        try {
            ip[0]= Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(ip[0]);
        return ip;
    }

    @RequestMapping("/getMessage")
    @ResponseBody
    public String[] getMessage(){
        String[] msg=new String[]{message};
        message=null;
        return msg;
    }
}
