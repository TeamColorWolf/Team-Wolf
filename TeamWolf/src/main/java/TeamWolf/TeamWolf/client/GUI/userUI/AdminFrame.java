package TeamWolf.TeamWolf.client.GUI.userUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.vo.UserVO;

public class AdminFrame extends JFrame{
	
	UserVO user;
	String IP;
	
	JPanel panel;
	
	public AdminFrame(UserVO user, String IP){
		super("操作员编号：" + user.workID + "         服务器IP：" + IP);
		this.user = user;
		this.IP = IP;
		
		panel = new JPanel();
		panel.setSize(960, 540);
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setLocation(0, 0);
		
		this.setContentPane(panel);
		
		this.setSize(960, 540);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public static void main(String[] args){
		UserVO user = new UserVO("WHJ", "*****", "manage_01", "系统管理员");
		AdminFrame f = new AdminFrame(user, "172");
	}
	
}
