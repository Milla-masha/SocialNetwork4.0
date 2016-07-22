package sjc.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sjc.app.entity.UserEntity;
import sjc.app.repository.vo.UserVO;

import java.util.List;

public interface UserService extends UserDetailsService {
	
	UserEntity loadUserByCredentials(String login, String password);

	UserEntity getUserByID(Long userId);

	UserVO getUserByName(String username);

	List<UserVO> getAllUsers();
}
