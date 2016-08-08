package sjc.app.rest.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.UserRegisterVO;
import sjc.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/users")
public class UserEndpointImpl
{
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/profile")
    @ResponseBody
    public Response getProfileLogin(HttpServletRequest request)
    {
        return Response.ok(userService.getInfoUserVOLogin(request.getUserPrincipal().getName())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    @ResponseBody
    public Response getProfile(@PathVariable Long idUser)
    {
        return Response.ok(userService.getInfoUserVO(idUser)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Response addUser(@RequestBody UserRegisterVO userRegister)
    {
        userService.addUser(userRegister);
        return Response.ok().build();
    }

}

