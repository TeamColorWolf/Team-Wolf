package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class ManageFrame extends JFrame{
	public static UserVO user;
	public static String IP;
	
	JPanel panel = new JPanel();
	
	JTabbedPane tab;
	
	PromotionPanel promotion;
	
	public static final int width = 960;
	public static final int height = 540;
	public static final int sho = 10;
	
	public ManageFrame(UserVO user, String IP){
		super("操作员编号：" + user.workID + "         服务器IP：" + IP);
		this.user = user;
		this.IP = IP;
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		promotion = new PromotionPanel();
		
		tab.add(promotion, "促销策略");
		
		panel.add(tab);
		
		this.setContentPane(panel);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserVO user = new UserVO("WHJ", "131250194", "manage_1", UserType.总经理);
		new ManageFrame(user, "127.0.0.1");
	}

}
