package sjc.app.chat;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * Created by psycl on 04.08.2016.
 */
public class WebSocketOutMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketOutMessageListener.class);
    private ChatHandler webSocketHandler;

    public void setWebSocketHandler(ChatHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }


    @Override
    public void onMessage(javax.jms.Message message) {
        if (message instanceof TextMessage) {TextMessage textMessage = (TextMessage) message;
try {
webSocketHandler.sendMessage(textMessage.getText());
} catch (JMSException | IOException ex) {
logger.error(ex.getMessage(), ex);
}
}
    }
}