package TeamWolf.TeamWolf.client.BLservice.userBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;
/**
 * 
 * @author WHJ
 *
 */
public interface AdminBLservice {
	public int addUser(UserVO user);
	public int removeUser(String user);
	public int update(UserVO user);
	public ArrayList<UserVO> checkUserVO();
	public UserVO findUser(String user);
}
