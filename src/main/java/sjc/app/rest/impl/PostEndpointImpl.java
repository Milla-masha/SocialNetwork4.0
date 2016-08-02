package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.rest.PostEndpoint;
import sjc.app.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Controller
@RequestMapping("/posts")
public class PostEndpointImpl implements PostEndpoint{

    @Autowired
    private PostService postService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getPosts(@RequestParam Long userId,@RequestParam Integer offset,@RequestParam Integer limit) {
        return Response.ok(postService.getPosts(userId,offset,limit)).build();
    }

}
