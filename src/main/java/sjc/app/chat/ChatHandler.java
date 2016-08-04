package sjc.app.chat;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by psycl on 03.08.2016.
 */
public class ChatHandler extends TextWebSocketHandler {

    private final static Logger logger = LoggerFactory.getLogger(ChatHandler.class);
    private final static Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("User has left the chat");

        super.afterConnectionClosed(session, status);
        sessions.remove(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("New user has joined the chat");

        super.afterConnectionEstablished(session);
        sessions.add(session);
    }

    public void sendMessage(final String message) throws IOException {
        logger.info("Sending message to all participants");

        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            } else {
                sessions.remove(session);
            }
        }
    }
}