package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.model.entity.Role;
import sjc.app.model.entity.RoleEntityImpl;
import sjc.app.model.entity.Sex;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.*;
import sjc.app.dao.ImageDao;
import sjc.app.dao.UserDao;
import sjc.app.rest.exception.AlreadyExsistsException;
import sjc.app.rest.exception.NoAccessExseption;
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
    public boolean addUser(UserRegisterVO user) throws AlreadyExsistsException
    {
        UserEntityImpl userEntity = new UserEntityImpl();
        if (userDao.isExistLoginFromUser(user.getLogin()))
        {
            throw new AlreadyExsistsException("Login " + user.getLogin() + Constant.MESSAGE_EXIST);
        }
        if (userDao.isExistEmailFromUser(user.getEmail()))
        {
            throw new AlreadyExsistsException("Email " + user.getEmail() + Constant.MESSAGE_EXIST);
        }
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        if (user.getSex().equals("1"))
        {
            userEntity.setSex(Sex.MALE);
        } else
        {
            userEntity.setSex(Sex.FEMALE);
        }
        userEntity.setBirthdateString(user.getBday());
        userEntity.setAvatar(imageDao.findById(1L));
        userEntity.setEmail(user.getEmail());
        userEntity.setEnabled(true);
        RoleEntityImpl authority = new RoleEntityImpl();
        authority.setUser(userEntity);
        authority.setRole(Role.ROLE_CLIENT);
        userEntity.getAuthorities().add(authority);
        userDao.save(userEntity);
        return true;
    }

    @Override
    public InfoUserVO getInfoUserVO(String login, Long userId)
    {
        UserEntityImpl userEntity = userDao.findById(userId);
        if (userEntity == null)
        {
            return null;
        }
        UserEntityImpl userLogin = userDao.findByName(login);
        InfoUserVO user = new InfoUserVO();
        ContactUserVO contact = new ContactUserVO();
        if (userEntity.getSex().equals(Sex.MALE))
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
        if (userEntity.getSex().equals(Sex.MALE))
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
    public InfoUserVO getUserById(String id)
    {
        UserEntityImpl userEntity = userDao.findById(Long.parseLong(id));
        if (userEntity == null)
        {
            return null;
        }
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
    public boolean editProfile(String login, UserFullVO user) throws AlreadyExsistsException
    {
        UserEntityImpl userEntity = userDao.findByName(login);
        if (!userEntity.getEmail().equals(user.getEmail()) && user.getEmail() != null)
        {
            if (userDao.isExistEmailFromUser(user.getEmail()))
            {
                throw new AlreadyExsistsException("Email " + userEntity.getEmail() + Constant.MESSAGE_EXIST);
            }
        }
        userEntity.setName(user.getName());
        userEntity.setAbout(user.getAbout());
        if (user.getAvatarUrl() != null)
        {
            userEntity.setAvatar(imageDao.findImageByUrl(user.getAvatarUrl()));
        }
        userEntity.setUpdateBirthdateString(user.getBirthdate());
        userEntity.setCity(user.getCity());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        if (user.getSex() == 1)
        {
            userEntity.setSex(Sex.MALE);
        } else
        {
            userEntity.setSex(Sex.FEMALE);
        }
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
        mailService.sendPasswordToEmail("Social Network, password recovery", user.getPassword(), email);
        return true;
    }

    @Override
    public boolean editUserPassword(PasswordVO password, String name) throws NoAccessExseption
    {
        UserEntityImpl user = userDao.findByName(name);
        if (user.getPassword().equals(password.getOldPassword()))
        {
            user.setPassword(password.getNewPassword());
            userDao.update(user);
            return true;
        } else
        {
            throw new NoAccessExseption(Constant.MESSAGE_INVALID_PASSWORD + password.getOldPassword());
        }
    }

    @Override
    public Long getUserId(String login)
    {
        return userDao.findByName(login).getId();
    }

}
