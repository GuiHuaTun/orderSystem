package com.os.util;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author haohui
 * @create 2020-05-14 20:39
 */
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> map) throws Exception {
        System.out.println("WebSocketInterceptor  beforeHandshake");
        if(request instanceof ServletServerHttpRequest){
            ServletServerHttpRequest serverHttpRequest= (ServletServerHttpRequest) request;
            HttpSession session=serverHttpRequest.getServletRequest().getSession();
            if(session!=null){
                System.out.println("WebSocketInterceptor  "+session.getAttribute("username"));
                map.put("username",session.getAttribute("username"));
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("WebSocketInterceptor  afterHandshake");
    }
}
