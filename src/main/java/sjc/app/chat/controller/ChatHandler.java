package sjc.app.chat.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by psycl on 11.08.2016.
 */
public class ChatHandler extends TextWebSocketHandler
{
    protected void handleTextMessage(
            WebSocketSession session, TextMessage message) throws Exception
    {
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("Polo!"));
    }
}