package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;

//单据
//大标签
public class ApplicationPanel extends JPanel{

	
	public static final int width = 960;
	public static final int height = 540;
	
	JTabbedPane tab;
	PaymentPanel pp;
	CashPanel cp;
	ReceiptPanel rp;
	
	public static FinanceApplicationService faservice;
	
	public ApplicationPanel(String IP){
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		faservice = new FinanceApplicationController(IP);
		
		pp = new PaymentPanel(IP);
		cp = new CashPanel(IP);
		rp = new ReceiptPanel(IP);
		
		rp.orp.flashPanel();
		
		tab.add(rp,"制定收款单");
		tab.add(pp,"制定付款单");
		tab.add(cp,"制定现金费用单");
		
		this.add(tab);
		
		this.setLayout(null);
		this.setVisible(true);
	}
}