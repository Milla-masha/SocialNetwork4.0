package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.UserService;

/**
 * Created by psycl on 24.08.2016.
 */

@Controller
@RequestMapping("/dialog")
public class ChatEndpoint
{
    @Autowired
    private UserService userService;
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/get")
    @ResponseBody
    public String getDialog(@RequestParam String senderId, @RequestParam String recieverId)
    {
        InfoUserVO sender = userService.getUserById(senderId);
        InfoUserVO reciever = userService.getUserById(recieverId);
        Long roomId = sender.getId() + reciever.getId();
        //TODO возвращать номер комнаты, сетать MessageEntity(?) или DialogEntity
        return roomId.toString();
    }

}
