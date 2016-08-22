package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.RoleEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.*;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.MailService;
import sjc.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private OnlineUser onlineUserService;
    @Autowired
    private MailService mailService;

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
    public InfoUserVO getInfoUserVO(String login, Long userId)
    {
        UserEntityImpl userEntity = userDao.findById(userId);
        UserEntityImpl userLogin = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        if (userEntity.getSex().equals("Male"))
            user.setSex(1);
        else user.setSex(0);
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setOnline(onlineUserService.isOnline(userEntity.getLogin()));
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
        if (userLogin.getFriends().contains(userEntity))
        {
            user.setIsFriend(1);
        } else user.setIsFriend(0);
        return user;
    }

    @Override
    public InfoUserVO getInfoUserLogin(String login)
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        user.setId(userEntity.getId());
        if (userEntity.getSex().equals("Male"))
            user.setSex(1);
        else user.setSex(0);
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        if (userEntity.getAvatar() != null)
        {
            user.setAvatar(userEntity.getAvatar().getUrl());
        }
        user.setOnline(onlineUserService.isOnline(userEntity.getLogin()));
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
        if (user.getAvatarUrl() != null)
        {
            userEntity.setAvatar(imageDao.findImageByUrl(user.getAvatarUrl()));
        }
        userEntity.setBirthdateString(user.getBirthdate());
        userEntity.setCity(user.getCity());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        if (user.getSex() == 1)
        {
            userEntity.setSex("Male");
        } else userEntity.setSex("Female");
        userEntity.setMobile(user.getMobile());
        userEntity.setSkype(user.getSkype());
        userDao.update(userEntity);
        return true;
    }

    @Override
    public List<FriendVO> findUsersByFullName(String login, String fullName, int offset, int limit)
    {
        UserEntityImpl user = userDao.findByName(login);
        List<UserEntityImpl> userEntities = userDao.findByFullName(fullName, offset, limit);
        List<FriendVO> friendVOs = new ArrayList<>();
        for (UserEntityImpl userEntity : userEntities)
        {
            FriendVO friend = new FriendVO();
            friend.setId(userEntity.getId());
            if (userEntity.getAvatar() != null)
            {
                friend.setAvatar(userEntity.getAvatar().getUrl());
            }
            friend.setOnline(onlineUserService.isOnline(userEntity.getLogin()));
            friend.setName(userEntity.getName());
            friend.setLastName(userEntity.getLastName());
            if (user.getFriends().contains(userEntity))
            {
                friend.setIsFriend(1);
            } else friend.setIsFriend(0);
            friendVOs.add(friend);
        }
        return friendVOs;
    }

    @Override
    public Boolean getUserPassword(String email)
    {
        UserEntityImpl user = userDao.findByEmail(email);
        mailService.sendPasswordToEmail("Your password from son",user.getPassword(),email);
        return true;
    }

    @Override
    public boolean editUserPassword(PasswordVO password, String name)
    {
        UserEntityImpl user = userDao.findByName(name);
        if (user.getPassword().equals(password.getOldPassword()))
        {
            user.setPassword(password.getNewPassword());
            userDao.update(user);
            return true;
        }
        return false;
    }

}
