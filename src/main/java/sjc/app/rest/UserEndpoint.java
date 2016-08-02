package sjc.app.rest;

import sjc.app.model.vo.UserRegisterVO;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

public interface UserEndpoint
{

	Response getProfile(Long iduser);
	Response getProfileAutorize(HttpServletRequest request);
	Response addUser(UserRegisterVO userRegisterVO);

}
