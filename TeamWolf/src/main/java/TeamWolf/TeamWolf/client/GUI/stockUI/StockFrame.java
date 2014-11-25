package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import TeamWolf.TeamWolf.client.vo.UserVO;

public class StockFrame extends JFrame {

	private UserVO user;
	private String IP;
	private final int height=540;
	private final int weight=960;
	private JTabbedPane back=new JTabbedPane(JTabbedPane.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);
	private JPanel mainPane;
	private JPanel stockMPane=new StockManagePane();
	private JPanel stockSPane=new StockShowPane();
	private JPanel appPane=new AppPane();
	
	public StockFrame(String IP, UserVO user){
		
		//super("操作员编号：" + user.workID + "         服务器IP：" + IP);
		this.user=user;
		this.IP=IP;
		mainPane=new MainPane(user, IP);
		initial();
	}
	
	private void initial(){
       
		this.setSize(weight, height);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		back.setVisible(true);
		back.addTab("     主页             ", mainPane);
		back.addTab("   库存管理          ", stockMPane);
		back.addTab("   库存查看          ", stockSPane);
		back.addTab(" 库存类单据服务   ", appPane);
		back.setEnabledAt(0, true);
		back.setEnabledAt(1, true);
		back.setEnabledAt(2, true);
		back.setEnabledAt(3, true);
		this.setContentPane(back);
	}
	
	public static void main(String[] args){
		
		Font font = new Font("微软雅黑",Font.BOLD,12);
		UIManager.put("Button.font", font); 
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("TabbedPane.font", font);
        UserVO user=new UserVO("HELLO", null, "12345", null);
        String IP="127.0.0.1";
		new StockFrame(IP, user);
	}
}
