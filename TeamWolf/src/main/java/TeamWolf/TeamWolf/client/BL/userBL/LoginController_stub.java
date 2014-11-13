package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class LoginController_stub extends LoginController{

	public LoginController_stub(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		login = new Login_stub(IP);
	}
	
	@Override
	public UserVO login(LoginUserVO user) {
		// TODO Auto-generated method stub
		return new Login(IP).login(user);
	}

}
