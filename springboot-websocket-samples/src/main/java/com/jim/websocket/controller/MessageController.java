package com.jim.websocket.controller;

import com.jim.websocket.config.WebSocketConfig;
import com.jim.websocket.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

/**
 * Author: Jim
 * Date: 2018/8/7:下午5:44
 * Description:
 */
@ServerEndpoint(value = "/message", configurator = WebSocketConfig.class)
@Slf4j
@Controller
public class MessageController {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        MessageController.applicationContext = context;
    }

    private IMessageService messageService;

    private static final boolean isDebug = log.isDebugEnabled();

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        messageService = applicationContext.getBean(IMessageService.class);
        List<Integer> characters = messageService.getCharacters();
        if (isDebug) {
            log.debug("Receive message: {}", message);
        }
        session.getBasicRemote().sendText(characters.toString());
    }

//    @Scheduled(fixedDelay = 1000)
//    private void sendMessage(){
//        Iterator<Session> sessions = clients.iterator();
//        messageService = applicationContext.getBean(IMessageService.class);
//        List<Integer> characters = messageService.getCharacters();
//        while (sessions.hasNext()){
//            Session session = sessions.next();
//            try {
//                session.getBasicRemote().sendText(characters.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        if (isDebug) {
            log.debug("Add new client, session ID: {}", session.getId());
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        if (isDebug) {
            log.debug("Remove a client, session ID: {}", session.getId());
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        if (isDebug) {
            log.debug(throwable.getMessage());
        }
    }
}
