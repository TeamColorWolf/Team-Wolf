package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class Admin_stub extends Admin{

	public Admin_stub(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int addUser(UserVO user){
		if(user.userName.equals("WHJ")){
			System.out.println("add WHJ");
			return 0;
		}

		else{
			return -1;
		}
	}
	@Override
	public int removeUser(String user) {
		// TODO Auto-generated method stub
		if(user.equals("WKS")){
			System.out.println("remove WKS");
			return 0;
		}
		else{
			return -1;
		}
	}
	@Override
	public int update(UserVO user) {
		// TODO Auto-generated method stub
		if(user.userName.equals("XYJ")){
			System.out.println("update XYJ");
			return 0;
		}
		else
			return -1;
	}
	@Override
	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		UserVO WHJ = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
		UserVO WKS = new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
		UserVO XYJ = new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
		UserVO GYQ = new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(GYQ);
		list.add(XYJ);
		list.add(WKS);
		list.add(WHJ);
		return list;
	}
	@Override
	public String creatWorkNumber(String power){
		if(power.equals("总经理"))
			return "manage_02";
		return "stock_02";
	}

}
