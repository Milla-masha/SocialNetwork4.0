package sjc.app.rest.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.UserService;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/users")
public class UserEndpoint
{
	@Autowired
	private UserService infoUserService;


	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, value ="/{idUser}")
	@ResponseBody
	public Response getProfile(@PathVariable Long idUser)
	{
		return Response.ok(infoUserService.getUserByID(idUser)).build();
	}

}

