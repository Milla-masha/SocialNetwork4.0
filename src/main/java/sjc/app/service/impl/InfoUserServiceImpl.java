package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntityImpl;
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
        UserEntityImpl userEntity = userDao.findById(userId);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setAvatar(userEntity.getAvatar());
        user.setAbout(userEntity.getAbout());
        user.setBirthday(userEntity.getBirthdate());
        user.setCity(userEntity.getCity());
        contact.setEmail(userEntity.getEmail());
        contact.setMobile(userEntity.getMobileString());
        contact.setSkype(userEntity.getSkype());
        user.setContactUser(contact);
        return user;
    }

    @Override
    public InfoUserVO getInfoUserVO(String login) {
        UserEntityImpl userEntity = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setAvatar(userEntity.getAvatar());
        user.setAbout(userEntity.getAbout());
        user.setBirthday(userEntity.getBirthdate());
        user.setCity(userEntity.getCity());
        contact.setEmail(userEntity.getEmail());
        contact.setMobile(userEntity.getMobileString());
        contact.setSkype(userEntity.getSkype());
        user.setContactUser(contact);
        return user;
    }
}
