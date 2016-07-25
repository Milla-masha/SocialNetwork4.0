package sjc.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sjc.app.repository.vo.IRegisterUser;
import sjc.app.repository.vo.impl.RegisterUserVO;
import sjc.app.entity.RegisterUser;

import java.util.List;

public interface UserService extends UserDetailsService
{

}
