package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.rest.response.PaginationResponseOk;
import sjc.app.rest.response.ResponseOk;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.PostGroupService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/groups/posts")
public class PostGroupEndpoint
{
    @Autowired
    private PostGroupService postGroupService;
    private PaginationResponseOk paginationResponse=new PaginationResponseImpl();
    private ResponseOk response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseOk getPostsUser(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        //TODO
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,postGroupService.getCountPostsByGroup(userId).toString());
        paginationResponse.setEntity(postGroupService.getPostsGroup(userId, offset, limit));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseOk addPostsUser(@RequestBody PostSmallVO post, HttpServletRequest request)
    {
        response.setEntity(postGroupService.addPostGroup(post, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseOk deletePostUser(@RequestParam Long postId, HttpServletRequest request)
    {
        response.setEntity(postGroupService.deletePostGroup(postId, request.getUserPrincipal().getName()));
        return response;
    }
}
