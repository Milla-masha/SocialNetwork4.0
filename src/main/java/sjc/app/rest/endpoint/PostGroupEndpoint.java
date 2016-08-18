package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.model.vo.LikeVO;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.LikeService;
import sjc.app.service.PostGroupService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/groups/posts")
public class PostGroupEndpoint
{
    @Autowired
    private PostGroupService postGroupService;
    @Autowired
    private LikeService likeService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getPostsUser(@RequestParam Long groupId, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,postGroupService.getCountPostsByGroup(groupId).toString());
        paginationResponse.setEntity(postGroupService.getPostsGroup(request.getUserPrincipal().getName(),groupId, offset, limit));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful addPostsUser(@RequestBody PostSmallVO post, HttpServletRequest request)
    {
        response.setEntity(postGroupService.addPostGroup(post, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseSuccessful deletePostUser(@RequestParam Long postId, HttpServletRequest request)
    {
        response.setEntity(postGroupService.deletePostGroup(postId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/{idPost}/likes")
    @ResponseBody
    public ResponseSuccessful addLikeToPostsGroup(@RequestBody LikeVO like, @PathVariable Long idPost, HttpServletRequest request)
    {
        response.setEntity(likeService.addLikeToPostGroup(like, idPost, request.getUserPrincipal().getName()));
        return response;
    }
}
