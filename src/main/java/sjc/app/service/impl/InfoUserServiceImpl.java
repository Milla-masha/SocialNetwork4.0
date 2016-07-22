package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.entity.ContactUser;
import sjc.app.entity.InfoUser;
import sjc.app.repository.dao.InfoUserDao;
import sjc.app.repository.vo.ContactUserVO;
import sjc.app.repository.vo.InfoUserVO;
import sjc.app.service.InfoUserService;

@Service
public class InfoUserServiceImpl implements InfoUserService{

    @Autowired
    private InfoUserDao userDao;

    @Override
    public InfoUserVO getInfoUserVO(Long infoUserId) {
       InfoUser infoUser= userDao.findById(infoUserId);
        ContactUser contactUser=infoUser.getContactUser();
        return new InfoUserVO(infoUser.getName(),infoUser.getLastName(),infoUser.getBirthday(),
                infoUser.getAvatar(),infoUser.getCity(),infoUser.getAbout()
                ,new ContactUserVO(contactUser.getMobile(),contactUser.getSkype(),contactUser.getEmail()));
    }
}
