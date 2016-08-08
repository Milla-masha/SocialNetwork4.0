package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.GroupSmallVO;
import sjc.app.service.GroupService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/groups")
public class GroupEndpointImpl
{

    @Autowired
    private GroupService groupService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getGroups(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        return Response.ok(groupService.getGroups(userId, offset, limit)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{groupId}")
    @ResponseBody
    public Response getGroup(@PathVariable Long groupId)
    {
        return Response.ok(groupService.getGroup(groupId)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Response addGroup(@RequestBody GroupSmallVO group, HttpServletRequest request)
    {
        return Response.ok(groupService.addGroup(group, request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/{groupId}")
    @ResponseBody
    public Response currentGroup(@PathVariable Long groupId, HttpServletRequest request)
    {
        return Response.ok(groupService.currentGroup(groupId, request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseBody
    public Response leaveGroup(@RequestParam Long groupId, HttpServletRequest request)
    {
        return Response.ok(groupService.leaveGroup(groupId, request.getUserPrincipal().getName())).build();
    }
}
