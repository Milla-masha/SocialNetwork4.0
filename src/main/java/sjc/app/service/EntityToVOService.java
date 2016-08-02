package sjc.app.service;

import sjc.app.model.entity.impl.GroupEntityImpl;
import sjc.app.model.entity.impl.PostEntityImpl;
import sjc.app.model.entity.impl.UserEntityImpl;
import sjc.app.model.vo.GroupVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserVO;

import java.util.Collection;
import java.util.List;

/**
 * Created by psycl on 28.07.2016.
 */

public interface EntityToVOService {
    UserVO userEntity2UserVo(UserEntityImpl entity);

    List<UserVO> userEntity2UserVo(List<UserEntityImpl> entities);

    List<UserVO> userEntity2UserVo(Collection<UserEntityImpl> entities);

    GroupVO groupEntity2VO(GroupEntityImpl groupEntityImpl);
    PostVO postEntity2VO(PostEntityImpl post);


}
