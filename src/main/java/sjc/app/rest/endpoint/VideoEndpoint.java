package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.VideoService;

@Controller
@RequestMapping("/videos")
public class VideoEndpoint
{
    @Autowired
    private VideoService videoService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getVideos(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(videoService.getVideos(userId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,videoService.getCountVideosUser(userId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{videoId}")
    @ResponseBody
    public ResponseSuccessful getVideo(@PathVariable Long videoId) throws NotFoundExseption
    {
        response.setEntity(videoService.getVideo(videoId));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful addVideoToUser(@RequestParam String url) throws AlreadyExsistsException, NotFoundExseption
    {
        response.setEntity(videoService.addVideoToUser(url, SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", value = "/{idVideo}")
    @ResponseBody
    public ResponseSuccessful deleteVideoToUser(@PathVariable Long idVideo) throws NotFoundExseption
    {
        response.setEntity(videoService.deleteVideoToUser(idVideo, SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }
}
