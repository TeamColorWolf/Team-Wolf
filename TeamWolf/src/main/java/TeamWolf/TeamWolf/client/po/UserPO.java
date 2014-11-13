package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.UserVO;

public class UserPO  implements Serializable{
	public String userName;//用户名
	public String password;//密码
	public String workID;//工作编号
	public int power;//权限
	
	public UserPO(UserVO vo){
		userName = vo.userName;
		password = vo.password;
		workID = vo.workID;
		power = vo.power;
	}
}
