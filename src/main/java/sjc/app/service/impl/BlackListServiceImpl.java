package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.dao.BlackListDao;
import sjc.app.dao.UserDao;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.BlackListService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class BlackListServiceImpl implements BlackListService
{
    @Autowired
    private BlackListDao blackListDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserSmallVO> getBlackList(Long userId, int offset, int limit)
    {
        List<UserEntityImpl> infoBlack = blackListDao.getBlackList(userId, offset, limit);
        List<UserSmallVO> blackList = new ArrayList<>();
        for (UserEntityImpl user : infoBlack)
        {
            UserSmallVO bUser = new UserSmallVO();
            bUser.setId(user.getId());
            bUser.setName(user.getName());
            bUser.setLastName(user.getLastName());
            if (user.getAvatar() != null)
            {
                bUser.setAvatar(user.getAvatar().getUrl());
            }
            blackList.add(bUser);
        }
        return blackList;
    }

    @Override
    public void addBlackList(Long userId, Long bUserId) throws NotFoundExseption, AlreadyExsistsException, NoAccessExseption
    {
        UserEntityImpl userEntity = userDao.findById(userId);
        UserEntityImpl blackUser = userDao.findById(bUserId);
        if (blackUser == null)
        {
            throw new NotFoundExseption("User " + userId + Constant.MESSAGE_NOT_FOUND);
        }
        if (userEntity.getBlackListUsers().contains(blackUser))
        {
            throw new AlreadyExsistsException("In black list user " + userId + Constant.MESSAGE_EXIST);
        }
        if (userEntity.equals(blackUser))
        {
            throw new NoAccessExseption("You dont add yourself in black list.");
        }
        userEntity.getBlackListUsers().add(blackUser);
        userDao.update(userEntity);
    }

    @Override
    public void deleteBlackList(Long userId, Long bUserId) throws NotFoundExseption
    {
        UserEntityImpl userEntity = userDao.findById(userId);
        UserEntityImpl blackUser = userDao.findById(bUserId);
        if (blackUser == null || !userEntity.getBlackListUsers().contains(blackUser))
        {
            throw new NotFoundExseption("Friend " + userId + Constant.MESSAGE_NOT_FOUND);
        }
        userEntity.getBlackListUsers().remove(blackUser);
        userDao.update(userEntity);
    }

    @Override
    public Long getCountBlackUser(Long userId)
    {
        return blackListDao.getCountBlackList(userId);
    }
}
