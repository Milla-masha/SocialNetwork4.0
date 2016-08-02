package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.VideoService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/videos")
public class VideoEndpoint {
    @Autowired
    private VideoService videoService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getVideos(@PathVariable Long idUser, @PathVariable Integer offset, @PathVariable Integer limit) {
        return Response.ok(videoService.getVideos(idUser, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idVideo}")
    @ResponseBody
    public Response getVideo(@PathVariable Long idVideo) {
        return Response.ok(videoService.getVideo(idVideo)).build();
    }
}
