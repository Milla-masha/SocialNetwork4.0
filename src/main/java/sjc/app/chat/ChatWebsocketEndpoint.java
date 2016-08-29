package sjc.app.chat;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;
import sjc.app.model.vo.MessageSmallVO;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.MessageService;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ServerEndpoint(value = "/chat/{roomId}", configurator = SpringConfigurator.class)
public class ChatWebsocketEndpoint
{
    @Autowired
    private MessageService messageService;
    // private static Logger logger = LoggerFactory.getLogger(ChatWebsocketEndpoint.class);
    // private static String chatTag = "Chat: ";
    private static Map<Session, Long> sessionMap = new HashMap<>();

    @OnOpen
    public void open(@PathParam("roomId") Long roomId, Session session, EndpointConfig endpointConfig)
    {
        sessionMap.put(session, roomId);
        try
        {
            session.getBasicRemote().sendText("Connected to websocket dialog: " + roomId);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(final Session session, final String messageJson)
    {
        Long roomId = sessionMap.get(session);
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {
            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {
                try
                {
                    sessionLongEntry.getKey().getBasicRemote().sendText(messageJson);
                    Gson gson = new Gson();
                    MessageSmallVO messageSmallVO = gson.fromJson(messageJson, MessageSmallVO.class);
                    messageService.addMessage(messageSmallVO.getMessage(), messageSmallVO.getSenderId(), roomId);
                } catch (IOException e)
                {
                    e.printStackTrace();
                } catch (NotFoundExseption notFoundExseption)
                {
                    notFoundExseption.printStackTrace();
                }
                // logger.debug(chatTag + messageJson);
            }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException
    {
        Long roomId = sessionMap.get(session);
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {


            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {
                sessionMap.remove(session);

                //logger.debug(chatTag + reason.toString());

            }
        }
    }

    @OnError
    public void onError(Session session, Throwable ex)
    {
        Long roomId = sessionMap.get(session);
        for (Map.Entry<Session, Long> sessionLongEntry : sessionMap.entrySet())
        {


            if (Objects.equals(sessionLongEntry.getValue(), roomId))
            {

                sessionMap.remove(session);


            }
        }


    }


}
