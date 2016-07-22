package sjc.app.web.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.entity.InfoUser;
import sjc.app.service.InfoUserService;
import sjc.app.service.UserService;
import sjc.app.web.IUserEndPoint;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserEndPointImpl implements IUserEndPoint
{
	@Autowired
	private UserService userService;
	@Autowired
	private InfoUserService infoUserService;

	@Override
    @ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response getAllUser()
	{
		return Response.ok(userService.getAllUsers()).build();
		//return userService.getAllUsers();
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, value ="/{idInfoUser}")
	@ResponseBody
	public Response getProfile(@PathVariable Long idInfoUser)
	{
		return Response.ok(infoUserService.getInfoUserVO(idInfoUser)).build();
	}


}

