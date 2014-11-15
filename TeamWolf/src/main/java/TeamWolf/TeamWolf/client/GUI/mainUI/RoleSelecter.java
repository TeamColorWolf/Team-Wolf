package TeamWolf.TeamWolf.client.GUI.mainUI;

import javax.swing.JFrame;

import TeamWolf.TeamWolf.client.GUI.userUI.AdminFrame;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class RoleSelecter {
	static JFrame frame;
	public static int roleSelect(UserVO user, String IP){
		if(user.power == UserType.库存管理员){
			//打开库存管理员界面
		}
		else if(user.power == UserType.销售人员 || user.power == UserType.销售经理){
			//打开销售人员界面,2为普通销售人员， 3为销售经理
		}
		else if(user.power == UserType.财务人员){
			//打开财务人员界面
		}
		else if(user.power == UserType.总经理){
			//打开总经理界面
		}
		else if(user.power == UserType.系统管理员){
			//打开系统管理员界面
			frame = new AdminFrame(user, IP);
		}
		return 0;
	}
	
	public static void main(String[] args){
		UserVO user = new UserVO("WHJ", "*****", "admin_01", UserType.系统管理员);
		RoleSelecter.roleSelect(user, "172.0.0.1");
	}
	
}
