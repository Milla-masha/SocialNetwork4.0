package sjc.app.web.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sjc.app.repository.entity.User;
import sjc.app.service.UserService;
import sjc.app.web.IUserService;
import java.security.Principal;
import java.util.List;

@Component("userServiceComponent")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserService userService;


	@Override
	public List<User> getAllUser(Principal principal) {
		List<User> users = userService.getAllUsers();
		System.out.println();
		return users;
	}
}

