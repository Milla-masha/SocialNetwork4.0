package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.service.FriendService;
import sjc.app.service.PostUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psycl on 30.08.2016.
 */

@Controller
@RequestMapping("/feed")
public class FeedEndpoint
{
    @Autowired
    private PostUserService postUserService;
    @Autowired
    private FriendService friendService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody

    public List getFeed(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {

        List<UserSmallVO> users = friendService.getFriends(userId, offset, limit);

        List<PostVO> posts = new ArrayList<>();

        for (UserSmallVO user : users)
        {
            posts.add(postUserService.getUsersLatestPost(user.getId(), user.getName()));
        }
        return posts;

    }
}
