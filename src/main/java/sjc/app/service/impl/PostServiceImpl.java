package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.model.entity.PostUserEntityImpl;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.PostDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class PostServiceImpl implements PostService
{

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;


    @Override
    public List<PostVO> getPosts(Long userId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        List<PostUserEntityImpl> postsEntity = postDao.getPostsUser(userId, offset, limit);
        for (PostUserEntityImpl postEntity : postsEntity)
        {
            PostVO post = new PostVO();
            post.setImage(postEntity.getImage().getUrl());
            post.setLike(getCountLike(postEntity.getLikes()));
            post.setDislike(getCountDisLike(postEntity.getLikes()));
            post.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            owner.setAvatar(postEntity.getUser().getAvatar().getUrl());
            owner.setName(postEntity.getUser().getName());
            owner.setLastName(postEntity.getUser().getLastName());
            post.setOwner(owner);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public boolean addPost(PostSmallVO post, String login)
    {
        PostUserEntityImpl postEntity = new PostUserEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setUser(userDao.findByName(login));
        postEntity.setImage(imageDao.findById(post.getFkImage()));
        postDao.save(postEntity);
        return true;
    }

    @Override
    public boolean deletePost(Long postId, String login)
    {
        PostUserEntityImpl postEntity = postDao.findById(postId);
        if (postEntity.getUser().getLogin().equals(login))
        {
            postDao.delete(postEntity);
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
