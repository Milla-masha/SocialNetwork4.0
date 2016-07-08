package sjc.app.service;

import sjc.app.repository.entity.User;

import java.util.List;

public interface UserService {
	
	User loadUserByCredentials(String login, String password);

	User getUserByID(Long userId);

	User getUserByName(String username);
	
	List<User> getAllUsers();
}
