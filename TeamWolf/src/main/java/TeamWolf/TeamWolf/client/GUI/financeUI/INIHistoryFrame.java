package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
//查看过往期初信息——界面
public class INIHistoryFrame extends JFrame{
	public static final int width = 960;
	public static final int height = 540;
	JTabbedPane tab;
	INIHAccount inia;
	INIHCustomer inic;
	INIHGoods inig;
	public INIHistoryFrame(String IP, int number){
		super("过往期初建账信息");
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		inia = new INIHAccount(IP, number);
		inic = new INIHCustomer(IP, number);
		inig = new INIHGoods(IP, number);
		
		tab.add(inia,"期初账户信息");
		tab.add(inic,"期初客户信息");
		tab.add(inig,"期初商品信息");
		
		this.setSize(width, height);
		this.getFocusableWindowState();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		this.add(tab);
		
		this.setVisible(true);
	}

}
