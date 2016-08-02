package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.ContactUserVO;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.InfoUserService;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class InfoUserServiceImpl implements InfoUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public InfoUserVO getInfoUserVO(Long userId) {
        UserEntity userEntity = userDao.findById(userId);
        ContactUser contactUser = userEntity.getContactUser();
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        user.setName(userEntity.getInfoUser().getName());
        user.setLastName(userEntity.getInfoUser().getLastName());
        user.setAvatar(userEntity.getInfoUser().getAvatar());
        user.setAbout(userEntity.getInfoUser().getAbout());
        user.setBirthday(userEntity.getInfoUser().getBirthday());
        user.setCity(userEntity.getInfoUser().getCity());
        contact.setEmail(contactUser.getEmail());
        contact.setMobile(contactUser.getMobile());
        contact.setSkype(contactUser.getSkype());
        user.setContactUser(contact);
        return user;
    }

    @Override
    public InfoUserVO getInfoUserVO(String login) {
        UserEntity userEntity = userDao.findByName(login);
        ContactUser contactUser = userEntity.getContactUser();
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        user.setName(userEntity.getInfoUser().getName());
        user.setLastName(userEntity.getInfoUser().getLastName());
        user.setAvatar(userEntity.getInfoUser().getAvatar());
        user.setAbout(userEntity.getInfoUser().getAbout());
        user.setBirthday(userEntity.getInfoUser().getBirthday());
        user.setCity(userEntity.getInfoUser().getCity());
        contact.setEmail(contactUser.getEmail());
        contact.setMobile(contactUser.getMobile());
        contact.setSkype(contactUser.getSkype());
        user.setContactUser(contact);
        return user;
    }
}
