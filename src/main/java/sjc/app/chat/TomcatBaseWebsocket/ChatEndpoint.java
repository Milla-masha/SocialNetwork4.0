package sjc.app.chat.TomcatBaseWebsocket;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;


/**
 * Created by psycl on 23.08.2016.
 */
@ServerEndpoint(value = "/chat")
public class ChatEndpoint
{
    private Logger log = Logger.getLogger(ChatEndpoint.class.getSimpleName());
    private Room room = Room.getRoom();
    private String sessionId;
    private ObjectMapper mapper = new ObjectMapper();
    private ChatMessage message;
    private JSONParser parser = new JSONParser();


    @OnOpen
    public void open(final Session session, EndpointConfig config) throws IOException
    {
        sessionId = session.getId();
        session.getBasicRemote().sendText("ale eba eto ti??", true);
        config.getUserProperties();
        session.getBasicRemote().sendText(session.getId());
        room.sendMessage("send");
        System.out.println("Session open");
    }

    @OnMessage
    public void onMessage(final Session session, final String jsonMessage)
    {
        JSONObject jObj = new JSONObject(jsonMessage);

        String message = jObj.getString("message");
        String ownerId = jObj.getString("ownerId");
        String reciverId = jObj.getString("reciverId");

        log.info("MESSAGE");


        try
        {
            //chatMessage = mapper.readValue(messageJson, ChatMessage.class);
            session.getBasicRemote().sendText(jsonMessage);
        } catch (IOException e)
        {
            // String message = "Badly formatted message";

        }
        ;

        //Map<String, Object> properties = session.getUserProperties();
/*

        String name = chatMessage.getMessage();
      //  properties.put("name", name);
        room.join(session);
        room.sendMessage(name + " - Joined the chat room");
*/

    }

    @OnClose
    public void onClose(Session session, CloseReason reason)
    {

        log.info("CLOSED");
        room.leave(session);
        room.sendMessage((String) session.getUserProperties().get("name") + " - Left the room");
    }

    @OnError
    public void onError(Session session, Throwable ex)
    {
        log.info("Error: " + ex.getMessage());
    }
}