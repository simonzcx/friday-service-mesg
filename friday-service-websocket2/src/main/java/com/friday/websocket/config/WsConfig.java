package com.friday.websocket.config;


import com.friday.websocket.handler.CustomWsHandler;
import com.friday.websocket.interceptor.CustomInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

/**
 * @author Simon.z
 * @since 2020-11-27
 */
@Configuration
@EnableWebSocket
public class WsConfig implements WebSocketConfigurer {


    @Value("com.quinn-service.websocket.context-path:/ws")
    private String contextPath;

    @Resource
    private CustomWsHandler customWsHandler;

    @Resource
    private CustomInterceptor customInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customWsHandler, "/ws")
                .addInterceptors(customInterceptor)
                .setAllowedOrigins("*");
    }
}

