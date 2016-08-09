package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.service.PostUserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/users/posts")
public class PostUserEndpointImpl
{
    @Autowired
    private PostUserService postUserService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getPostsUser(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(postUserService.getPostsUser(userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Response addPostsUser(@RequestBody PostSmallVO post, HttpServletRequest request)
    {
        return Response.ok(postUserService.addPostUser(post, request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Response deletePostUser(@RequestParam Long postId, HttpServletRequest request)
    {
        return Response.ok(postUserService.deletePostUser(postId, request.getUserPrincipal().getName())).build();
    }
}
