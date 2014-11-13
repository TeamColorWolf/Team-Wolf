package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Login_driver {
	LoginController controller;
	UserVO getBack;
	public Login_driver(String IP){
		controller = new LoginController_stub(IP);
		LoginUserVO user = new LoginUserVO("WHJ", "131250194");
		getBack = controller.login(user);
	}
	
	public static void main(String[] args){
		Login_driver l = new Login_driver("");
	}
}
