package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.model.vo.GroupSmallVO;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.GroupService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/groups")
public class GroupEndpoint
{

    @Autowired
    private GroupService groupService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getGroups(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,groupService.getCountGroupsFromUser(userId).toString());
        paginationResponse.setEntity(groupService.getGroups(userId, offset, limit, request.getUserPrincipal().getName()));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/find")
    @ResponseBody
    public PaginationResponseSuccessful findGroupsByName(@RequestParam String name, @RequestParam Integer offset, @RequestParam Integer limit, HttpServletRequest request)
    {
        paginationResponse.setEntity(groupService.findGroupsByName( request.getUserPrincipal().getName(),name, offset, limit));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{groupId}")
    @ResponseBody
    public ResponseSuccessful getGroup(@PathVariable Long groupId, HttpServletRequest request)
    {
        response.setEntity(groupService.getGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful addGroup(@RequestBody GroupSmallVO group, HttpServletRequest request)
    {
        response.setEntity(groupService.addGroup(group, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/{groupId}")
    @ResponseBody
    public void editGroup(@RequestBody GroupSmallVO group,@PathVariable Long groupId, HttpServletRequest request) throws NoAccessExseption, NotFoundExseption
    {
        groupService.editGroup(group, request.getUserPrincipal().getName(),groupId );
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/{groupId}")
    @ResponseBody
    public ResponseSuccessful joinGroup(@PathVariable Long groupId, HttpServletRequest request) throws AlreadyExsistsException, NotFoundExseption
    {
        response.setEntity(groupService.addUserToGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", value = "/{groupId}")
    @ResponseBody
    public ResponseSuccessful leaveGroup(@PathVariable Long groupId, HttpServletRequest request) throws NotFoundExseption
    {
        response.setEntity(groupService.leaveGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful deleteGroup(@RequestParam Long groupId, HttpServletRequest request) throws NoAccessExseption, NotFoundExseption
    {
        response.setEntity(groupService.deleteGroup(groupId, request.getUserPrincipal().getName()));
        return response;
    }
}
