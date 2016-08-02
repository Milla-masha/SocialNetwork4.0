package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.impl.UserEntityImpl;
import sjc.app.model.vo.UserVO;
import sjc.app.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;
    @Autowired
    private EntityToVOServiceImpl entityToVOService;

    public UserServiceImpl() {

    }

    @Override
    public UserEntityImpl loadUserByCredentials(String login, String password) {
        return null;
    }

    public UserVO getUserByID(Long userId) {

        UserEntityImpl userEntity = userRepository.findById(new Long(userId));
        UserVO userVO = new UserVO(userEntity.getId(), userEntity.getPassword(), userEntity.getLogin(), userEntity.getAuthorities(), userEntity.getMobile(), userEntity.getSkype(), userEntity.getEmail(), userEntity.getName(), userEntity.getLastName(), userEntity.getBirthday(), userEntity.getAvatar(), userEntity.getCity(), userEntity.getAbout(), userEntity.getSex()/*,userEntity.getFriends()*/);
        return userVO;
    }

    @Override
    public UserVO getUserByName(String userName) {
        /*UserEntityImpl userEntity = userRepository.findById(userName);
        UserVO userVO = new UserVO(userEntity.getId(), userEntity.getPassword(), userEntity.getLogin());
        return userVO;*/
        return null;
    }

    @Override
    @Transactional
    public List<UserVO> getAllUsers() {
        List<UserEntityImpl> userEntities = userRepository.findAll();
        List<UserVO> userVOs = new ArrayList<UserVO>();
        for (UserEntityImpl user : userEntities) {
            List<UserVO> friendsVO = new ArrayList<UserVO>();
            for (UserEntityImpl friend : user.getFriends()) {
                UserVO friendVO = new UserVO(friend.getId(), friend.getPassword(), friend.getLogin());
                friendsVO.add(friendVO);
            }
            UserVO userVO = new UserVO(user.getId(), user.getPassword(), user.getLogin(), friendsVO);
            userVOs.add(userVO);
        }
        return userVOs;
    }

    @Override
    public Collection<UserVO> findFriends(Long userId) {
        UserEntityImpl user = userRepository.findById(userId);

        return null;
    }

    @Override
    public Collection<UserVO> findFriends(Long idUser, int offset, int limit) {
        Collection<UserEntityImpl> users = userRepository.getFriends(idUser, offset, limit);


        return entityToVOService.userEntity2UserVo(users);

    }


    @Override
    public User loadUserByUsername(Long id) throws UsernameNotFoundException {
        UserEntityImpl userEntity = userRepository.findById(id);
        if (userEntity == null) {
            throw new UsernameNotFoundException("No such user: " + id);
        } else if (userEntity.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User " + id + " has no authorities");
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<String> roles = new ArrayList<>();
        for (int i = 0; i < userEntity.getAuthorities().size(); i++) {
            roles.add(userEntity.getAuthorities().iterator().next().getAuthorities());
        }
        return new User(
                userEntity.getLogin(),
                userEntity.getPassword().toLowerCase(),
                true,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getGrantedAuthorities(roles));
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
