package com.jinxiu.springwebsocket.tomcat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务端推送消息对客户端
 */
@Controller
@RequestMapping(value = "/webSocketByTomcat/serviceToClient")
public class ServiceClientByTomcatController {

    private WebSocket webSocket = new WebSocket();

    @RequestMapping
    public void sendMsg(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("to", request.getSession().getId());
        jsonObject.put("msg", "欢迎连接WebSocket!");
        webSocket.onMessage(jsonObject.toJSONString());
    }
}
