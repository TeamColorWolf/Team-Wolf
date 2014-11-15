package TeamWolf.TeamWolf.client.BL.userBL;

import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Mock_Login extends Login{

	public Mock_Login(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserVO login(LoginUserVO user){
		if(user.userName.equals("admin")){
			return new UserVO("admin", "131250194", "admin_01", UserType.系统管理员);
		}
		else if(user.userName.equals("WHJ")){
			return new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
		}
		else if(user.userName.equals("WKS")){
			return new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
		}
		else if(user.userName.equals("XYJ")){
			return new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
		}
		else if(user.userName.equals("GYQ")){
			return new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
		}
		return new UserVO(null, null, null, null);
	}

}