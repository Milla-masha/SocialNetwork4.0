package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.rest.response.PaginationResponseOk;
import sjc.app.rest.response.ResponseOk;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.PostUserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users/posts")
public class PostUserEndpointImpl
{
    @Autowired
    private PostUserService postUserService;
    private PaginationResponseOk paginationResponse=new PaginationResponseImpl();
    private ResponseOk response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseOk getPostsUser(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {
        System.out.println(request.getRequestURL());
        paginationResponse.setEntity(postUserService.getPostsUser(userId, offset, limit));
        paginationResponse.buildMetadata(offset,limit, postUserService.getCountPostsUser(userId));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseOk addPostsUser(@RequestBody PostSmallVO post, HttpServletRequest request)
    {
        response.setEntity(postUserService.addPostUser(post, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseOk deletePostUser(@RequestParam Long postId, HttpServletRequest request)
    {
        response.setEntity(postUserService.deletePostUser(postId, request.getUserPrincipal().getName()));
        return response;
    }
}
