package com.jinxiu.springwebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * WebSocket握手时的拦截器
 */
public class CustomWebSocketInterceptor  implements HandshakeInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWebSocketInterceptor.class);

    /**
     * 关联HeepSession和WebSocketSession，
     * beforeHandShake方法中的Map参数 就是对应websocketSession里的属性
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            LOGGER.info("****beforeHandleshake");
            HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
            HttpSession session = httpServletRequest.getSession(true);
            LOGGER.info("mchNo:{}", httpServletRequest.getParameter("mchNo"));
            if (session != null) {
                map.put("sessionId", session.getId());
                map.put("mchNo", httpServletRequest.getParameter("mchNo"));
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        LOGGER.info("*****afterHandShake****");
    }
}
