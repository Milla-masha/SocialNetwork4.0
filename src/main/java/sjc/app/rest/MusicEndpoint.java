package sjc.app.rest;


import javax.ws.rs.core.Response;

public interface MusicEndpoint {

    Response getMusic(Long idUser, Integer offset, Integer limit);

}
