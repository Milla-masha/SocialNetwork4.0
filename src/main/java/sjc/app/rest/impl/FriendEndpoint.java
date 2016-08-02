package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.UserService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/friends")
public class FriendEndpoint
{
    @Autowired
    private UserService friendService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value ="/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getFriend(@PathVariable Long idUser,@PathVariable Integer offset,@PathVariable Integer limit) {
        return Response.ok(friendService.findFriends(idUser,offset,limit)).build();
    }
}
