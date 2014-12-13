package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;

public class ForPricePromotionPanel extends JPanel{
	PromotionBLservice service = PromotionPanel.service;
	
	TimeSetPanel timeset = new TimeSetPanel();
	GiftSetPanel giftset = new GiftSetPanel();
	
	private JLabel Cashcoupon = new JLabel("  代金券金额");
	private JLabel WorkCondition = new JLabel("触发总价");
	
	JTextField cashcoupon = new JTextField();
	JTextField workcondition = new JTextField();
	
	JButton ensure = new JButton("确认");
	JButton cancel = new JButton("取消");
	
	private final static int LW = 150;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int BH = 30;
	
	private final static int down = 350;
	private final static int left = 50;
	
	public ForPricePromotionPanel(){
		super();
		this.add(timeset);
		this.add(giftset);
		
		cashcoupon.setSize(LW, LH);
		cashcoupon.setText("0.00");
		workcondition.setSize(LW, LH);
		workcondition.setText("0.00");
		
		Cashcoupon.setSize(BW, LH);
		WorkCondition.setSize(BW, LH);
		
		Cashcoupon.setLocation(left, down);
		cashcoupon.setLocation(left+BW, down);
		WorkCondition.setLocation(2*left+BW+LW, down);
		workcondition.setLocation(2*left+2*BW+LW, down);
		
		this.add(Cashcoupon);
		this.add(cashcoupon);
		this.add(WorkCondition);
		this.add(workcondition);
		
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
			cashcoupon.setText("0.00");
			workcondition.setText("0.00");
			giftset.removeAllGoods();
		}
		
	}
	
	class EnsureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ForPricePromotionVO promotion = new ForPricePromotionVO(giftset.getGoodsNumList(), giftset.getTheNumber(), cashcoupon.getText(), workcondition.getText(), timeset.getBeginVO(), timeset.getEndVO());
			if(promotion.error == 0){
				int success = service.addPromotion(promotion);
				if(success == 0){
					ManageFrame mf = (ManageFrame)RoleSelecter.frame;
					mf.promotion.check.flashPanel();
					System.out.println("add forPricePromotion successfully!");
				}
				new MessageFrame(success);
			}
			else{
				System.out.println("input error!");
				new MessageFrame(promotion.error);
			}
		}
		
	}
}
