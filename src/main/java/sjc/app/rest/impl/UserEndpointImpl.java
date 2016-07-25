package sjc.app.rest.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.service.InfoUserService;
import sjc.app.service.UserService;
import sjc.app.rest.UserEndpoint;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/users")
public class UserEndpointImpl implements UserEndpoint
{
	@Autowired
	private InfoUserService infoUserService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, value ="/{idUser}")
	@ResponseBody
	public Response getProfile(@PathVariable Long idUser)
	{
		return Response.ok(infoUserService.getInfoUserVO(idUser)).build();
	}

}

