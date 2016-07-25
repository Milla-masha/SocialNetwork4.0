package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.RegisterUser;
import sjc.app.repository.dao.UserDao;
import sjc.app.model.vo.IInfoUser;
import sjc.app.model.vo.impl.ContactUserVO;
import sjc.app.model.vo.impl.InfoUserVO;
import sjc.app.service.InfoUserService;

@Service
public class InfoUserServiceImpl implements InfoUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public IInfoUser getInfoUserVO(Long userId)
    {
        RegisterUser registerUser = userDao.findById(userId);
        ContactUser contactUser = registerUser.getContactUser();
        IInfoUser user=new InfoUserVO();
        ContactUserVO contact=new ContactUserVO();
        user.setName(registerUser.getInfoUser().getName());
        user.setLastName(registerUser.getInfoUser().getLastName());
        user.setAvatar(registerUser.getInfoUser().getAvatar());
        user.setAbout(registerUser.getInfoUser().getAbout());
        user.setBirthday(registerUser.getInfoUser().getBirthday());
        user.setCity( registerUser.getInfoUser().getCity());
        contact.setEmail(contactUser.getEmail());
        contact.setMobile(contactUser.getMobile());
        contact.setSkype(contactUser.getSkype());
        user.setContactUser(contact);
        return user;
    }
}
