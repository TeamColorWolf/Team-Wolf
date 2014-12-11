package TeamWolf.TeamWolf.client.GUI.mainUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import TeamWolf.TeamWolf.client.BL.userBL.LoginController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class LoginButtonListener implements MouseListener{
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
		if(userName.length()==0 || password.length()==0){
			new MessageFrame(10001);//TODO 信息不全
			return;
		}
		if(IP.length() == 0){
			IP = "127.0.0.1";
		}
		LoginUserVO loginUser = new LoginUserVO(userName, password);
		LoginBLservice c = new LoginController(IP);
		user = c.login(loginUser);
		if(user == null){
			new MessageFrame(10003);//TODO 网络连接错误
			return;
		}
		if(user.error != 0){
			new MessageFrame(10002);//TODO 输入用户名或密码错误
			return;
		}
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

}
