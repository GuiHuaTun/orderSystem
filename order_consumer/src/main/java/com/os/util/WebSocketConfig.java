package com.os.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author haohui
 * @create 2020-05-14 19:45
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //加个setAllowedOrigins("*")，不然可能会报403的错
        webSocketHandlerRegistry.addHandler(handler(),"/myHandler").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler handler(){
        return new MyHandler();
    }
}
