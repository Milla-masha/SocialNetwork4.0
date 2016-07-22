package sjc.app.service.impl;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.repository.dao.UserDao;
import sjc.app.repository.dao.impl.UserDaoImpl;
import sjc.app.repository.vo.RegisterUserVO;
import sjc.app.entity.RegisterUser;
import sjc.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;
    @Autowired
    private UserService userService;
    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl() {
        userRepository = new UserDaoImpl();
    }

    public RegisterUser loadUserByCredentials(String login, String password) {

        RegisterUser registerUser = userRepository.findByCredentials(login, password);

        return registerUser;
    }

    public RegisterUser getUserByID(Long userId) {

        RegisterUser registerUser = userRepository.findById(new Long(userId));

        return registerUser;
    }

    @Override
    public RegisterUserVO getUserByName(String userName) {
        RegisterUser registerUser = userRepository.findByName(userName);
        RegisterUserVO registerUserVO = new RegisterUserVO(registerUser.getId(), registerUser.getPassword(), registerUser.getLogin());
        return registerUserVO;
    }

    @Override
    @Transactional
    public List<RegisterUserVO> getAllUsers() {
        List<RegisterUser> registerUsers = userRepository.findAll();
        //	System.out.println(registerUsers.get(0).getName());
        List<RegisterUserVO> registerUserVOs = new ArrayList<RegisterUserVO>();
        for (RegisterUser user : registerUsers) {
            List<RegisterUserVO> friendsVO = new ArrayList<RegisterUserVO>();
            for (RegisterUser friend : user.getFriends()) {
                RegisterUserVO friendVO = new RegisterUserVO(friend.getId(), friend.getPassword(), friend.getLogin());
                friendsVO.add(friendVO);
            }
            RegisterUserVO registerUserVO = new RegisterUserVO(user.getId(), user.getPassword(), user.getLogin(), friendsVO);
            registerUserVOs.add(registerUserVO);
        }
        return registerUserVOs;
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        RegisterUser registerUser = userRepository.findByName(userName);
        if (registerUser == null) {
            throw new UsernameNotFoundException("No such user: " + userName);
        } else if (registerUser.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User " + userName + " has no authorities");
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<String> roles = new ArrayList<>();
        for (int i = 0; i < registerUser.getAuthorities().size(); i++) {
            roles.add(registerUser.getAuthorities().iterator().next().getAuthorities());
        }
        return new User(
                registerUser.getLogin(),
                registerUser.getPassword().toLowerCase(),
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
