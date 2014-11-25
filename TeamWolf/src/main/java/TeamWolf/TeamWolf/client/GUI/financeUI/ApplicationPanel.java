package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class ApplicationPanel extends JPanel{

	
	public static final int width = 960;
	public static final int height = 540;
	
	JTabbedPane tab;
	
	PaymentPanel pp;
	CashPanel cp;
	ReceiptPanel rp;
	
	public ApplicationPanel(){
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		pp = new PaymentPanel();
		cp = new CashPanel();
		rp = new ReceiptPanel();
		
		tab.add(rp,"制定收款单");
		tab.add(pp,"制定付款单");
		tab.add(cp,"制定现金费用单");
		
		this.add(tab);
		
		this.setLayout(null);
		this.setVisible(true);
	}
}