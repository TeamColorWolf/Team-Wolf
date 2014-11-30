package TeamWolf.TeamWolf.client.GUI.saleUI;

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

import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.GUI.manageUI.ManageFrame;
import TeamWolf.TeamWolf.client.vo.GoodsListVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class GoodsChoosePanel extends JPanel{
	
	static ExternalService stockLogic;
	
	int giftNum = 0;
	
	JScrollPane scroll;
	JPanel panel;
	
	Dimension panelD;
	
	ArrayList<JComboBox<String>> goodsTypeListBox;
	ArrayList<JComboBox<String>> goodsListBox;
	ArrayList<JTextField> numListField;
	ArrayList<JLabel> labelListField;
	ArrayList<JTextField> goodsPriceListField;
	ArrayList<JTextField> totalPriceListField;
	ArrayList<JTextField> remarkListField;
	
	ArrayList<JButton> deleteList;
	
	static ArrayList<TypeVO> typeList;
	static ArrayList<GoodsVO> goodsVOList;
	
	JButton add = new JButton("增加");
	JButton delete = new JButton("移除");
	
	JComboBox<String> dt = new JComboBox<String>();
	JComboBox<String> dg = new JComboBox<String>();
	JTextField dn = new JTextField();
	JLabel dl = new JLabel("商品 1");
	JTextField dp = new JTextField();
	JTextField total = new JTextField("总额");
	JTextField remark = new JTextField("备注");
	
	private JLabel goodsTypeLabel = new JLabel("商品分类");
	private JLabel goodsLabel = new JLabel("商品");
	private JLabel goodsNum = new JLabel("商品数量");
	private JLabel goodsPrice = new JLabel("商品单价");
	private JLabel goodsTotal = new JLabel("总额");
	private JLabel goodsRemark = new JLabel("备注");
	
	private final static int LH = 25;
	private final static int Hgap = 70;
	private final static int LW = 120;
	private final static int Lgap = 50;
	private final static int left = 120;
	
	public GoodsChoosePanel(String IP) {
		stockLogic = new ExternalServiceController(IP);
		
		panel = new JPanel();
		typeList = stockLogic.getLeaveType();
		
		if(typeList == null){
			typeList = new ArrayList<TypeVO>();
		}
		goodsTypeListBox = new ArrayList<JComboBox<String>>();
		goodsListBox = new ArrayList<JComboBox<String>>();
		numListField = new ArrayList<JTextField>();
		labelListField = new ArrayList<JLabel>();
		goodsPriceListField = new ArrayList<JTextField>();
		totalPriceListField = new ArrayList<JTextField>();
		remarkListField = new ArrayList<JTextField>();
		
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
		total.setEnabled(false);
		remark.setEnabled(false);
		
		dt.setSize(LW, LH);
		dg.setSize(LW, LH);
		dn.setSize(LW, LH);
		dl.setSize(Lgap, LH);
		dp.setSize(LW, LH);
		total.setSize(LW, LH);
		remark.setSize(LW, LH);
		add.setSize(LW / 2, LH);
		delete.setSize(LW / 2, LH);
		
		dt.setLocation(left, Hgap);
		dg.setLocation(left+LW+Lgap, Hgap);
		dn.setLocation(left+2*LW+2*Lgap, Hgap);
		dl.setLocation(left-Lgap, Hgap);
		dp.setLocation(dn.getX() + dn.getWidth() + Lgap, Hgap);
		total.setLocation(dp.getX() + dp.getWidth() + Lgap, Hgap);
		remark.setLocation(total.getX() + total.getWidth() + Lgap, Hgap);
		add.setLocation(left+6*LW+6*Lgap, Hgap);
		
		dt.setBackground(Color.white);
		dg.setBackground(Color.white);
		
		panel.add(dt);
		panel.add(dg);
		panel.add(dn);
		panel.add(dl);
		panel.add(dp);
		panel.add(total);
		panel.add(remark);
		panel.add(add);
		
		goodsTypeListBox.add(dt);
		goodsListBox.add(dg);
		numListField.add(dn);
		goodsPriceListField.add(dp);
		totalPriceListField.add(total);
		remarkListField.add(remark);
		labelListField.add(dl);
		
		panelD = new Dimension(ManageFrame.width-20, 300);
		
		panel.setLayout(null);
		panel.setPreferredSize(panelD);
		scroll = new JScrollPane(panel);
		scroll.setSize(1300, 300);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(1300, 300);
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
		goodsTypeListBox.remove(giftNum);
		goodsListBox.remove(giftNum);
		numListField.remove(giftNum);
		labelListField.remove(giftNum);
		goodsPriceListField.remove(giftNum);
		totalPriceListField.remove(giftNum);
		remarkListField.remove(giftNum);
		
		panel.remove(dt);
		panel.remove(dg);
		panel.remove(dn);
		panel.remove(dl);
		panel.remove(dp);
		panel.remove(total);
		panel.remove(remark);
		
		dt = goodsTypeListBox.get(giftNum-1);
		dg = goodsListBox.get(giftNum-1);
		dn = numListField.get(giftNum-1);
		dl = labelListField.get(giftNum-1);
		dp = goodsPriceListField.get(giftNum - 1);
		total = totalPriceListField.get(giftNum - 1);
		remark = remarkListField.get(giftNum - 1);
		
		dt.removeAllItems();
		dg.removeAllItems();
		dn.setText(null);
		dp.setText(null);
		total.setText("总额");
		remark.setText("备注");
		
		dt.setEnabled(false);
		dg.setEnabled(false);
		dn.setEnabled(false);
		dp.setEnabled(false);
		total.setEnabled(false);
		remark.setEnabled(false);
		
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
		total = new JTextField("总额");
		remark = new JTextField("备注");
		dl = new JLabel("商品 "+(giftNum+1));
		
		dt.setBackground(Color.white);
		dg.setBackground(Color.white);
		
		dt.setEnabled(false);
		dg.setEnabled(false);
		dp.setEnabled(false);
		dn.setEnabled(false);
		total.setEnabled(false);
		remark.setEnabled(false);
		
		dt.setSize(LW, LH);
		dg.setSize(LW, LH);
		dn.setSize(LW, LH);
		dp.setSize(LW, LH);
		total.setSize(LW, LH);
		remark.setSize(LW, LH);
		dl.setSize(Lgap, LH);
		
		dt.setLocation(left, (giftNum+1)*Hgap);
		dg.setLocation(left+LW+Lgap, (giftNum+1)*Hgap);
		dn.setLocation(left+2*LW+2*Lgap, (giftNum+1)*Hgap);
		dp.setLocation(left+3*LW+3*Lgap, (giftNum+1)*Hgap);
		total.setLocation(left+4*LW+4*Lgap, (giftNum+1)*Hgap);
		remark.setLocation(left+5*LW+5*Lgap, (giftNum+1)*Hgap);
		dl.setLocation(left-Lgap, (giftNum+1)*Hgap);
		add.setLocation(left+6*LW+6*Lgap, (giftNum+1)*Hgap);
		
		delete.setLocation(left+6*LW+6*Lgap, giftNum*Hgap);
		
		goodsTypeListBox.add(dt);
		goodsListBox.add(dg);
		numListField.add(dn);
		goodsPriceListField.add(dp);
		labelListField.add(dl);
		totalPriceListField.add(total);
		remarkListField.add(remark);
		
		panel.add(dt);
		panel.add(dg);
		panel.add(dn);
		panel.add(dp);
		panel.add(dl);
		panel.add(total);
		panel.add(remark);
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
	
	/**
	 * 设置GoodsBox
	 * @param goods
	 * @param type
	 */
	private void setGoodsBox(JComboBox<String> goods, JComboBox<String> type){
		int index = type.getSelectedIndex();
		goods.removeAllItems();
		ArrayList<GoodsVO> list = null;
		if(index >= 0){
			list = typeList.get(index).getAllLeave();
		}
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				goods.addItem(list.get(i).getName());
			}
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
			setGoodsBox(goodsListBox.get(index), goodsTypeListBox.get(index));
		}
		
	}
	
	/**
	 * 添加按钮事件
	 */
	class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setTypeBox(dt);
			dt.addActionListener(new TypeBoxListener(giftNum));
			giftNum++;
			
			dt.setEnabled(true);
			dg.setEnabled(true);
			dn.setEnabled(true);
			dp.setEnabled(true);
			total.setEnabled(true);
			remark.setEnabled(true);
			
			dg.addActionListener(new GoodsBoxListener(giftNum));
			
			setNext();
			
			panel.updateUI();
			
			
		}
		
	}
	
	/**
	 * 选择具体商品事件
	 */
	class GoodsBoxListener implements ActionListener{
		int index = -1;
		public GoodsBoxListener(int giftNum) {
			super();
			index = giftNum - 1;
		}
		
		public void actionPerformed(ActionEvent e) {
			double price = getGoodsImportPrice((String)goodsTypeListBox.get(index).getSelectedItem(),
					(String)goodsListBox.get(index).getSelectedItem());
			goodsPriceListField.get(index).setText(Double.toString(price));
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
