package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.response.PaginationResponseOk;
import sjc.app.rest.response.ResponseOk;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.FriendService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/friends")
public class FriendEndpointImpl
{
    @Autowired
    private FriendService friendService;
    private PaginationResponseOk paginationResponse=new PaginationResponseImpl();
    private ResponseOk response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    @ResponseBody
    public Response findFriend(@RequestParam String name, @PathVariable Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(friendService.findFriends(name, userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseOk getFriend(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(friendService.getFriends(userId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,friendService.getCountFriends(userId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseOk addFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        response.setEntity(friendService.addFriend(userId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseOk deleteFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        response.setEntity(friendService.deleteFriend(userId, request.getUserPrincipal().getName()));
        return response;
    }
}
