package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.GUI.manageUI.SpecialGoodsPackagePromotionPanel.EnsureListener;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;

public class ForVIPPromotionPanel extends JPanel{
	
	PromotionBLservice service = PromotionPanel.service;
	
	JPanel panel = new JPanel();
	
	TimeSetPanel timeset = new TimeSetPanel();
	GiftSetPanel giftset = new GiftSetPanel();
	
	private JLabel Cashcoupon = new JLabel("  代金券金额");
	private JLabel Discount = new JLabel("      折让金额");
	private JLabel viprank = new JLabel("VIP等级");
	
	JTextField cashcoupon = new JTextField();
	JTextField discount = new JTextField();
	
	JComboBox<Integer> vip = new JComboBox<Integer>();
	
	JButton ensure = new JButton("确认");
	JButton cancel = new JButton("取消");
	
	private final static int LW = 150;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int BH = 30;
	
	private final static int down = 350;
	private final static int left = 50;
	
	public ForVIPPromotionPanel(){
		super();

		vip.setBackground(Color.white);
		
		this.initialVIP();
		viprank.setSize(BW, LH);
		vip.setSize(BW, LH);
		viprank.setLocation(100, 20);
		vip.setLocation(180, 20);
		
		this.add(viprank);
		this.add(vip);
		
		panel.add(timeset);
		panel.add(giftset);
		
		cashcoupon.setSize(LW, LH);
		cashcoupon.setText("0.00");
		discount.setSize(LW, LH);
		discount.setText("0.00");
		
		Cashcoupon.setSize(BW, LH);
		Discount.setSize(BW, LH);
		
		Cashcoupon.setLocation(left, down);
		cashcoupon.setLocation(left+BW, down);
		Discount.setLocation(2*left+BW+LW, down);
		discount.setLocation(2*left+2*BW+LW, down);
		
		panel.add(Cashcoupon);
		panel.add(cashcoupon);
		panel.add(Discount);
		panel.add(discount);
		
		this.add(panel);
		
		panel.setLayout(null);
		panel.setSize(ManageFrame.width, ManageFrame.height-2*ManageFrame.sho-100);
		panel.setLocation(0, 40);
		
		ensure.setSize(BW, BH);
		cancel.setSize(BW, BH);
		
		ensure.setLocation(680, down);
		cancel.setLocation(820, down);
		
		panel.add(ensure);
		panel.add(cancel);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-2*ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
		
		cancel.addActionListener(new CancelListener());
		ensure.addActionListener(new EnsureListener());
	}
	
	private void initialVIP(){
		for(int i = 1; i < 6; i++){
			vip.addItem(i);
		}
	}
	
	class CancelListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cashcoupon.setText("0.00");
			discount.setText("0.00");
			giftset.removeAllGoods();
		}
		
	}
	
	class EnsureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ForVIPPromotionVO promotion = new ForVIPPromotionVO(giftset.getGoodsNumList(), giftset.getTheNumber(), discount.getText(), cashcoupon.getText(), (Integer)vip.getSelectedItem(), timeset.getBeginVO(), timeset.getEndVO());
			if(promotion.error == 0){
				int success = service.addPromotion(promotion);
				if(success == 0){
					ManageFrame mf = (ManageFrame)RoleSelecter.frame;
					mf.promotion.check.flashPanel();
					System.out.println("add forVIPpromotion successfully!");
				}
			}
			else{
				System.out.println("input error!");
			}
		}
		
	}
}
