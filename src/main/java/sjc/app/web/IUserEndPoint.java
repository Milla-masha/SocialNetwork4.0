package sjc.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.Response;

public interface IUserEndPoint {

	Response getAllUser();

	Response getProfile(Long iduser);
}
