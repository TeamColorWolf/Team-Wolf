package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class LoginController implements LoginBLservice{
	String IP;
	
	public UserVO login(LoginUserVO user) {
		// TODO Auto-generated method stub
		return new Login(IP).login(user);
	}

}
