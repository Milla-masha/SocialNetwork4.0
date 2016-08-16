/*
package sjc.app.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sjc.app.chat.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * Created by psycl on 08.08.2016.
 *//*

@Controller
@RequestMapping("/")
public class ChatController
{
    @Autowired
    SimpMessagingTemplate simpMessagingtemplate;

    */
/*public void setSimpMessagingTemplate(SimpMessagingTemplate template){
        simpMessagingtemplate = template;
    }*//*



    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public Message send(Message message) throws Exception
    {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        Message resp = new Message(message.getText());

        return resp;
    }

  */
/*  @RequestMapping(method = RequestMethod.POST)
    public String viewApplication()
    {
        return "index";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public OutputMessage sendMessage(Message message)
    {
        return new OutputMessage(message, new Date());
    }

    @MessageMapping("/user")
    @SendToUser("/app/chat")
    public OutputMessage sendToUser(Message message)
    {
        return new OutputMessage(message, new Date());
    }

    @MessageMapping("/notification")
    @SendToUser("/queue/notifications")
    public OutputMessage handleSpittle(Principal principal, Message message)
    {
        message.setText(principal.getName());
        return new OutputMessage(message, new Date());
    }

*//*


}*/
