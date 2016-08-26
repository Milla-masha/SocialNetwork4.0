package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService
{

    @Autowired
    private UserDao userRepository;

    public UserDetailServiceImpl()
    {
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        UserEntityImpl userEntity = userRepository.findByName(userName);
        if (userEntity == null)
        {
            throw new UsernameNotFoundException("No such user: " + userName);
        } else if (userEntity.getAuthorities().isEmpty())
        {
            throw new UsernameNotFoundException("User " + userName + " has no authorities");
        }
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<String> roles = new ArrayList<>();
        for (int i = 0; i < userEntity.getAuthorities().size(); i++)
        {
            roles.add(userEntity.getAuthorities().iterator().next().getRole().name());
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

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles)
    {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles)
        {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
