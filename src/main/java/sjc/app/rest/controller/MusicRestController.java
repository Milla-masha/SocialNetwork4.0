package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.MusicService;

@RestController
@RequestMapping("/musics")
public class MusicRestController
{

    @Autowired
    private MusicService musicService;
    private PaginationResponseSuccessful paginationResponse=new PaginationResponseImpl();
    private ResponseSuccessful response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getMusic(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(musicService.getMusics(userId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,musicService.getCountMusicsUser(userId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful addMusicToUser(@RequestParam String url) throws NotFoundExseption, AlreadyExsistsException
    {
        response.setEntity(musicService.addMusicToUser(url, SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", value = "/{idMusic}")
    @ResponseBody
    public ResponseSuccessful deleteMusicToUser(@PathVariable Long idMusic) throws NotFoundExseption
    {
        response.setEntity(musicService.deleteMusicToUser(idMusic, SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }
}