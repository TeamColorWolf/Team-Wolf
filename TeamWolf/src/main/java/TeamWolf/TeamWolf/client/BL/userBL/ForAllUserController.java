package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.ForAllUserService;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class ForAllUserController implements ForAllUserService{
	String IP;
	Admin fau;
	
	public ForAllUserController(String IP){
		fau = new Admin(IP);
	}
	
	public ArrayList<String> getWorkNumberList() {
		// TODO Auto-generated method stub
		return fau.getWorkNumberList();
	}

	public ArrayList<UserVO> getAllUserList() {
		// TODO Auto-generated method stub
		return fau.getAllUserList();
	}
	
}
