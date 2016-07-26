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
    @RequestMapping(method = RequestMethod.GET, value ="/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getMusic(@PathVariable Long idUser,@PathVariable Integer offset,@PathVariable Integer limit) {
        return Response.ok(musicService.getMusics(idUser,offset,limit)).build();
    }


}
