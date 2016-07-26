package sjc.app.rest;

import javax.ws.rs.core.Response;

public interface UserEndpoint
{

	Response getProfile(Long iduser);

}
