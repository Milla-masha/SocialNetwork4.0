package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.repository.dao.LikeDao;

@Repository
public class LikeDaoImpl extends GenericDaoImpl<LikeEntityImpl> implements LikeDao
{
    public LikeDaoImpl()
    {
        super(LikeEntityImpl.class);
    }
}
