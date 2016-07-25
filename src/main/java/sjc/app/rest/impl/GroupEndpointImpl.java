package sjc.app.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.rest.GroupEndpoint;
import sjc.app.service.GroupService;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/groups")
public class GroupEndpointImpl implements GroupEndpoint{

    @Autowired
    private GroupService groupService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value ="/{idUser}&offset={offset}&limit={limit}")
    @ResponseBody
    public Response getGroups(@PathVariable Long idUser,@PathVariable Integer offset,@PathVariable Integer limit) {
        return Response.ok(groupService.getGroups(idUser,offset,limit)).build();
    }
}
