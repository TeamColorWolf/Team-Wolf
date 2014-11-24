package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionBLController;
import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;

public class PromotionPanel extends JPanel{

	public static PromotionBLservice service;
	
	JTabbedPane tab;
	
	ForVIPPromotionPanel forVIP;
	
	public PromotionPanel(){
		super();
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		tab.setVisible(true);
		this.add(tab);
		
		service = new PromotionBLController(ManageFrame.IP);
		
		forVIP = new ForVIPPromotionPanel();
		tab.add(forVIP, "针对客户等级");
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
	
}
