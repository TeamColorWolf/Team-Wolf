package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;


public class INIPanel extends JPanel{

	
	public static final int width = 960;
	public static final int height = 540;
	
	JTabbedPane tab;
	INIAccount iniAc;
	INICustomer iniCu;
	INIGoods iniGo;
	
	
	public INIPanel(String IP){
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		
		iniAc = new INIAccount();
		iniCu = new INICustomer(IP);
		iniGo = new INIGoods(IP);
		
		tab.add(iniAc,"期初账户信息");
		tab.add(iniGo,"期初商品信息");
		tab.add(iniCu,"期初客户信息");
		
		this.add(tab);
		
		this.setLayout(null);
		this.setVisible(true);
	}
}