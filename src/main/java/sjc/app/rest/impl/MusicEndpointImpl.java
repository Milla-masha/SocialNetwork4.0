package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.MusicService;
import sjc.app.rest.MusicEndpoint;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/musics")
public class MusicEndpointImpl implements MusicEndpoint {

    @Autowired
    private MusicService musicService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getMusic(@RequestParam Long userId,@RequestParam Integer offset,@RequestParam Integer limit) {
        return Response.ok(musicService.getMusics(userId,offset,limit)).build();
    }


}
