package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.RoleEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
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
        UserEntityImpl userEntity = new UserEntityImpl();
//        try {userRepository.findByName(user.getLogin());
//        return false;}
//        catch (NoResultException p)
//        {
        System.out.println(user.getName());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        if (user.getSex().equals("1"))
            userEntity.setSex("Male");
        else userEntity.setSex("Female");
        userEntity.setBirthdateString(user.getBday());
        userEntity.setEmail(user.getEmail());
        List<RoleEntityImpl> authorities = new ArrayList<>();
        RoleEntityImpl authority = new RoleEntityImpl();
        authority.setUser(userEntity);
        authority.setRole("ROLE_CLIENT");
        authorities.add(authority);
        userEntity.setAuthorities(authorities);
        userEntity.setEnabled(1);
        userRepository.save(userEntity);
        return true;
    }
}
