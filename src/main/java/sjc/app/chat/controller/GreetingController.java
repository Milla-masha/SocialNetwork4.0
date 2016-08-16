package sjc.app.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import sjc.app.chat.Greeting;
import sjc.app.chat.HelloMessage;

import java.security.Principal;

/**
 * Created by psycl on 16.08.2016.
 */
@Controller
public class GreetingController
{


    SimpMessagingTemplate simpMessagingtemplate;
    @Autowired
    public void setSimpMessagingtemplate(SimpMessagingTemplate simpMessagingtemplate)
    {
        this.simpMessagingtemplate = simpMessagingtemplate;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public Greeting greeting(HelloMessage message, Principal principal) throws Exception
    {
        Thread.sleep(3000); // simulated delay
        return new Greeting(message.getName()+" " + principal.getName() + "!");
    }
    @SubscribeMapping("/user")
    @SendToUser("/queue/message")
    public Greeting toUser(HelloMessage message, Principal principal) throws Exception
    {
       Greeting greeting = new Greeting(message.getName());
        String destination = "/queue/notifications";
        return greeting;
    }

}