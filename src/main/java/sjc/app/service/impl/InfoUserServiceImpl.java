package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjc.app.entity.ContactUser;
import sjc.app.entity.InfoUser;
import sjc.app.entity.RegisterUser;
import sjc.app.repository.dao.InfoUserDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.repository.vo.ContactUserVO;
import sjc.app.repository.vo.InfoUserVO;
import sjc.app.service.InfoUserService;

@Service
public class InfoUserServiceImpl implements InfoUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public InfoUserVO getInfoUserVO(Long userId)
    {
        RegisterUser registerUser = userDao.findById(userId);
        ContactUser contactUser = registerUser.getContactUser();
        return new InfoUserVO(registerUser.getInfoUser().getName(),
                registerUser.getInfoUser().getLastName(),
                registerUser.getInfoUser().getBirthday(),
                registerUser.getInfoUser().getAvatar(),
                registerUser.getInfoUser().getCity(),
                registerUser.getInfoUser().getAbout(),
                new ContactUserVO(contactUser.getMobile(),
                        contactUser.getSkype(), contactUser.getEmail()));
    }
}
