package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.GroupEntityImpl;
import sjc.app.model.entity.PostGroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.PostSmallVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.GroupDao;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.PostGroupDao;
import sjc.app.repository.dao.UserDao;
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
    public List<PostVO> getPostsGroup(Long GroupId, int offset, int limit)
    {
        List<PostVO> posts = new ArrayList<>();
        List<PostGroupEntityImpl> postsEntity = postGroupDao.getPostsGroup(GroupId, offset, limit);
        for (PostGroupEntityImpl postEntity : postsEntity)
        {
            PostVO post = new PostVO();
            if(postEntity.getImage()!=null)
            {
                post.setImage(postEntity.getImage().getUrl());
            }
            post.setId(postEntity.getId());
            post.setLike(LikeServiceImpl.getCountLike(postEntity.getLikes()));
            post.setDislike(LikeServiceImpl.getCountDisLike(postEntity.getLikes()));
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
    public boolean addPostGroup(PostSmallVO post, String login)
    {
        UserEntityImpl userEntityFrom=userDao.findByName(login);
        GroupEntityImpl groupTo=groupDao.findById(post.getIdTo());
        PostGroupEntityImpl postEntity = new PostGroupEntityImpl();
        postEntity.setText(post.getText());
        postEntity.setGroup(groupTo);
        postEntity.setUserFrom(userEntityFrom);
        postEntity.setImage(imageDao.findById(post.getFkImage()));
        postGroupDao.save(postEntity);
        return true;
    }

    @Override
    public boolean deletePostGroup(Long postId, String login)
    {
        PostGroupEntityImpl postEntity = postGroupDao.findById(postId);
        if (postEntity.getUserFrom().getLogin().equals(login))
        {
            postGroupDao.delete(postId);
            return true;
        }
        else return false;
    }

    @Override
    public Long getCountPostsByGroup(Long groupId)
    {
        return postGroupDao.getCountPostsByGroup(groupId);
    }
}
