package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class AdminController implements AdminBLservice{
	String IP;
	Admin administrator;
	
	public AdminController(String IP){
		administrator = new Mock_Admin(IP);
	}
	
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		return administrator.addUser(user);
	}

	public int removeUser(String user) {
		// TODO Auto-generated method stub
		return administrator.removeUser(user);
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		return administrator.update(user);
	}

	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		return administrator.checkUserVO();
	}
	
}
