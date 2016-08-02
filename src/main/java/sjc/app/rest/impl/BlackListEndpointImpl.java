package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.rest.BlackListEndpoint;
import sjc.app.service.BlackListService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/blacklist")
public class BlackListEndpointImpl implements BlackListEndpoint {
    @Autowired
    private BlackListService blackListService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getBlackList(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit) {
        return Response.ok(blackListService.getBlackList(userId, offset, limit)).build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response addBlackList(@RequestParam Long ownerId, @RequestParam Long blackUserId) {
        blackListService.addBlackList(ownerId, blackUserId);
        return Response.ok().build();
    }

    @Override
    public Response deleteBlackList(Long ownerId, Long blackUserId) {
        return null;
    }
}
