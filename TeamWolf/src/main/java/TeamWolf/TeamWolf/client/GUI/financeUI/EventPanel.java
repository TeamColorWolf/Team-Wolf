package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.tableInquireBL.TableInquireController;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.RunProcessPanel;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.SaleDetialPanel;


public class EventPanel extends JPanel{

public static String IP;
	
	public static TableInquireBLservice service;
	
	JTabbedPane tab = new JTabbedPane();
	
	SaleDetialPanel saleDetial;
	RunProcessPanel runProcess;
	
	final static int width = 960;
	final static int height = 540;
	
	public EventPanel(String IP){
		super();
		this.IP = IP;
		
		service = new TableInquireController(IP);
		
		saleDetial = new SaleDetialPanel();
		runProcess = new RunProcessPanel();
		
		tab.add(runProcess, "经营历程表");
		tab.add(saleDetial, "销售明细表");
		tab.setSize(width, height);
		tab.setLocation(0, 0);
		
		this.add(tab);
		
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setVisible(true);
		this.setLayout(null);
	}
}