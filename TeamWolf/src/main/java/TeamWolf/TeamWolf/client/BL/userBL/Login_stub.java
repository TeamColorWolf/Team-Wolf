package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Login_stub extends Login{
	
	public Login_stub(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserVO login(LoginUserVO user){
		if(user.userName.equals("WHJ") || user.userName.equals("admin")){
			return new UserVO("WHJ", "131250194", "manage_01", "系统管理员");
		}
		return new UserVO(null, null, null, null);
	}

}
