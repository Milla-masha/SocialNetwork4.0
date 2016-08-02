package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.GroupService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/groups")
public class GroupEndpoint {

    @Autowired
    private GroupService groupService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getGroups(@PathVariable Long idUser, @PathVariable Integer offset, @PathVariable Integer limit) {
        return Response.ok(groupService.getGroups(idUser, offset, limit)).build();
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idGroup}")
    @ResponseBody
    public Response getGroup(@PathVariable Long idGroup) {
        return Response.ok(groupService.getGroup(idGroup)).build();
    }
}
