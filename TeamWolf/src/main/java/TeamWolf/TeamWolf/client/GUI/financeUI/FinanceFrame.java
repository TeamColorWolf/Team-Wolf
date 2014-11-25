package TeamWolf.TeamWolf.client.GUI.financeUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.GUI.manageUI.ManageFrame;
import TeamWolf.TeamWolf.client.GUI.manageUI.PromotionPanel;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class FinanceFrame extends JFrame{

	public static UserVO user;
	public static String IP;
	
	JPanel panel = new JPanel();
	
	JTabbedPane tab;
	
	AccountPanel accountpanel;
	ApplicationPanel apppanel;
	EventPanel evepanel;
	INIPanel inipanel;
	EventViewPanel evpanel;
	
	public static final int width = 960;
	public static final int height = 540;
	
	public FinanceFrame(UserVO user, String IP){
		super("操作员编号：" + user.workID + "         服务器IP：" + IP);
		this.user = user;
		this.IP = IP;
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		
		accountpanel = new AccountPanel();
		apppanel = new ApplicationPanel();
		evepanel = new EventPanel();
		inipanel = new INIPanel();
		evpanel = new EventViewPanel();
		
		tab.add(accountpanel,"账户管理");
		tab.add(apppanel,"单据制定");
		tab.add(evepanel,"表单查看");
		tab.add(inipanel,"期初建账");
		tab.add(evpanel,"操作日志");
		
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
		new FinanceFrame(user, "127.0.0.1");
	}

    
    
}
