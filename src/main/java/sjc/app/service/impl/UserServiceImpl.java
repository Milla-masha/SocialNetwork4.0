package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.Authorities;
import sjc.app.model.entity.ContactUser;
import sjc.app.model.entity.InfoUser;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.UserRegisterVO;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public boolean addUser(UserRegisterVO user) {
        UserEntity userEntity = new UserEntity();
//        try {userRepository.findByName(user.getLogin());
//        return false;}
//        catch (NoResultException p)
//        {
        System.out.println(user.getName());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        InfoUser infoUser = new InfoUser();
        infoUser.setName(user.getName());
        infoUser.setLastName(user.getLastName());
        if (user.getSex().equals("1"))
            infoUser.setSex("Male");
        else infoUser.setSex("Female");
        infoUser.setBirthdayString(user.getBday());
        infoUser.setUser(userEntity);
        userEntity.setInfoUser(infoUser);
        ContactUser contactUser = new ContactUser();
        contactUser.setEmail(user.getEmail());
        contactUser.setUserEntity(userEntity);
        userEntity.setContactUser(contactUser);
        List<Authorities> authorities = new ArrayList<>();
        Authorities authority = new Authorities();
        authority.setIdU(userEntity);
        authority.setAuthorities("ROLE_CLIENT");
        authorities.add(authority);
        userEntity.setAuthorities(authorities);
        userEntity.setEnabled(1);
        userRepository.save(userEntity);
        return true;//}
    }
}
