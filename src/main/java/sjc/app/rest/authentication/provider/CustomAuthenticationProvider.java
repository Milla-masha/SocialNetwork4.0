package sjc.app.rest.authentication.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import sjc.app.service.impl.UserServiceImpl;

import java.util.Collection;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.loadUserByUsername(username);

        if (user == null || !user.getUsername().equalsIgnoreCase(username))
        {
            System.out.println("Dhrsdhearjgnalsgnlar");
            throw new BadCredentialsException("Username not found.");
        }

        if (!password.equals(user.getPassword()))
        {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return true;
    }
}
