package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class EventPanel extends JPanel{

	
	public static final int width = 960;
	public static final int height = 540;
	
	JTabbedPane tab;
	
	JourneyPanel jp;
	DetailPanel dp;
	RunPanel rp;
	
	public EventPanel(){
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		jp = new JourneyPanel();
		dp = new DetailPanel();
		rp = new RunPanel();
		
		tab.add(jp,"查看经营历程");
		tab.add(dp,"查看销售明细");
		tab.add(rp,"查看经营情况");
		
		this.add(tab);
		
		this.setLayout(null);
		this.setVisible(true);
	}
}