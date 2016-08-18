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
    public List<PostVO> getPostsUser(String login,Long userId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        UserEntityImpl userEntity=userDao.findByName(login);
        List<PostUserEntityImpl> postsEntity = postUserDao.getPostsUser(userId, offset, limit);
        for (PostUserEntityImpl postEntity : postsEntity)
        {
            PostVO post = new PostVO();
            if (postEntity.getImage() != null)
            {
                post.setImage(postEntity.getImage().getUrl());
            }
            post.setDate(postEntity.getDateString());
            post.setId(postEntity.getId());
            post.setLike(LikeServiceImpl.getCountLike(postEntity.getLikes()));
            post.setDislike(LikeServiceImpl.getCountDisLike(postEntity.getLikes()));
            post.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            for (LikeEntityImpl like:postEntity.getLikes())
            {
                if(userEntity.getLikes().contains(like))
                {
                    post.setIsLike(like.getIsLike());
                }
                else
                {
                    post.setIsLike(0);
                }
            }
            if (postEntity.getUserFrom().getAvatar() != null)
            {
                owner.setAvatar(postEntity.getUserFrom().getAvatar().getUrl());
            }
            owner.setId(postEntity.getUserFrom().getId());
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
        UserEntityImpl userEntityFrom = userDao.findByName(login);
        UserEntityImpl userEntityTo = userDao.findById(post.getIdTo());
        if (userEntityTo.getBlackListUsers().contains(userEntityFrom))
        {
            return false;
        }
        PostUserEntityImpl postEntity = new PostUserEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setUser(userEntityTo);
        postEntity.setUserFrom(userEntityFrom);
        if (post.getUrlImage() != null)
        {
            postEntity.setImage(imageDao.findImageByUrl(post.getUrlImage()));
        }
        postUserDao.save(postEntity);
        return true;
    }

    @Override
    public boolean deletePostUser(Long postId, String login)
    {
        PostUserEntityImpl postEntity = postUserDao.findById(postId);
        if (postEntity.getUserFrom().getLogin().equals(login) || postEntity.getUser().getLogin().equals(login))
        {
            System.out.print(postEntity.getId() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
            postUserDao.delete(postId);
            return true;
        } else return false;
    }

    @Override
    public Long getCountPostsUser(Long idUser)
    {
        return postUserDao.getCountPostsUser(idUser);
    }

}
