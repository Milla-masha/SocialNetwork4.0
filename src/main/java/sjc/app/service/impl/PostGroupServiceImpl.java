package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.model.entity.*;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.dao.GroupDao;
import sjc.app.dao.ImageDao;
import sjc.app.dao.PostGroupDao;
import sjc.app.dao.UserDao;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.PostGroupService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class PostGroupServiceImpl implements PostGroupService
{
    @Autowired
    private PostGroupDao postGroupDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private ImageDao imageDao;


    @Override
    public List<PostVO> getPostsGroup(String login, Long GroupId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        UserEntityImpl userEntity = userDao.findByName(login);
        List<PostGroupEntityImpl> postsEntity = postGroupDao.getPostsGroup(GroupId, offset, limit);
        for (PostGroupEntityImpl postEntity : postsEntity)
        {
            PostVO post = new PostVO();
            if (postEntity.getImage() != null)
            {
                post.setImage(postEntity.getImage().getUrl());
            }
            post.setId(postEntity.getId());
            post.setDate(postEntity.getDateString());
            post.setId(postEntity.getId());
            post.setLike(LikeServiceImpl.getCountLike(postEntity.getLikes()));
            post.setDislike(LikeServiceImpl.getCountDisLike(postEntity.getLikes()));
            post.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            owner.setId(postEntity.getUserFrom().getId());
            owner.setAvatar(postEntity.getUserFrom().getAvatar().getUrl());
            owner.setName(postEntity.getUserFrom().getName());
            owner.setLastName(postEntity.getUserFrom().getLastName());
            post.setOwner(owner);
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
            posts.add(post);
        }
        return posts;
    }

    @Override
    public boolean addPostGroup(PostSmallVO post, String login) throws NotFoundExseption, NoAccessExseption
    {
        UserEntityImpl userEntityFrom = userDao.findByName(login);
        GroupEntityImpl groupTo = groupDao.findById(post.getIdTo());
        if (groupTo == null)
        {
            throw new NotFoundExseption(Constant.GROUP + post.getIdTo() + Constant.MESSAGE_NOT_FOUND);
        }
        if (!groupTo.getUsers().contains(userEntityFrom))
        {
            throw new NoAccessExseption(login + Constant.MESSAGE_NOT_ACCESS_TO_GROUP + groupTo.getId());
        }
        PostGroupEntityImpl postEntity = new PostGroupEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setGroup(groupTo);
        postEntity.setUserFrom(userEntityFrom);
        if (post.getUrlImage() != null)
        {
            postEntity.setImage(imageDao.findImageByUrl(post.getUrlImage()));
        }
        postGroupDao.save(postEntity);
        return true;
    }

    @Override
    public boolean deletePostGroup(Long postId, String login) throws NotFoundExseption, NoAccessExseption
    {
        PostGroupEntityImpl postEntity = postGroupDao.findById(postId);
        if (postEntity == null)
        {
            throw new NotFoundExseption(Constant.GROUP + postId + Constant.MESSAGE_NOT_FOUND);
        }
        if (postEntity.getUserFrom().getLogin().equals(login))
        {
            postGroupDao.delete(postId);
            return true;
        } else
        {
            throw new NoAccessExseption(login + Constant.MESSAGE_NOT_ACCESS_TO_POST + postId);

        }
    }

    @Override
    public Long getCountPostsByGroup(Long groupId)
    {
        return postGroupDao.getCountPostsByGroup(groupId);
    }

    @Override
    public PostVO getGroupLatestPost(Long groupId, String login)
    {
        PostVO result = new PostVO();
        UserEntityImpl userEntity = userDao.findById(groupId);
        List<PostGroupEntityImpl> postEntitys = postGroupDao.getLatestPost(groupId);
        for (PostGroupEntityImpl postEntity : postEntitys)
        {
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

        return result;

    }
}
