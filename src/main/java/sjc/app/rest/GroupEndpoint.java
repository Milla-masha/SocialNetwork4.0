package sjc.app.rest;

import javax.ws.rs.core.Response;

public interface GroupEndpoint
{
    Response getGroups(Long idUser, Integer offset, Integer limit );
}
