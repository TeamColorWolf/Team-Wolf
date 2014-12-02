package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionTypeVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class PromotionCheckPanel extends JPanel{
	PromotionBLservice service = PromotionPanel.service;
	
	static GiftListFrame gift;
	
	static String[] columnName = {"策略种类","策略编号","触发条件", "折让金额", "代金券", "开始时间", "结束时间"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JTable table;
	JScrollPane scroll;
	JButton delete = new JButton("确认删除");
	
	JTextField number = new JTextField();
	private JLabel Number = new JLabel("单据编号");
	
	private final int LW = 100;
	private final int LH = 25;
	private final int TW = 150;
	
	private final int left = 200;
	private final int up = 10;
	private final int down = 420;
	
	public PromotionCheckPanel(){
		super();
		this.getContent();
		tableModel.setDataVector(content, columnName);
		table = new JTable(tableModel);
		table.setRowHeight(LH);
		table.setSize(800, 400);
		table.setLocation(0, 0);
		scroll = new JScrollPane(table);
		scroll.setSize(800, 400);
		scroll.setLocation(80, up);
		
		Number.setSize(LW, LH);
		Number.setLocation(left, down);
		number.setSize(TW, LH);
		number.setLocation(left+LW, down);
		delete.setSize(LW, LH);
		delete.setLocation(left+TW+LW+30, down);
		
		
		this.add(scroll);
		this.add(Number);
		this.add(number);
		this.add(delete);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-2*ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
		
		delete.addActionListener(new DeleteListener());
		table.addMouseListener(new TableListener(table));
	}
	
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		table.updateUI();
	}
	
	private void getContent(){
		ArrayList<PromotionVO> list = service.check();
		if(list.size() > 15){
			content = new Object[list.size()][7];
		}
		else{
			content = new Object[15][7];
		}
		for(int i = 0; i < list.size(); i++){
			PromotionTypeVO type = list.get(i).type;
			content[i][1] = list.get(i).number;
			content[i][5] = list.get(i).begin.toString();
			content[i][6] = list.get(i).end.toString();
			if(type == PromotionTypeVO.forVIP){
				content[i][0] = "针对VIP等级";
				content[i][2] = type + " " + ((ForVIPPromotionVO)list.get(i)).VIPrank;
				content[i][3] = ((ForVIPPromotionVO)list.get(i)).discount;
				content[i][4] = ((ForVIPPromotionVO)list.get(i)).cashCoupon;
			}
			else if(type == PromotionTypeVO.forPrice){
				content[i][0] = "针对销售总价";
				content[i][2] = type + " " + ((ForPricePromotionVO)list.get(i)).workCondition;
				content[i][4] = ((ForPricePromotionVO)list.get(i)).cashCoupon;
			}
			else if(type == PromotionTypeVO.specialGoods){
				content[i][0] = "特价包";
				content[i][2] = "包总价  " + ((SpecialGoodsPromotionVO)list.get(i)).totalPrice;
			}
		}
	}
	
	class DeleteListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String num = number.getText();
			if(num != null){
				int success = service.delet(num);
				if(success == 0){
					//TODO
					System.out.println("delete "+num);
					flashPanel();
				}
			}
		}
		
	}
	
	class TableListener implements MouseListener{
		JTable t;
		public TableListener(JTable table){
			t = table;
		}

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row = t.getSelectedRow();
			String num = (String)t.getValueAt(row, 1);
			if(num != null){
				number.setText(num);
				if(gift != null){
					gift.dispose();
				}
				gift = new GiftListFrame(num);
				gift.setLocationRelativeTo(null);
			}
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
}
