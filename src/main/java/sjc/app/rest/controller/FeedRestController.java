package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.FriendVO;
import sjc.app.model.vo.GroupVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.service.FriendService;
import sjc.app.service.GroupService;
import sjc.app.service.PostGroupService;
import sjc.app.service.PostUserService;
import sjc.app.service.impl.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psycl on 30.08.2016.
 */
@RestController
@RequestMapping("/feed")
public class FeedRestController
{
    @Autowired
    private PostUserService postUserService;
    @Autowired
    private PostGroupService postGroupService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private GroupService groupService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(name = "/feed", method = RequestMethod.GET)
    @ResponseBody

    public List getFeed(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {

        List<FriendVO> users = friendService.getFriends(request.getUserPrincipal().getName(),userId,offset,limit);
        List<GroupVO> groups = groupService.getGroups(userId, offset, limit, request.getUserPrincipal().getName());

        List<PostVO> posts = new ArrayList<>();
        PostVO postFromUser;
        PostVO postFromGroup;
        for (UserSmallVO user : users)
        {

            postFromUser = postUserService.getUsersLatestPosts(user.getId());

            if (postFromUser.getId() != null)
            {
                posts.add(postFromUser);
            }

        }
        for (GroupVO group : groups)
        {

            postFromGroup = postGroupService.getGroupLatestPost(group.getId(), group.getName());
            if (postFromGroup.getId() != null)
            {
                posts.add(postFromGroup);
            }

        }

        posts.sort((PostVO post1, PostVO post2) -> post1.getDate().compareTo(post2.getDate()));
        Pageable p = new Pageable(posts);
        p.getPage();
        // ListUtils.partition(posts, limit);
        return posts;


    }
}
