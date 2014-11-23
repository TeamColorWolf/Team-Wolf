package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class AdminController implements AdminBLservice{
	static Admin administrator;
	
	public AdminController(String IP){
		if(administrator == null)
			administrator = new Admin(IP);
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

	public UserVO findUser(String user) {
		// TODO Auto-generated method stub
		return administrator.findUser(user);
	}

	public String creatWorkID(UserType type) {
		// TODO Auto-generated method stub
		return administrator.creatWorkNumber(type);
	}
	
}
