package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionBLController;
import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;

public class PromotionPanel extends JPanel{

	public static PromotionBLservice service;
	
	JTabbedPane tab;
	
	ForVIPPromotionPanel forVIP;
	ForPricePromotionPanel forPrice;
	SpecialGoodsPackagePromotionPanel specialGoods;
	
	public PromotionPanel(){
		super();
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		tab.setVisible(true);
		this.add(tab);
		
//		service = new PromotionBLController(ManageFrame.IP);
		
		forVIP = new ForVIPPromotionPanel();
		forPrice = new ForPricePromotionPanel();
		specialGoods = new SpecialGoodsPackagePromotionPanel();
		
		tab.add(forVIP, "针对客户等级");
		tab.add(forPrice, "针对总价");
		tab.add(specialGoods, "特价包");
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
	
}
