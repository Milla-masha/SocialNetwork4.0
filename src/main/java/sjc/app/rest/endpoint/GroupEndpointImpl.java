package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.GroupSmallVO;
import sjc.app.rest.response.PaginationResponseOk;
import sjc.app.rest.response.ResponseOk;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.GroupService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/groups")
public class GroupEndpointImpl
{

    @Autowired
    private GroupService groupService;
    private PaginationResponseOk paginationResponse=new PaginationResponseImpl();
    private ResponseOk response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseOk getGroups(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(groupService.getGroups(userId, offset, limit));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{groupId}")
    @ResponseBody
    public ResponseOk getGroup(@PathVariable Long groupId)
    {
        response.setEntity(groupService.getGroup(groupId));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseOk addGroup(@RequestBody GroupSmallVO group, HttpServletRequest request)
    {
        response.setEntity(groupService.addGroup(group, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/{groupId}")
    @ResponseBody
    public ResponseOk currentGroup(@PathVariable Long groupId, HttpServletRequest request)
    {
        response.setEntity(groupService.currentGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseBody
    public ResponseOk leaveGroup(@RequestParam Long groupId, HttpServletRequest request)
    {
        response.setEntity(groupService.leaveGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }
}
