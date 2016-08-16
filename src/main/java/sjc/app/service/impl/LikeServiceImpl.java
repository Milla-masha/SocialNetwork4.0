package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.model.vo.LikeVO;
import sjc.app.repository.dao.LikeDao;
import sjc.app.repository.dao.PostGroupDao;
import sjc.app.repository.dao.PostUserDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.LikeService;

import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class LikeServiceImpl implements LikeService
{
    @Autowired
    private LikeDao likeDao;
    @Autowired
    private PostUserDao postUserDao;
    @Autowired
    private PostGroupDao postGroupDao;
    @Autowired
    private UserDao userDao;

    @Override
    public boolean addLikeToPostUser(LikeVO likeVO, String login)
    {
        LikeEntityImpl likeEntity = new LikeEntityImpl();
        likeEntity.setFkPost(postUserDao.findById(likeVO.getPostId()));
        likeEntity.setUser(userDao.findByName(login));
        likeEntity.setIsLike(likeVO.getIsLike());
        likeDao.save(likeEntity);
        return true;
    }

    @Override
    public boolean addLikeToPostGroup(LikeVO likeVO, String login)
    {
        LikeEntityImpl likeEntity = new LikeEntityImpl();
        likeEntity.setFkPost(postGroupDao.findById(likeVO.getPostId()));
        likeEntity.setUser(userDao.findByName(login));
        likeEntity.setIsLike(likeVO.getIsLike());
        likeDao.save(likeEntity);
        return true;
    }

    public static int getCountLike(List<LikeEntityImpl> likes)
    {
        int count = 0;
        for (LikeEntityImpl like : likes)
        {
            if (like.getIsLike() == 1)
                count++;
        }
        return count;
    }

    public static int getCountDisLike(List<LikeEntityImpl> likes)
    {
        int count = 0;
        for (LikeEntityImpl like : likes)
        {
            if (like.getIsLike() == 0)
                count++;
        }
        return count;
    }
}
