package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.RoleEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.ContactUserVO;
import sjc.app.model.vo.InfoUserVO;
import sjc.app.model.vo.UserFullVO;
import sjc.app.model.vo.UserRegisterVO;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.UserService;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;

    @Override
    public boolean addUser(UserRegisterVO user)
    {
        try
        {
            UserEntityImpl userEntity = new UserEntityImpl();
            userEntity.setLogin(user.getLogin());
            userEntity.setPassword(user.getPassword());
            userEntity.setName(user.getName());
            userEntity.setLastName(user.getLastName());
            if (user.getSex().equals("1"))
            {
                userEntity.setSex("Male");
            } else userEntity.setSex("Female");
            {
                userEntity.setBirthdateString(user.getBday());
            }
            userEntity.setAvatar(imageDao.findById(13L));
            userEntity.setEmail(user.getEmail());
            userEntity.setEnabled(1);
            userEntity = userDao.save(userEntity);
            RoleEntityImpl authority = new RoleEntityImpl();
            authority.setUser(userEntity);
            authority.setRole("ROLE_CLIENT");
            userEntity.getAuthorities().add(authority);
            userDao.update(userEntity);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public InfoUserVO getInfoUserVO(Long userId)
    {
        UserEntityImpl userEntity = userDao.findById(userId);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        if(userEntity.getSex().equals("Male"))
            user.setSex(1);
        else  user.setSex(0);
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        if (userEntity.getAvatar() != null)
        {
            user.setAvatar(userEntity.getAvatar().getUrl());
        }
        user.setAbout(userEntity.getAbout());
        user.setBirthday(userEntity.getBirthdateString());
        user.setCity(userEntity.getCity());
        contact.setEmail(userEntity.getEmail());
        contact.setMobile(userEntity.getMobile());
        contact.setSkype(userEntity.getSkype());
        user.setContactUser(contact);
        return user;
    }

    @Override
    public InfoUserVO getInfoUserLogin(String login)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        if(userEntity.getSex().equals("Male"))
        user.setSex(1);
        else  user.setSex(0);
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        if (userEntity.getAvatar() != null)
        {
            user.setAvatar(userEntity.getAvatar().getUrl());
        }
        user.setAbout(userEntity.getAbout());
        user.setBirthday(userEntity.getBirthdateString());
        user.setCity(userEntity.getCity());
        contact.setEmail(userEntity.getEmail());
        contact.setMobile(userEntity.getMobile());
        contact.setSkype(userEntity.getSkype());
        user.setContactUser(contact);
        return user;
    }

    @Override
    public InfoUserVO getInfoUserVOLogin(String login)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        if(userEntity.getSex().equals("Male"))
            user.setSex(1);
        else  user.setSex(0);
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        if (userEntity.getAvatar() != null)
        {
            user.setAvatar(userEntity.getAvatar().getUrl());
        }
        user.setAbout(userEntity.getAbout());
        user.setBirthday(userEntity.getBirthdateString());
        user.setCity(userEntity.getCity());
        contact.setEmail(userEntity.getEmail());
        contact.setMobile(userEntity.getMobile());
        contact.setSkype(userEntity.getSkype());
        user.setContactUser(contact);
        return user;
    }

    @Override
    public boolean editProfile(String login, UserFullVO user)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        userEntity.setName(user.getName());
        userEntity.setAbout(user.getAbout());
        if (user.getAvatarId() != null)
        {
            userEntity.setAvatar(imageDao.findById(user.getAvatarId()));
        }
        userEntity.setBirthdateString(user.getBirthdate());
        userEntity.setCity(user.getCity());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        if (user.getSex().equals("1"))
        {
            userEntity.setSex("Male");
        } else userEntity.setSex("Female");
        userEntity.setMobile(user.getMobile());
        userEntity.setSkype(user.getSkype());
        userDao.update(userEntity);
        return true;
    }
}
