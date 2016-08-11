package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.FriendService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/friends")
public class FriendEndpointImpl
{
    @Autowired
    private FriendService friendService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getFriend(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(friendService.getFriends(userId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET, offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT, limit.toString());
        paginationResponse.addMetadata(Constant.COUNT, friendService.getCountFriends(userId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseSuccessful addFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        response.setEntity(friendService.addFriend(userId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseSuccessful deleteFriend(@RequestParam Long userId, HttpServletRequest request)
    {
        response.setEntity(friendService.deleteFriend(userId, request.getUserPrincipal().getName()));
        return response;
    }
}
