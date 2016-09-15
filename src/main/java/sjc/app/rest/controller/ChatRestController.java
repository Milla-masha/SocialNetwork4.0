package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.service.UserService;

/**
 * Created by psycl on 24.08.2016.
 */

@RestController
@RequestMapping("/dialog")
public class ChatRestController
{
    @Autowired
    private UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/get")
    @ResponseBody
    public Long getDialog(@RequestParam String senderId, @RequestParam String recieverId)
    {
        InfoUserVO sender = userService.getUserById(senderId);
        InfoUserVO reciever = userService.getUserById(recieverId);
        Long roomId = sender.getId() + reciever.getId();
        //TODO возвращать номер комнаты, сетать MessageEntity(?) или DialogEntity
        return roomId;
    }

}