package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PromotionTypeVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class GiftListFrame extends JFrame{
	PromotionBLservice service = PromotionPanel.service;
	
	static String[] columnName = {"商品编号", "商品名称", "商品数量", "商品单价"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JTable table;
	JScrollPane scroll;
	JPanel panel;
	JLabel something;
	
	static ArrayList<GoodsVO> giftList;
	static PromotionVO vo;
	
	private final static int width = 400;
	private final static int height = 500;
	private final static int rowH = 25;
	
	public GiftListFrame(String number){
		super();
		vo = service.getPromotion(number);
		panel = new JPanel();
		something = new JLabel();
		something.setSize(width, 50);
		something.setLocation(0, 0);
		
		this.setContent();
		tableModel.setDataVector(content, columnName);
		table = new JTable(tableModel);
		table.setRowHeight(rowH);
		table.setSize(400, 400);
		table.setLocation(0, 0);
		scroll = new JScrollPane(table);
		scroll.setSize(400, 400);
		scroll.setLocation(0, 50);
		
		panel.add(something);
		panel.add(scroll);
		
		panel.setSize(width, height);
		panel.setLocation(0, 0);
		panel.setVisible(true);
		panel.setLayout(null);
		
		this.setContentPane(panel);
		
		this.setSize(width, height);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
	}
	
	private void setContent(){
		ArrayList<GiftForPromotionVO> giftList = null;
		content = null;
		if(vo.type == PromotionTypeVO.forVIP){
			something.setText("单据编号: "+vo.number+"     物品赠送单");
			giftList = ((ForVIPPromotionVO)vo).list;
		}
		else if(vo.type == PromotionTypeVO.forPrice){
			something.setText("单据编号: "+vo.number+"     物品赠送单");
			giftList = ((ForPricePromotionVO)vo).list;
		}
		else if(vo.type == PromotionTypeVO.specialGoods){
			something.setText("单据编号: "+vo.number+"     特价包物品清单");
			giftList = ((SpecialGoodsPromotionVO)vo).list;
		}
		if(giftList != null){
			if(giftList.size() > 15){
				content = new Object[giftList.size()][4];
			}
			else{
				content = new Object[15][4];
			}
			for(int i = 0; i < giftList.size(); i++){
				content[i][0] = giftList.get(i).GoodsName;//实际为商品编号，懒得改了
				content[i][2] = giftList.get(i).sendNumber;
				GoodsVO g = service.findGoods((String)content[i][0]);
				content[i][1] = g.getName();
				content[i][3] = g.getExprice();
			}
		}
	}
}
