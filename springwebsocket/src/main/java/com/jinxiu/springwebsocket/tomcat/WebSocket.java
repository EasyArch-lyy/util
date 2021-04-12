package com.jinxiu.springwebsocket.tomcat;

import com.alibaba.fastjson.JSONObject;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket服务器
 */
@ServerEndpoint("/webSocketByTomcat/{username}")
public class WebSocket {

    private static int onlienCount = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.username = username;
        this.session = session;
        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接");
    }

    @OnClose
    public void onClose() {
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) {
        JSONObject jsonTo = JSONObject.parseObject(message);
        System.out.println(jsonTo.getString("to") + ":" + jsonTo.getString("msg"));
        if (!jsonTo.getString("to").toLowerCase().equals("all")) {
            sendMessageTo(jsonTo.getString("msg"), jsonTo.getString("to"));
        } else {
            sendMessageAll(jsonTo.getString("msg"));
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessageTo(String message, String To) {
        for (WebSocket item : clients.values()) {
            if(item.username.equals(To)){
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public void sendMessageAll(String message) {
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlienCount() {
        return onlienCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlienCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlienCount++;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }
}
