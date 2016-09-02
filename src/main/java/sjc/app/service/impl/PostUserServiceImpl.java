package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.dao.ImageDao;
import sjc.app.dao.PostUserDao;
import sjc.app.dao.UserDao;
import sjc.app.firebase.PushNotification;
import sjc.app.model.entity.LikeEntityImpl;
import sjc.app.model.entity.PostUserEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.PostNotificationVO;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.PostUserService;

import java.util.ArrayList;
import java.util.Date;
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
    public List<PostVO> getPostsUser(String login, Long userId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        UserEntityImpl userEntity = userDao.findByName(login);
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
            for (LikeEntityImpl like : postEntity.getLikes())
            {
                if (userEntity.getLikes().contains(like))
                {
                    post.setIsLike(like.getIsLike());
                } else
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
    public PostVO getUsersLatestPost(Long userId, String login)
    {
        PostVO result = new PostVO();
        UserEntityImpl userEntity = userDao.findById(userId);
        List<PostUserEntityImpl> postEntitys = postUserDao.getLatestPost(userId);
        for (PostUserEntityImpl postEntity : postEntitys)
        {
           // PostVO post = new PostVO();
            if (postEntity.getImage() != null)
            {
                result.setImage(postEntity.getImage().getUrl());
            }
           result.setDate(postEntity.getDateString());
           result.setId(postEntity.getId());
           result.setLike(LikeServiceImpl.getCountLike(postEntity.getLikes()));
           result.setDislike(LikeServiceImpl.getCountDisLike(postEntity.getLikes()));
           result.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            for (LikeEntityImpl like : postEntity.getLikes())
            {
                if (userEntity.getLikes().contains(like))
                {
                    result.setIsLike(like.getIsLike());
                } else
                {
                    result.setIsLike(0);
                }
            }
            if (postEntity.getUserFrom().getAvatar() != null)
            {
                owner.setAvatar(postEntity.getUserFrom().getAvatar().getUrl());
            }
            owner.setId(postEntity.getUserFrom().getId());
            owner.setName(postEntity.getUserFrom().getName());
            owner.setLastName(postEntity.getUserFrom().getLastName());
            result.setOwner(owner);
        }
                         if(new Date(result.getDate()).after(new Date())) {
                             return result;
                         } else{
                             return null;
                         }

            }


    @Override
    public boolean addPostUser(PostSmallVO post, String login) throws NoAccessExseption, NotFoundExseption
    {
        UserEntityImpl userEntityFrom = userDao.findByName(login);
        UserEntityImpl userEntityTo = userDao.findById(post.getIdTo());

        if (userEntityTo == null)
        {
            throw new NotFoundExseption(Constant.USER + post.getIdTo() + Constant.MESSAGE_NOT_FOUND);
        }
        if (userEntityTo.getBlackListUsers().contains(userEntityFrom))
        {
            throw new NoAccessExseption(Constant.USER + userEntityFrom.getId() + Constant.MESSAGE_NOT_ACCESS_TO_USER + userEntityTo.getLogin());
        }
        PostUserEntityImpl postEntity = new PostUserEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setUser(userEntityTo);
        postEntity.setUserFrom(userEntityFrom);
        if (post.getUrlImage() != null)
        {
            postEntity.setImage(imageDao.findImageByUrl(post.getUrlImage()));
        }
        postEntity = postUserDao.save(postEntity);
        if (userEntityTo.getNotification() != null && !userEntityTo.getId().equals(userEntityFrom.getId()))
        {
            PostNotificationVO postNotificationVO = new PostNotificationVO();
            postNotificationVO.setText(postEntity.getText());
            PushNotification.push(postNotificationVO, Constant.TITLE, userEntityTo.getNotification().getToken());
        }
        return true;
    }

    @Override
    public boolean deletePostUser(Long postId, String login) throws NotFoundExseption, NoAccessExseption
    {
        PostUserEntityImpl postEntity = postUserDao.findById(postId);
        if (postEntity == null)
        {
            throw new NotFoundExseption(Constant.POST_ID + postId + Constant.MESSAGE_NOT_FOUND);
        }
        if (postEntity.getUserFrom().getLogin().equals(login) || postEntity.getUser().getLogin().equals(login))
        {
            postUserDao.delete(postId);
            return true;
        } else
        {
            throw new NoAccessExseption(Constant.USER + login + Constant.MESSAGE_NOT_ACCESS_TO_POST + postId);
        }
    }

    @Override
    public Long getCountPostsUser(Long idUser)
    {
        return postUserDao.getCountPostsUser(idUser);
    }

}
