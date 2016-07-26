package sjc.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.UserEntity;
import sjc.app.model.vo.UserVO;

import java.util.List;

@Transactional
public interface UserService extends UserDetailsService {
	
	UserEntity loadUserByCredentials(String login, String password);

	UserEntity getUserByID(Long userId);

	UserVO getUserByName(String username);

	List<UserVO> getAllUsers();

}
