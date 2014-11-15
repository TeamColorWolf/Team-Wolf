package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Mock_ForAllUser extends ForAllUser{
	
	public Mock_ForAllUser(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		voList = new ArrayList<UserVO>();
		strList = new ArrayList<String>();
		
		UserVO admin = new UserVO("admin", "admin", "admin_01", UserType.系统管理员);
		UserVO WHJ = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
		UserVO WKS = new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
		UserVO XYJ = new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
		UserVO GYQ = new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
		voList.add(WHJ);
		voList.add(WKS);
		voList.add(XYJ);
		voList.add(GYQ);
		voList.add(admin);
		
		strList.add(WHJ.workID);
		strList.add(WKS.workID);
		strList.add(XYJ.workID);
		strList.add(GYQ.workID);
		strList.add(admin.workID);
	}
	@Override
	public ArrayList<String> getWorkNumberList() {
		return strList;
	}
	
	@Override
	public ArrayList<UserVO> getAllUserList(){
		return voList;
	}

}
