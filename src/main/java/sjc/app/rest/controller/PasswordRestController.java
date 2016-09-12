package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.PasswordVO;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.UserService;

@RestController
@RequestMapping("/password")
public class PasswordRestController
{
    @Autowired
    private UserService userService;
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/forgotten")
    @ResponseBody
    public ResponseSuccessful getPassword(@RequestParam String email)
    {
        response.setEntity(userService.getUserPassword(email));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful editPassword(@RequestBody PasswordVO password) throws NoAccessExseption
    {
        response.setEntity(userService.editUserPassword(password, SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }
}
