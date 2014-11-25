package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;

public class ForVIPPromotionPanel extends JPanel{
	
	PromotionBLservice service = PromotionPanel.service;
	
	TimeSetPanel timeset = new TimeSetPanel();
	GiftSetPanel giftset = new GiftSetPanel();
	
	public ForVIPPromotionPanel(){
		super();
		this.add(timeset);
		this.add(giftset);
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-2*ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
}
