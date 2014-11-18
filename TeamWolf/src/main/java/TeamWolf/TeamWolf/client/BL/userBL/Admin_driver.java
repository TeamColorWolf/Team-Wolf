package TeamWolf.TeamWolf.client.BL.userBL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	
	public Admin_driver(String IP){
		controller = new AdminController(IP);
	}
	
	public int addUser(UserVO user){
		return controller.addUser(user);
	}
	
	public int removeUser(String user){
		return controller.removeUser(user);
	}
	
	public int update(UserVO user){
		return controller.update(user);
	}
	
	public ArrayList<UserVO> checkUserVO(){
		return controller.checkUserVO();
	}
	
	public static void main(String[] args) throws IOException{
		System.out.print("server IP : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Admin_driver a = new Admin_driver(br.readLine());
		ArrayList<UserVO> list;
		UserVO admin = new UserVO("admin", "admin", "admin_01", UserType.系统管理员);
		UserVO WHJ = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
		UserVO WKS = new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
		UserVO XYJ = new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
		UserVO GYQ = new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
//		System.out.println(a.addUser(admin));
//		System.out.println(a.addUser(WHJ));
//		System.out.println(a.addUser(WKS));
//		System.out.println(a.addUser(XYJ));
//		System.out.println(a.addUser(GYQ));
		System.out.println(a.removeUser("GYQ"));
	}
	
}
