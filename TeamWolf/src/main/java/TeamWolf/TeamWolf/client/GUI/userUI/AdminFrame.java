package TeamWolf.TeamWolf.client.GUI.userUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class AdminFrame extends JFrame{
	
	public static UserVO user;
	public static String IP;
	
	JPanel panel;
	
	JTabbedPane tab;
	
	AddUserPanel addUser;
	
	public static final int width = 960;
	public static final int height = 540;
	public static final int sho = 10;
	
	public AdminFrame(UserVO user, String IP){
		super("操作员编号：" + user.workID + "         服务器IP：" + IP);
		this.user = user;
		this.IP = IP;
		
		panel = new JPanel();
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		addUser = new AddUserPanel();
		
		tab.add(addUser, "添加新用户");
		
		panel.add(tab);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		panel.setSize(width, height);
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setLocation(0, 0);
		
		this.setContentPane(panel);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public static void main(String[] args){
		UserVO user = new UserVO("WHJ", "*****", "admin_01", UserType.系统管理员);
		AdminFrame f = new AdminFrame(user, "172");
	}
	
}
