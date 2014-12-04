package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.BL.userBL.ForAllUserController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.ForAllUserService;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class AlterFactPanel extends JPanel{
	
	ArrayList<TypeVO> typeList;
	
	static String none = "--none--";
	
	JComboBox<String> customer = new JComboBox<String>();
	JComboBox<String> workID = new JComboBox<String>();
	JComboBox<String> storage = new JComboBox<String>();
	JComboBox<String> type = new JComboBox<String>();
	JComboBox<String> goodsName = new JComboBox<String>();
	
	private JLabel Cus = new JLabel("          客户");
	private JLabel Wor = new JLabel("       工作编号");
	private JLabel Sto = new JLabel("       仓库编号");
	private JLabel Typ = new JLabel("       商品分类");
	private JLabel GoN = new JLabel("       商品名称");
	
	private final static int width = 960;
	private final static int height = 50;
	
	private final static int LW = 100;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int up = 20;
	private final static int left = 0;
	
	public AlterFactPanel(){
		
		setTypeBox(type);
		
		Cus.setSize(BW, LH);
		Cus.setLocation(left, up);
		customer.setSize(LW, LH);
		customer.setLocation(left+BW, up);
		
		Wor.setSize(BW, LH);
		Wor.setLocation(left+LW+BW, up);
		workID.setSize(LW, LH);
		workID.setLocation(left+LW+2*BW, up);
		
		Sto.setSize(BW, LH);
		Sto.setLocation(left+2*LW+2*BW, up);
		storage.setSize(LW, LH);
		storage.setLocation(left+2*LW+3*BW, up);
		
		Typ.setSize(BW, LH);
		Typ.setLocation(left+3*LW+3*BW, up);
		type.setSize(LW, LH);
		type.setLocation(left+3*LW+4*BW, up);
		
		GoN.setSize(BW, LH);
		GoN.setLocation(left+4*LW+4*BW, up);
		goodsName.setSize(LW, LH);
		goodsName.setLocation(left+4*LW+5*BW, up);
		
		this.add(Cus);
		this.add(customer);
		this.add(Wor);
		this.add(workID);
		this.add(Sto);
		this.add(storage);
		this.add(Typ);
		this.add(type);
		this.add(GoN);
		this.add(goodsName);
		
		setCustomerBox();
		setWorkIDBox();
		setStroageBox();
		
		this.setSize(width, height);
		this.setLocation(0, height);
		this.setLayout(null);
		this.setVisible(true);
		
		type.addActionListener(new TypeBoxListener());
	}
	
	public SaleDetialSelectFactVO getFact(){
		String cus = (String)customer.getSelectedItem();
		String wor = (String)workID.getSelectedItem();
		String sto = (String)storage.getSelectedItem();
		String goo = (String)goodsName.getSelectedItem();
		
		if(cus == null || cus.equals(none)) cus = null;
		if(wor == null || wor.equals(none)) wor = null;
		if(goo == null || goo.equals(none)) goo = null;
		if(sto == null || sto.equals(none)) sto = null;
		return new SaleDetialSelectFactVO(cus, wor, sto, goo);
	}
	
	private void setCustomerBox(){
		CustomerOprBLservice getCustomer = new CustomerOpr(TableInquirePanel.IP);
		ArrayList<CustomerVO> list = getCustomer.getAllCustomerList();
		if(list == null) return;
		for(int i = 0; i < list.size(); i++){
			customer.addItem(list.get(i).getName());
		}
		customer.addItem(none);
	}
	
	private void setWorkIDBox(){
		ForAllUserService getWorkID = new ForAllUserController(TableInquirePanel.IP);
		ArrayList<String> list = getWorkID.getWorkNumberList();
		if(list == null) return;
		for(int i = 0; i < list.size(); i++){
			workID.addItem(list.get(i));
		}
		workID.addItem(none);
	}
	
	private void setStroageBox(){
		storage.addItem("仓库1");
		storage.addItem("仓库2");
		storage.addItem("仓库3");
		storage.addItem(none);
	}
	
	private void setTypeBox(JComboBox<String> type){
		ExternalService getTypeList = new ExternalServiceController(TableInquirePanel.IP);
		typeList = getTypeList.getLeaveType();
		type.removeAllItems();
		for(int i = 0; i < typeList.size(); i++){
			type.addItem(typeList.get(i).getName());
		}
	}
	
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
		goods.addItem(none);
	}
	
	class TypeBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setGoodsBox(goodsName, type);
		}
	}
	
}
