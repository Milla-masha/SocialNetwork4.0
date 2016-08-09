package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.FriendService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/friends")
public class FriendEndpointImpl
{
    @Autowired
    private FriendService friendService;

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public Response findFriend(@RequestParam String name, @RequestParam Integer offset, @RequestParam Integer limit)
//    {
//      //  return Response.ok(friendService.findFriends(name, offset, limit)).build();
//   return null;
//    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getFriend(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(friendService.getFriends(userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response addFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        return Response.ok(friendService.addFriend(userId, request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        return Response.ok(friendService.deleteFriend(userId, request.getUserPrincipal().getName())).build();
    }
}
