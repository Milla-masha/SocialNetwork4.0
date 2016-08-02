package sjc.app.rest;


import javax.ws.rs.core.Response;

public interface BlackListEndpoint
{
    Response getBlackList(Long idUser, Integer offset , Integer limit);
    Response addBlackList(Long idUserOwner, Long idBlackUser);
    Response deleteBlackList(Long idUserOwner, Long idBlackUser);
}
