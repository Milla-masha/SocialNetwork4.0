package sjc.app.rest;

import javax.ws.rs.core.Response;

public interface FriendEndpoint

{
    Response getFriend(Long idUser,Integer offset ,Integer limit);
}
