package sjc.app.rest;

import javax.ws.rs.core.Response;

public interface PostEndpoint
{
    Response getPosts(Long idUser, Integer offset, Integer limit);
}
