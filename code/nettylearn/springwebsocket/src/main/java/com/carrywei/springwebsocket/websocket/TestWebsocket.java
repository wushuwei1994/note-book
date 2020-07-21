package com.carrywei.springwebsocket.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by wushuwei on 2020/5/14.
 * 描述：
 */
@ServerEndpoint("/ws/test/{webSocketKey}")
@Component
public class TestWebsocket {
    @OnOpen
    public void onOpen(@PathParam("webSocketKey") String webSocketKey, Session session) {
        System.out.println("websocket打开");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("websocket错误");
    }

    @OnClose
    public void onClose() {
        System.out.println("websocket关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到消息:" + message);
    }
}
