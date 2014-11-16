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
	
	public static void main(String[] args){
		Admin_driver a = new Admin_driver("1");
	}
	
}
