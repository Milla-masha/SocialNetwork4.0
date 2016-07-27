package sjc.app.rest;

import sjc.app.model.vo.UserRegisterVO;

import javax.ws.rs.core.Response;

public interface UserEndpoint
{

	Response getProfile(Long iduser);
	Response addUser(UserRegisterVO userRegisterVO);

}
