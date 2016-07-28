package sjc.app.service.impl;

import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.Group;
import sjc.app.model.entity.Post;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.ContactUserVO;
import sjc.app.model.vo.GroupVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserVO;
import sjc.app.service.EntityToVOService;

/**
 * Created by psycl on 28.07.2016.
 */
public class EntityToVOServiceImpl implements EntityToVOService {
    @Override
    public UserVO userEntity2UserVo(UserEntity entity) {
        return new UserVO(entity.getId(), entity.getPassword(), entity.getLogin());
    }

    @Override
    public GroupVO groupEntity2VO(Group group) {
        return null;
    }

    @Override
    public PostVO postEntity2VO(Post post) {
        return null;
    }

    @Override
    public ContactUserVO contactEntity2VO(ContactUser contactUser) {
        return new ContactUserVO(contactUser.getMobile(),contactUser.getSkype(),contactUser.getEmail());
    }
}
