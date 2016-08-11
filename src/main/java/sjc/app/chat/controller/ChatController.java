package sjc.app.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sjc.app.chat.Message;
import sjc.app.chat.OutputMessage;

import java.util.Date;

/**
 * Created by psycl on 08.08.2016.
 */
@Controller
@RequestMapping("/")
public class ChatController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewApplication() {
        return "index";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public OutputMessage sendMessage(Message message) {

        return new OutputMessage(message, new Date());

    }
    @MessageMapping("/usermessage")
    @SendToUser("/queue/message")
    public  OutputMessage sendToUser(Message message){
        return new OutputMessage(message, new Date());
    }

}