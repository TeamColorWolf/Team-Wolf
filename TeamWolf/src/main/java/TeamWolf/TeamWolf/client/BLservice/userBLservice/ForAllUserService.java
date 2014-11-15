package TeamWolf.TeamWolf.client.BLservice.userBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.UserVO;

public interface ForAllUserService {
	public ArrayList<String> getWorkNumberList();
	
	public ArrayList<UserVO> getAllUserList();
}
