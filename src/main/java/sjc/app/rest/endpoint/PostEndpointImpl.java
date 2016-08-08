package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/posts")
public class PostEndpointImpl
{
    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getPosts(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(postService.getPosts(userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Response addPosts(@RequestBody PostSmallVO post, HttpServletRequest request)
    {
        return Response.ok(postService.addPost(post, request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Response deletePost(@RequestParam Long postId, HttpServletRequest request)
    {
        return Response.ok(postService.deletePost(postId, request.getUserPrincipal().getName())).build();
    }
}
