package sjc.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.UserVO;

import java.util.Collection;

@Transactional
public interface UserService extends UserDetailsService {
	
	UserEntity loadUserByCredentials(String login, String password);

	UserEntity getUserByID(Long userId);

	UserVO getUserByName(String username);

    Collection<UserVO> getAllUsers();

	Collection<UserVO> findFriends(Long userId);

}
