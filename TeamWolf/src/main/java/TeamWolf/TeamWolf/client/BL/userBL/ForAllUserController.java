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
	ForAllUser fau;
	
	public ForAllUserController(String IP){
		fau = new Mock_ForAllUser(IP);
	}
	
	public ArrayList<String> getWorkNumberList() {
		// TODO Auto-generated method stub
		return fau.getWorkNumberList();
	}

	public ArrayList<UserVO> getAllUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
