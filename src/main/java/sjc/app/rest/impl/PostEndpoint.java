package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.PostService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/posts")
public class PostEndpoint {

    @Autowired
    private PostService postService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getPosts(@PathVariable Long idUser, @PathVariable Integer offset, @PathVariable Integer limit) {
        return Response.ok(postService.getPosts(idUser, offset, limit)).build();
    }
}
