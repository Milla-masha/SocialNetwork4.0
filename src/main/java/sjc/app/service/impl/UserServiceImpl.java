package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.UserVO;
import sjc.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    public UserServiceImpl() {
        userRepository = new UserDao() {

            @Override
            public UserEntity findByName(String userName) {
                return null;
            }

            @Override
            public UserEntity save(UserEntity obj) {
                return null;
            }

            @Override
            public void update(UserEntity obj) {

            }

            @Override
            public List<UserEntity> findAll() {
                return null;
            }

            @Override
            public UserEntity findById(Long id) {
                return null;
            }

            @Override
            public void delete(Long id) {

            }

            @Override
            public void delete(UserEntity obj) {

            }
        };
    }


    @Override
    public UserEntity loadUserByCredentials(String login, String password) {
        return null;
    }

    public UserEntity getUserByID(Long userId) {

        UserEntity userEntity = userRepository.findById(new Long(userId));

        return userEntity;
    }

    @Override
    public UserVO getUserByName(String userName) {
        UserEntity userEntity = userRepository.findByName(userName);
        UserVO userVO = new UserVO(userEntity.getId(), userEntity.getPassword(), userEntity.getLogin());
        return userVO;
    }

    @Override
    @Transactional
    public List<UserVO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        //	System.out.println(userEntities.get(0).getName());
        List<UserVO> userVOs = new ArrayList<UserVO>();
        for (UserEntity user : userEntities) {
            List<UserVO> friendsVO = new ArrayList<UserVO>();
            for (UserEntity friend : user.getFriends()) {
                UserVO friendVO = new UserVO(friend.getId(), friend.getPassword(), friend.getLogin());
                friendsVO.add(friendVO);
            }
            UserVO userVO = new UserVO(user.getId(), user.getPassword(), user.getLogin(), friendsVO);
            userVOs.add(userVO);
        }
        return userVOs;
    }


    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("No such user: " + userName);
        } else if (userEntity.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User " + userName + " has no authorities");
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
}
