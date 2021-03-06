package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class UserPO  implements Serializable{
	public String userName;//用户名
	public String password;//密码
	public String workID;//工作编号
	public UserType power;//权限
	public boolean notFound = true;
	
	public UserPO(UserVO vo){
		userName = vo.userName;
		password = vo.password;
		workID = vo.workID;
		power = vo.power;
		notFound = true;
	}
	
	public UserPO(boolean not_found){
		notFound = false;
	}
}
