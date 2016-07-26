package sjc.app.rest;


import javax.ws.rs.core.Response;

public interface VideoEndpoint
{
    Response getVideos(Long idUser, Integer offset, Integer limit);
    Response getVideo(Long idVideo);

}
