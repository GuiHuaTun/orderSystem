package com.os.util;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haohui
 * @create 2020-05-14 19:55
 */
@Service
public class MyHandler extends TextWebSocketHandler {
    //在线用户列表
    private static final Map<String, WebSocketSession> users;

    //用户标识
    public static final String CLIENT_ID="username";

    //用户数量
    private static final int size=200;

    static {
        users=new ConcurrentHashMap<String,WebSocketSession>(size);
    }

    /**
     * 建立websocket连接时调用该方法
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("成功建立连接");
        String username=getClientId(session);
        System.out.println("username=getClientId(session): "+username);
        if(username!=null){
            users.put(username,session);
            System.out.println("users: "+users.keySet());
            for (String key : users.keySet()) {
                System.out.println("user session: "+users.get(key).getAttributes().get(CLIENT_ID));
            }
            //session.sendMessage(new TextMessage("成功建立socket连接"));
            System.out.println("username: "+username);
            System.out.println("session: "+session);
        }
    }

    /**
     * 客户端调用websocket.send时，会调用该方法，进行数据通信
     * @param session
     * @param message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("handleTextMessage");
        System.out.println("message.getPayload(): "+message.getPayload());

        WebSocketMessage wsMessage=new TextMessage("server: "+message.getPayload());
        try {
            session.sendMessage(wsMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 传输过程中出现异常时，调用该方法
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("handleTransportError");
        if(session.isOpen()){
            session.close();
        }
        System.out.println("连接出错");
        users.remove(getClientId(session));
    }

    /**
     * 关闭websocket是调用该方法
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("afterConnectionClosed");
        System.out.println("连接已关闭: "+status);
        users.remove(getClientId(session));
    }

    /**
     *
     * @return
     */
    @Override
    public boolean supportsPartialMessages() {
        System.out.println("supportsPartialMessages");
        return false;
    }

    /**
     * 发送消息给指定用户
     * @param clientId
     * @param message
     * @return
     */
    public boolean sendMessageToUser(String clientId, TextMessage message){
        System.out.println("sendMessageToUser");
        if(users.get(clientId)==null){
            System.out.println("users.get(clientId)==null");
            return false;
        }
        WebSocketSession session=users.get(clientId);
        System.out.println("sendMessage: "+session);
        if(!session.isOpen()){
            System.out.println("!session.isOpen()");
            return false;
        }
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 广播消息
     * @param message
     * @return
     */
    public boolean sendMessageToAllUsers(TextMessage message){
        System.out.println("sendMessageToAllUsers");
        boolean allSendSuccess=true;
        Set<String> clientIds=users.keySet();
        WebSocketSession session=null;
        for (String clientId : clientIds) {
            try {
                session=users.get(clientId);
                if(session.isOpen()){
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                allSendSuccess=false;
            }
        }
        return allSendSuccess;
    }

    /**
     * 获取用户id
     * @param session
     * @return
     */
    private String getClientId(WebSocketSession session){
        System.out.println("getClientId");
        try {
            String clientId= (String) session.getAttributes().get(CLIENT_ID);
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }
}
