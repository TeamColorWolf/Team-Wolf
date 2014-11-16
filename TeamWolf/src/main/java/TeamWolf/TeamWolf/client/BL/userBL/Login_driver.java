package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class Login_driver {
	LoginController controller;
	public UserVO getBack;
	public Login_driver(String IP, LoginUserVO user){
		controller = new LoginController(IP);
		getBack = controller.login(user);
		print(getBack);
	}
	
	private void print(UserVO vo){
		System.out.println(vo.userName);
		System.out.println(vo.password);
		System.out.println(vo.workID);
		System.out.println(vo.power);
	}
}
