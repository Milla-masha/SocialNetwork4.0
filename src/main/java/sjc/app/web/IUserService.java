package sjc.app.web;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;
import sjc.app.repository.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Principal;
import java.util.List;


@Path("/user")
public interface IUserService {

	@GET
	@Description(value="Resource", target = DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML})
	@Path("/getalluser")
	public List<User> getAllUser(Principal principal);
	
	
}
