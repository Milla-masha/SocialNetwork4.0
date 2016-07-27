package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.InfoUser;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.UserRegisterVO;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.UserService;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userRepository;

    @Override
    public void addUser(UserRegisterVO user) {
        UserEntity userEntity =new UserEntity();
        System.out.println(user.getName());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        InfoUser infoUser=new InfoUser();
        infoUser.setName(user.getName());
        infoUser.setLastName(user.getLastName());
        if (user.getSex().equals("1"))
            infoUser.setSex("Male");
        else infoUser.setSex("Female");
        infoUser.setBirthdayString(user.getBday());
        infoUser.setUser(userEntity);
        userEntity.setInfoUser(infoUser);
        userRepository.save(userEntity);
    }
}
