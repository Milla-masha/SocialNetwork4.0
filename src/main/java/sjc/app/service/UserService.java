package sjc.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sjc.app.repository.vo.RegisterUserVO;
import sjc.app.entity.RegisterUser;

import java.util.List;

public interface UserService extends UserDetailsService {
	
	RegisterUser loadUserByCredentials(String login, String password);

	RegisterUser getUserByID(Long userId);

	RegisterUserVO getUserByName(String username);

	List<RegisterUserVO> getAllUsers();
}
