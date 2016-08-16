package sjc.app.rest.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.UserFullVO;
import sjc.app.model.vo.UserRegisterVO;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.UserService;

@Controller
@RequestMapping("/users")
public class UserEndpointImpl
{
    @Autowired
    private UserService userService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/find")
    @ResponseBody
    public PaginationResponseSuccessful findPeople(@RequestParam String fullName, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(userService.findUsersByFullName(SecurityContextHolder.getContext().getAuthentication().getName(),fullName,offset,limit));
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/profile")
    @ResponseBody
    public ResponseSuccessful getProfileInfo()
    {
        response.setEntity(userService.getInfoUserLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    @ResponseBody
    public ResponseSuccessful getProfile(@PathVariable Long idUser)
    {
        response.setEntity(userService.getInfoUserVO(SecurityContextHolder.getContext().getAuthentication().getName(),idUser));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful addUser(@RequestBody UserRegisterVO userRegister)
    {
        userService.addUser(userRegister);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseSuccessful editProfileInfo(@RequestBody UserFullVO user)
    {
        response.setEntity(userService.editProfile(SecurityContextHolder.getContext().getAuthentication().getName(), user));
        return response;
    }
}

