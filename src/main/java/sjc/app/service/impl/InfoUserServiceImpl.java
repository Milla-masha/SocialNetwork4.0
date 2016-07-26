package sjc.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.ContactUserVO;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.service.InfoUserService;

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