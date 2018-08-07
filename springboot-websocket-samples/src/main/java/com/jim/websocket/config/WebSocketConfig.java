package com.jim.websocket.config;

import org.apache.tomcat.websocket.server.DefaultServerEndpointConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Author: Jim
 * Date: 2018/8/6:上午10:50
 * Description:
 */
@Configuration
@EnableWebSocket
@EnableScheduling
public class WebSocketConfig extends DefaultServerEndpointConfigurator {

    @Bean
    public ServerEndpointExporter serverPointExporter(){
        return new ServerEndpointExporter();
    }
}
