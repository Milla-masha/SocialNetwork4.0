package sjc.app.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.impl.UserEntityImpl;
import sjc.app.model.vo.UserVO;

import java.util.Collection;

@Transactional
public interface UserService extends UserDetailsService {


    UserEntityImpl loadUserByCredentials(String login, String password);

    UserVO getUserByID(Long userId);

    UserVO getUserByName(String userName);

    Collection<UserVO> getAllUsers();

    Collection<UserVO> findFriends(Long userId);

    Collection<UserVO> findFriends(Long userId, int offset, int limit);


    User loadUserByUsername(Long id) throws UsernameNotFoundException;
}
