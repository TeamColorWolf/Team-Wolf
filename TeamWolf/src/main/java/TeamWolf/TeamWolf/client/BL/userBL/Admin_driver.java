package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class Admin_driver {
	AdminController controller;
	ArrayList<UserVO> list;
	UserVO WHJ = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
	UserVO WKS = new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
	UserVO XYJ = new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
	UserVO GYQ = new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
	
	public Admin_driver(String IP){
		controller = new AdminController_stub(IP);
		
		this.addUser(WHJ);
		this.removeUser(WKS.userName);
		this.update(XYJ);
		list = this.checkUserVO();
		
	}
	
	private int addUser(UserVO user){
		return controller.addUser(user);
	}
	
	private int removeUser(String user){
		return controller.removeUser(user);
	}
	
	private int update(UserVO user){
		return controller.update(user);
	}
	
	private ArrayList<UserVO> checkUserVO(){
		return controller.checkUserVO();
	}
	
	public static void main(String[] args){
		Admin_driver a = new Admin_driver("1");
	}
	
}
