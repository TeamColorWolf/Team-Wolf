package TeamWolf.TeamWolf.client.BLservice.userBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

public interface AdminBLservice {
	public int addUser(UserVO user);
	public int removeUser(String user);
	public int update(UserVO user);
	public ArrayList<UserVO> checkVO();
}