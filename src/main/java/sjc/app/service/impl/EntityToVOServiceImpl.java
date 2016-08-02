package sjc.app.service.impl;

import org.springframework.stereotype.Service;
import sjc.app.model.entity.impl.GroupEntityImpl;
import sjc.app.model.entity.impl.PostEntityImpl;
import sjc.app.model.entity.impl.UserEntityImpl;
import sjc.app.model.vo.GroupVO;
import sjc.app.model.vo.PostVO;
import sjc.app.model.vo.UserVO;
import sjc.app.service.EntityToVOService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *Created by psycl on 28.07.2016.
 */

@Service
public class EntityToVOServiceImpl implements EntityToVOService {
    @Override
    public UserVO userEntity2UserVo(UserEntityImpl entity) {
        return null;
    }



    @Override
    public List<UserVO> userEntity2UserVo(List<UserEntityImpl> entities) {
        ArrayList<UserVO> userVOs = null;
        UserVO userVO = null;
        for (UserEntityImpl entity : entities) {
            userVO.setId(entity.getId());
            userVO.setLogin(entity.getLogin());
            userVO.setPassword(entity.getPassword());
            userVOs.add(userVO);
        }

        return userVOs;
    }

    @Override
    public List<UserVO> userEntity2UserVo(Collection<UserEntityImpl> entities) {
        return null;
    }

    @Override
    public GroupVO groupEntity2VO(GroupEntityImpl groupEntityImpl) {
        return null;
    }

    @Override
    public PostVO postEntity2VO(PostEntityImpl post) {
        return null;
    }

   }
