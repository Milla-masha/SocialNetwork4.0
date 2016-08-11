package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.VideoService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/videos")
public class VideoEndpointImpl
{
    @Autowired
    private VideoService videoService;
    private PaginationResponseSuccessful paginationResponse=new PaginationResponseImpl();
    private ResponseSuccessful response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getVideos(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(videoService.getVideos(userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{videoId}")
    @ResponseBody
    public Response getVideo(@PathVariable Long videoId)
    {
        return Response.ok(videoService.getVideo(videoId)).build();
    }
}
