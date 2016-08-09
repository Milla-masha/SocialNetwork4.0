package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.model.entity.PostUserEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.PostUserDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.PostUserService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class PostUserServiceImpl implements PostUserService
{

    @Autowired
    private PostUserDao postUserDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;


    @Override
    public List<PostVO> getPostsUser(Long userId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        List<PostUserEntityImpl> postsEntity = postUserDao.getPostsUser(userId, offset, limit);
        for (PostUserEntityImpl postEntity : postsEntity)
        {
            PostVO post = new PostVO();
            post.setImage(postEntity.getImage().getUrl());
            post.setLike(getCountLike(postEntity.getLikes()));
            post.setDislike(getCountDisLike(postEntity.getLikes()));
            post.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            owner.setAvatar(postEntity.getUserFrom().getAvatar().getUrl());
            owner.setName(postEntity.getUserFrom().getName());
            owner.setLastName(postEntity.getUserFrom().getLastName());
            post.setOwner(owner);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public boolean addPostUser(PostSmallVO post, String login)
    {
        UserEntityImpl userEntityFrom=userDao.findByName(login);
        UserEntityImpl userEntityTo=userDao.findById(post.getIdTo());
        if (userEntityTo.getBlackListUsers().contains(userEntityFrom))
        {
            return false;
        }
        PostUserEntityImpl postEntity = new PostUserEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setUser(userEntityTo);
        postEntity.setUserFrom(userEntityFrom);
        postEntity.setImage(imageDao.findById(post.getFkImage()));
        postUserDao.save(postEntity);
        return true;
    }

    @Override
    public boolean deletePostUser(Long postId, String login)
    {
        PostUserEntityImpl postEntity = postUserDao.findById(postId);
        if (postEntity.getUserFrom().getLogin().equals(login))
        {
            postUserDao.delete(postEntity);
            return true;
        }
        else return false;
    }

    public int getCountLike(List<LikeEntityImpl> likes)
    {
        int count = 0;
        for (LikeEntityImpl like : likes)
        {
            if (like.getIsLike() == 1)
                count++;
        }
        return count;
    }

    public int getCountDisLike(List<LikeEntityImpl> likes)
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
