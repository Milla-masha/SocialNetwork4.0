package sjc.app.service.impl;

import org.springframework.stereotype.Service;
import sjc.app.model.vo.IPost;
import sjc.app.model.vo.impl.PostVO;
import sjc.app.model.vo.impl.UserSmallVO;
import sjc.app.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public List<IPost> getPosts(Long userId, int offset, int limit) {
        List<IPost> posts=new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            IPost post=new PostVO();
            post.setImage("http://kaifolog.ru/uploads/posts/2014-05/1400477776_002.jpg");
            post.setLike(10);
            post.setDislike(21);
            post.setText("sometext sometext sometext sometext sometext sometext sometext sometext sometext sometext sometext sometext");
            UserSmallVO owner=new UserSmallVO();
            owner.setAvatar("http://i2.wp.com/jewelryvirtualfair.com/wp-content/themes/kleo-child/images-themes/avatar-profile.jpg");
            owner.setName("Masha");
            owner.setLastName("Piton");
            post.setOwner(owner);
            posts.add(post);
        }
        return posts;
    }
}
