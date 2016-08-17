package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.UserService;

/**
 * Created by psycl on 17.08.2016.
 */
@Controller
@RequestMapping("/password")
public class PasswordEndpoint
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

}
