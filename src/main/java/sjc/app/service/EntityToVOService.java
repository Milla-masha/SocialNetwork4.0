package sjc.app.service;

import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.Group;
import sjc.app.model.entity.Post;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.ContactUserVO;
import sjc.app.model.vo.GroupVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserVO;

/**
 * Created by psycl on 28.07.2016.
 */
public interface EntityToVOService {
    UserVO userEntity2UserVo(UserEntity entity);
    GroupVO groupEntity2VO(Group group);
    PostVO postEntity2VO(Post post);
    ContactUserVO contactEntity2VO(ContactUser contactUser);

}
