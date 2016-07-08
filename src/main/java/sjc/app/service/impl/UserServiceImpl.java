package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.repository.dao.UserDAO;
import sjc.app.repository.entity.User;
import sjc.app.repository.impl.UserRepository;
import sjc.app.service.UserService;

import java.util.List;

@Service()
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userRepository;
	
	public UserServiceImpl()
	{
		userRepository=new UserRepository();
	}
	
	public User loadUserByCredentials(String login, String password) {

		User user = userRepository.findByCredentials(login, password);
		
		return user;
	}

	public User getUserByID(Long userId) {
		
		User user = userRepository.findById(new Long(userId));
		
		return user;
	}
	
	@Override
	public User getUserByName(String userName) {
		User user = userRepository.findByName(userName);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users= userRepository.findAll();
		//System.out.println(users.get(0).getName());
		System.out.println("222");
		return users;
	}
}
