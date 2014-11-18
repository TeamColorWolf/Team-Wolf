package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;

public class LoginUserPO implements Serializable{
	public String userName;//用户名
	public String password;//密码
	
	public LoginUserPO(LoginUserVO vo){
		userName = vo.userName;
		password = vo.password;
	}
}
