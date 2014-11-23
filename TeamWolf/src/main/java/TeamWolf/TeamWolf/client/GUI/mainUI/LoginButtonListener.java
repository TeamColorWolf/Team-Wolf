package TeamWolf.TeamWolf.client.GUI.mainUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import TeamWolf.TeamWolf.client.BL.userBL.LoginController;
import TeamWolf.TeamWolf.client.BL.userBL.LoginController_stub;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class LoginButtonListener implements MouseListener, LoginBLservice{
	public UserVO user;
	public String userName;
	public String password;
	public String IP;
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		userName = Main.login.id.getText();
		password = Main.login.password.getText();
		IP = Main.login.serverIP.getText();
		System.out.println(userName+"\n"+password+"\n"+IP);
		LoginUserVO loginUser = new LoginUserVO(userName, password);
		LoginBLservice c = new LoginController(IP);//TODO 实现Login后删除_stub
		user = c.login(loginUser);
		RoleSelecter.roleSelect(user, IP);
		Main.login.dispose();
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public UserVO login(LoginUserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
