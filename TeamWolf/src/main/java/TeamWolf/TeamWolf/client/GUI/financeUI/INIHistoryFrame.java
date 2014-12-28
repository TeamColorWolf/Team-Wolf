package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class INIHistoryFrame extends JFrame{
	public static final int width = 960;
	public static final int height = 540;
	JTabbedPane tab;
	INIHAccount inia;
	public INIHistoryFrame(String IP, int number){
		super("过往期初建账信息");
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		inia = new INIHAccount(IP, number);
		
		tab.add(inia,"期初账户信息");
		
		this.setSize(width, height);
		this.getFocusableWindowState();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		this.add(tab);
		
		this.setVisible(true);
	}

}
