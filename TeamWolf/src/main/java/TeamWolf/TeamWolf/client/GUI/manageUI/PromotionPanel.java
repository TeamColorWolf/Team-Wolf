package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionBLController;
import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;

public class PromotionPanel extends JTabbedPane{

	public static PromotionBLservice service;
	
	public PromotionPanel(){
		super();
		service = new PromotionBLController(ManageFrame.IP);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
	
}
