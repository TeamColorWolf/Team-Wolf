package TeamWolf.TeamWolf.client.vo;

import TeamWolf.TeamWolf.client.po.UserPO;

/**
 * 
 * @author WHJ
 *
 */
public class UserVO {
	public int error = 0;
	public String userName;//用户名
	public String password;//密码
	public String workID;//工作编号
	public UserType power;//权限
	
	public UserVO(String Name, String Password, String WorkID, UserType Power){
		userName = Name;
		password = Password;
		workID = WorkID;
		power = Power;
	}
	
	public UserVO(UserPO po){
		userName = po.userName;
		password = po.password;
		workID = po.workID;
		power = po.power;
		if(!po.notFound){
			error = 1;
		}
	}
	
	public UserVO(boolean isError){
		error = 1;
	}
}
