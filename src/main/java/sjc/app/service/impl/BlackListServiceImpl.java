package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.BlackListDao;
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

    @Override
    public List<UserSmallVO> getBlackList(Long userId, int offset, int limit)
    {
        List<UserEntityImpl> infoBlack=blackListDao.getBlackList(userId,offset,limit);
        List<UserSmallVO> blackList= new ArrayList<>();
        for (UserEntityImpl user:infoBlack)
        {
            UserSmallVO blackUser = new UserSmallVO();
            blackUser.setName(user.getName());
            blackUser.setLastName(user.getLastName());
            blackUser.setAvatar(user.getAvatar());
            blackList.add(blackUser);
        }
        return blackList;
    }

    @Override
    public void addBlackList(Long userId, Long idBlackUser) {
        blackListDao.addBlackList(userId,idBlackUser);
    }

    @Override
    public void deleteBlackList(Long userId, Long idBlackUser) {
        blackListDao.deleteBlackList(userId,idBlackUser);
    }
}
