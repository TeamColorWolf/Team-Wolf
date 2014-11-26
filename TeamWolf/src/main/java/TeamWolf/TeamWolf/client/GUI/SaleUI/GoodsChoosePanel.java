package TeamWolf.TeamWolf.client.GUI.SaleUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.GUI.manageUI.ManageFrame;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class GoodsChoosePanel extends JPanel{
	

	int giftNum = 0;
	
	JScrollPane scroll;
	JPanel panel;
	
	Dimension panelD;
	
	ArrayList<JComboBox<String>> goodsTypeList;
	ArrayList<JComboBox<String>> goodsList;
	ArrayList<JTextField> numList;
	ArrayList<JLabel> labelList;
	ArrayList<JTextField> goodsPriceList;
	
	ArrayList<JButton> deleteList;
	
	ArrayList<TypeVO> typeList;
	
	JButton add = new JButton("增加");
	JButton delete = new JButton("移除");
	
	JComboBox<String> dt = new JComboBox<String>();
	JComboBox<String> dg = new JComboBox<String>();
	JTextField dn = new JTextField();
	JLabel dl = new JLabel("商品 1");
	JTextField dp = new JTextField();
	
	private JLabel goodsTypeLabel = new JLabel("商品分类");
	private JLabel goodsLabel = new JLabel("商品");
	private JLabel goodsNum = new JLabel("商品数量");
	private JLabel goodsPrice = new JLabel("商品单价");
	private JLabel goodsTotal = new JLabel("总价");
	private JLabel goodsRemark = new JLabel("备注");
	
	private final static int LH = 25;
	private final static int Hgap = 70;
	private final static int LW = 120;
	private final static int Lgap = 50;
	private final static int left = 120;
	
	public GoodsChoosePanel() {
		panel = new JPanel();
//		typeList = service.typeList();
		if(typeList == null){
			typeList = new ArrayList<TypeVO>();
		}
		goodsTypeList = new ArrayList<JComboBox<String>>();
		goodsList = new ArrayList<JComboBox<String>>();
		numList = new ArrayList<JTextField>();
		labelList = new ArrayList<JLabel>();
		goodsPriceList = new ArrayList<JTextField>();
		
		goodsTypeLabel.setSize(LW, LH);
		goodsLabel.setSize(LW, LH);
		goodsNum.setSize(LW, LH);
		goodsPrice.setSize(LW, LH);
		goodsTotal.setSize(goodsPrice.getSize());
		goodsRemark.setSize(goodsTotal.getSize());
		
		goodsTypeLabel.setLocation(left, Hgap / 2);
		goodsLabel.setLocation(left + LW + Lgap, Hgap / 2);
		goodsNum.setLocation(left + 2*LW + 2*Lgap, Hgap / 2);
		goodsPrice.setLocation(left + 3*LW + 3*Lgap, Hgap / 2);
		goodsTotal.setLocation(left + 4*LW + 4*Lgap, Hgap / 2);
		goodsRemark.setLocation(left + 5*LW + 5*Lgap, Hgap / 2);
		
		panel.add(goodsTypeLabel);
		panel.add(goodsLabel);
		panel.add(goodsNum);
		panel.add(goodsPrice);
		panel.add(goodsTotal);
		panel.add(goodsRemark);
		
		dt.setEnabled(false);
		dg.setEnabled(false);
		dn.setEnabled(false);
		dp.setEnabled(false);
		
		dt.setSize(LW, LH);
		dg.setSize(LW, LH);
		dn.setSize(LW, LH);
		dl.setSize(Lgap, LH);
		dp.setSize(LW, LH);
		add.setSize(LW / 2, LH);
		delete.setSize(LW / 2, LH);
		
		dt.setLocation(left, Hgap);
		dg.setLocation(left+LW+Lgap, Hgap);
		dn.setLocation(left+2*LW+2*Lgap, Hgap);
		dl.setLocation(left-Lgap, Hgap);
		dp.setLocation(dn.getX() + dn.getWidth() + Lgap, Hgap);
		add.setLocation(left+6*LW+6*Lgap, Hgap);
		
		dt.setBackground(Color.white);
		dg.setBackground(Color.white);
		
		panel.add(dt);
		panel.add(dg);
		panel.add(dn);
		panel.add(dl);
		panel.add(dp);
		panel.add(add);
		
		goodsTypeList.add(dt);
		goodsList.add(dg);
		numList.add(dn);
		goodsPriceList.add(dp);
		labelList.add(dl);
		
		panelD = new Dimension(ManageFrame.width-20, 260);
		
		panel.setLayout(null);
		panel.setPreferredSize(panelD);
		scroll = new JScrollPane(panel);
		scroll.setSize(1300, 260);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(1300, 260);
		this.setLocation(-10, 120);
		this.setVisible(true);
		
		add.addActionListener(new AddButtonListener());
		delete.addActionListener(new DeleteButtonListener());
		delete.setForeground(Color.red);
	}
	
	protected void removeAllGoods(){
		while(giftNum != 0){
			this.removeLast();
			giftNum--;
		}
		panel.remove(delete);
		panel.updateUI();
	}
	
	private void removeLast(){
		goodsTypeList.remove(giftNum);
		goodsList.remove(giftNum);
		numList.remove(giftNum);
		labelList.remove(giftNum);
		goodsPriceList.remove(giftNum);
		
		panel.remove(dt);
		panel.remove(dg);
		panel.remove(dn);
		panel.remove(dl);
		panel.remove(dp);
		
		dt = goodsTypeList.get(giftNum-1);
		dg = goodsList.get(giftNum-1);
		dn = numList.get(giftNum-1);
		dl = labelList.get(giftNum-1);
		dp = goodsPriceList.get(giftNum - 1);
		
		dt.removeAllItems();
		dg.removeAllItems();
		dn.setText(null);
		dp.setText(null);
		
		dt.setEnabled(false);
		dg.setEnabled(false);
		dn.setEnabled(false);
		dp.setEnabled(false);
		
		delete.setLocation(left+6*LW+6*Lgap, (giftNum-1)*Hgap);
		
		add.setLocation(left+6*LW+6*Lgap, giftNum*Hgap);
		
		if((giftNum+4)*Hgap<panelD.height){
			panelD.setSize(ManageFrame.width-20, (giftNum+1)*Hgap);
		}
		
	}
	
	private void setNext(){
		dt = new JComboBox<String>();
		dg = new JComboBox<String>();
		dn = new JTextField();
		dp = new JTextField();
		dl = new JLabel("商品 "+(giftNum+1));
		
		dt.setBackground(Color.white);
		dg.setBackground(Color.white);
		
		dt.setEnabled(false);
		dg.setEnabled(false);
		dp.setEnabled(false);
		dn.setEnabled(false);
		
		dt.setSize(LW, LH);
		dg.setSize(LW, LH);
		dn.setSize(LW, LH);
		dp.setSize(LW, LH);
		dl.setSize(Lgap, LH);
		
		dt.setLocation(left, (giftNum+1)*Hgap);
		dg.setLocation(left+LW+Lgap, (giftNum+1)*Hgap);
		dn.setLocation(left+2*LW+2*Lgap, (giftNum+1)*Hgap);
		dp.setLocation(left+3*LW+3*Lgap, (giftNum+1)*Hgap);
		dl.setLocation(left-Lgap, (giftNum+1)*Hgap);
		add.setLocation(left+6*LW+6*Lgap, (giftNum+1)*Hgap);
		
		delete.setLocation(left+6*LW+6*Lgap, giftNum*Hgap);
		
		goodsTypeList.add(dt);
		goodsList.add(dg);
		numList.add(dn);
		goodsPriceList.add(dp);
		labelList.add(dl);
		
		panel.add(dt);
		panel.add(dg);
		panel.add(dn);
		panel.add(dp);
		panel.add(dl);
		panel.add(delete);
		
		if((giftNum+2)*Hgap>panelD.height){
			panelD.setSize(ManageFrame.width-20, (giftNum+4)*Hgap);
		}
	}
	
	private void setTypeBox(JComboBox<String> type){
		type.removeAllItems();
		for(int i = 0; i < typeList.size(); i++){
			type.addItem(typeList.get(i).getName());
		}
	}
	
	private void setGoodsBox(JComboBox<String> goods, JComboBox<String> type){
		int index = type.getSelectedIndex();
		goods.removeAllItems();
		ArrayList<GoodsVO> list = typeList.get(index).getAllLeave();
		for(int i = 0; i < list.size(); i++){
			goods.addItem(list.get(i).getName());
		}
	}
	
	/**
	 * 获取货物数量
	 * @param type
	 * @param goods
	 * @return
	 */
	private String getGoodsNum(String type, String goods){
		for(int i = 0; i < typeList.size(); i++){
			if(typeList.get(i).getName().equals(type)){
				ArrayList<GoodsVO> list = typeList.get(i).getAllLeave();
				for(int j = 0; j < list.size(); j++){
					if(list.get(j).getName().equals(goods)){
						return list.get(j).getNumber();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 获取货物进货单价
	 * @param type
	 * @param goods
	 * @return
	 */
	private double getGoodsImportPrice(String type, String goods){
		for(int i = 0; i < typeList.size(); i++){
			if(typeList.get(i).getName().equals(type)){
				ArrayList<GoodsVO> list = typeList.get(i).getAllLeave();
				for(int j = 0; j < list.size(); j++){
					if(list.get(j).getName().equals(goods)){
						return list.get(j).getImprice();
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * 商品种类选择
	 */
	class TypeBoxListener implements ActionListener{
		int index = -1;
		public TypeBoxListener(int i){
			super();
			index = i;
		}

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setGoodsBox(goodsList.get(index), goodsTypeList.get(index));
		}
		
	}
	
	/**
	 * 添加按钮事件
	 */
	class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			giftNum++;
			
			dt.setEnabled(true);
			dg.setEnabled(true);
			dn.setEnabled(true);
			dp.setEnabled(true);
			
			setNext();
			
			panel.updateUI();
		}
		
	}
	

	/**
	 * 删除按钮事件
	 */
	class DeleteButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(giftNum > 0){
				
				removeLast();
				
				giftNum--;
				if(giftNum == 0){
					panel.remove(delete);
				}
				
				panel.updateUI();
			}
		}
	}
}
