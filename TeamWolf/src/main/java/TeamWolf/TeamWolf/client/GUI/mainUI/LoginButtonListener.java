package TeamWolf.TeamWolf.client.GUI.mainUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class LoginButtonListener implements MouseListener, LoginBLservice{
	String userName;
	String password;
	String IP;
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		userName = Main.login.id.getText();
		password = Main.login.password.getText();
		IP = Main.login.serverIP.getText();
		System.out.println(userName+"\n"+password+"\n"+IP);
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
