package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;

public class ReceiptPanel extends JPanel{

	
	
	public static final int width = 960;
	public static final int height = 540;
	public static FinanceApplicationService service = null;
	public OneRecieptPanel orp;
	
	public ReceiptPanel(String IP){
		service = new FinanceApplicationController(IP);
		orp = new OneRecieptPanel();
		this.add(orp);
		this.setLayout(null);
		this.setVisible(true);
	}
}
