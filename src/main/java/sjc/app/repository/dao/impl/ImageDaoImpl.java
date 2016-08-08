package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.repository.dao.ImageDao;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<ImageEntityImpl> implements ImageDao
{
    public ImageDaoImpl()
    {
        super(ImageEntityImpl.class);
    }
}
