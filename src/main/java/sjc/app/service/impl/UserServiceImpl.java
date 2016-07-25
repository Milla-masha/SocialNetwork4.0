package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.repository.dao.UserDao;
import sjc.app.repository.dao.impl.UserDaoImpl;
import sjc.app.repository.vo.IRegisterUser;
import sjc.app.repository.vo.impl.RegisterUserVO;
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
