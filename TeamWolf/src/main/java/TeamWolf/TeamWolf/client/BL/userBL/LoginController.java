package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class LoginController implements LoginBLservice{
	String IP;
	Login login;
	public LoginController(String IP){
		login = new Login(IP);
	}
	
	public UserVO login(LoginUserVO user) {
		// TODO Auto-generated method stub
		return login.login(user);
	}

}
