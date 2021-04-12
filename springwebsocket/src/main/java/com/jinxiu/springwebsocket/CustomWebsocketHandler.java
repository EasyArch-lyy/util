package com.jinxiu.springwebsocket;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * WebSocket server
 */
@Service
public class CustomWebsocketHandler extends TextWebSocketHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWebsocketHandler.class);

    // 在线用户列表
    private static final Map<String, WebSocketSession> users;

    // 用户标识
    private static final String CLIENT_ID = "test1";

    static {
        users = new HashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        LOGGER.info("成功建立websocket-spring连接");
        String mchNo = getMchNo(session);
        if (StringUtils.isEmpty(mchNo)) {
            users.put(mchNo, session);
            session.sendMessage(new TextMessage("成功建立websocket-spring连接"));
            LOGGER.info("用户标识:{},Session:{}", mchNo, session.toString());
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        LOGGER.info("收到客户端消息:{}", message.getPayload());
        JSONObject msgjson = JSONObject.parseObject(message.getPayload());
        String to = msgjson.getString("to");
        String msg = msgjson.getString("msg");
        WebSocketMessage<?> webSocketMessage = new TextMessage("server:" + message);
        try {
            session.sendMessage(webSocketMessage);
            if ("all".equals(to.toLowerCase())) {
                sendMessageToAllUsers(new TextMessage(getMchNo(session) + ":" + msg));
            } else {
                sendMessageToUser(to, new TextMessage(getMchNo(session) + ":" + msg));
            }
        } catch (IOException e) {
            LOGGER.error("handleTextMessage method error:{}", e);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws IOException {
        if (session.isOpen()) {
            session.close();
        }
        LOGGER.error("连接出错");
        users.remove(getMchNo(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        LOGGER.info("连接已关闭:" + status);
        users.remove(getMchNo(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessage(String jsonData) {
        LOGGER.info("收到客户端消息sendMessage:{}", jsonData);
        JSONObject msgJson = JSONObject.parseObject(jsonData);
        String mchNo = StringUtils.isEmpty(msgJson.getString("CLIENT_ID")) ? "陌生人" : msgJson.getString("CLIENT_ID");
        String to = msgJson.getString("to");
        String msg = msgJson.getString("msg");
        if ("all".equals(to.toLowerCase())) {
            sendMessageToAllUsers(new TextMessage(mchNo + ":" + msg));
        } else{
            sendMessageToUser(to, new TextMessage(mchNo + ":" + msg));
        }
    }

    public boolean sendMessageToUser(String mchNo, TextMessage message) {
        if (users.get(mchNo) == null) {
            return false;
        }
        WebSocketSession session = users.get(mchNo);
        LOGGER.info("sendMessage:{}, msg:{}", session, message.getPayload());
        if (!session.isOpen()) {
            LOGGER.info("客户端:{}连接断开，发送消息失败", mchNo);
            return false;
        }
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            LOGGER.error("sendMessageToUser method error:{}", e);
            return false;
        }
        return true;
    }

    public boolean sendMessageToAllUsers(TextMessage message) {
        boolean allSendSuccess = true;
        Set<String> mchNos = users.keySet();
        WebSocketSession session = null;
        for (String mchNo : mchNos) {
            try {
                session = users.get(mchNo);
                if (session.isOpen()) {
                    session.sendMessage(message);
                } else {
                    LOGGER.error("客户端:{}连接断开，发送消息失败", mchNo);
                }
            } catch (IOException e) {
                LOGGER.error("sendMessageToAllUsers method error：{}", e);
                allSendSuccess = false;
            }
        }
        return allSendSuccess;
    }

    private String getMchNo(WebSocketSession session) {
        String mchNo = session.getAttributes().get(CLIENT_ID).toString();
        return mchNo;
    }
}
