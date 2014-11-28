package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class SpecialGoodsPackagePromotionPanel extends JPanel{
	
	PromotionBLservice service = PromotionPanel.service;
	
	TimeSetPanel timeset = new TimeSetPanel();
	GiftSetPanel giftset = new GiftSetPanel();
	
	JButton ensure = new JButton("确认");
	JButton cancel = new JButton("取消");
	
	JTextField price = new JTextField();
	
	private JLabel Price = new JLabel("特价包总价");
	
	private final static int LW = 150;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int BH = 30;
	
	private final static int down = 350;
	private final static int left = 50;
	
	public SpecialGoodsPackagePromotionPanel(){
		super();
		this.add(timeset);
		this.add(giftset);
		
		price.setSize(LW, LH);
		price.setText("0.00");
		
		Price.setSize(BW, LH);
		Price.setLocation(left, down);
		price.setLocation(left+BW, down);
		
		this.add(Price);
		this.add(price);
		
		ensure.setSize(BW, BH);
		cancel.setSize(BW, BH);
		
		ensure.setLocation(680, 400);
		cancel.setLocation(820, 400);
		
		this.add(ensure);
		this.add(cancel);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-2*ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
		
		cancel.addActionListener(new CancelListener());
		ensure.addActionListener(new EnsureListener());
	}
	
	class CancelListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			price.setText("0.00");
			giftset.removeAllGoods();
		}
		
	}
	
	class EnsureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SpecialGoodsPromotionVO promotion = new SpecialGoodsPromotionVO(giftset.getGoodsNumList(), giftset.getTheNumber(), price.getText(), timeset.getBeginVO(), timeset.getEndVO());
			if(promotion.error == 0){
				int success = service.addPromotion(promotion);
				if(success == 0){
					ManageFrame mf = (ManageFrame)RoleSelecter.frame;
					mf.promotion.check.flashPanel();
					System.out.println("add specialGoods successfully!");
				}
			}
			else{
				System.out.println("input error!");
			}
		}
		
	}
	
}
