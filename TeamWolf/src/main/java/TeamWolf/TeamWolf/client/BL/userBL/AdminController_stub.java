package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.UserVO;

public class AdminController_stub extends AdminController{
	String IP;
	Admin administrator;
	
	public AdminController_stub(String IP){
		super(IP);
		administrator = new Admin_stub(IP);
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
