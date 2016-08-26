package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.model.entity.PostEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
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
    public Integer addLikeToPostUser(LikeVO likeVO, Long idPost, String login)
    {
        PostEntityImpl postEntity = postUserDao.findById(idPost);
        if (postEntity == null)
        {
            return null;
        }
        return addLikeToPostUser(postEntity, likeVO, login);
    }

    @Override
    public Integer addLikeToPostGroup(LikeVO likeVO, Long idPost, String login)
    {
        PostEntityImpl postEntity = postGroupDao.findById(idPost);
        if (postEntity == null)
        {
            return null;
        }
        return addLikeToPostUser(postEntity, likeVO, login);
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
            if (like.getIsLike() == -1)
                count++;
        }
        return count;
    }

    public Integer addLikeToPostUser(PostEntityImpl postEntity, LikeVO likeVO, String login)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        if (postEntity.getLikes() != null)
        {
            for (LikeEntityImpl like : postEntity.getLikes())
            {
                if (userEntity.getLikes().contains(like))
                {
                    if (like.getIsLike() == likeVO.getIsLike())
                    {
                        likeDao.delete(like);
                        return 0;
                    } else
                    {
                        like.setIsLike(likeVO.getIsLike());
                        likeDao.update(like);
                        return like.getIsLike();
                    }
                }
            }
        }
        LikeEntityImpl likeEntity = new LikeEntityImpl();
        likeEntity.setFkPost(postEntity);
        likeEntity.setUser(userEntity);
        likeEntity.setIsLike(likeVO.getIsLike());
        likeDao.save(likeEntity);
        return likeEntity.getIsLike();
    }
}
