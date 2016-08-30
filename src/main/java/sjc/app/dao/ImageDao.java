package sjc.app.dao;


import sjc.app.model.entity.ImageEntityImpl;

public interface ImageDao extends GenericDao<ImageEntityImpl>
{
    ImageEntityImpl findImageByUrl(String url);
}
