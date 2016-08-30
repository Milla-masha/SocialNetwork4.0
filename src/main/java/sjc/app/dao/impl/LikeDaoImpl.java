package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.LikeDao;
import sjc.app.model.entity.LikeEntityImpl;

@Repository
public class LikeDaoImpl extends GenericDaoImpl<LikeEntityImpl> implements LikeDao
{
    public LikeDaoImpl()
    {
        super(LikeEntityImpl.class);
    }
}
