package sjc.app.web;

import javax.ws.rs.core.Response;

public interface UserEndPoint {

	Response getAllUser();

	Response getProfile(Long iduser);
}
