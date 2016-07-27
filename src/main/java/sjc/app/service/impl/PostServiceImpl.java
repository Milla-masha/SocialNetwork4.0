package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.Like;
import sjc.app.model.entity.Post;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.PostDao;
import sjc.app.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<PostVO> getPosts(Long userId, int offset, int limit) {
        List<PostVO> posts = new ArrayList<>();
        List<Post> postsEntity = postDao.getPostsUser(userId, offset, limit);
        for (Post postEntity : postsEntity) {
            PostVO post = new PostVO();
            post.setImage(postEntity.getImage());
            post.setLike(getCountLike(postEntity.getLikes()));
            post.setDislike(getCountDisLike(postEntity.getLikes()));
            post.setText(postEntity.getText());
            UserSmallVO owner = new UserSmallVO();
            owner.setAvatar(postEntity.getFkUser().getInfoUser().getAvatar());
            owner.setName(postEntity.getFkUser().getInfoUser().getName());
            owner.setLastName(postEntity.getFkUser().getInfoUser().getLastName());
            post.setOwner(owner);
            posts.add(post);
        }
        return posts;
    }

    public int getCountLike(List<Like> likes) {
        int count = 0;
        for (Like like : likes) {
            if (like.getIsLike() == 1)
                count++;
        }
        return count;
    }

    public int getCountDisLike(List<Like> likes) {
        int count = 0;
        for (Like like : likes) {
            if (like.getIsLike() == 0)
                count++;
        }
        return count;
    }
}
