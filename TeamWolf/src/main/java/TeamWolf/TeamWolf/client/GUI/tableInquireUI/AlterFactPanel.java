package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.userBL.ForAllUserController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.ForAllUserService;
import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class AlterFactPanel extends JPanel{
	
	JComboBox<String> customer = new JComboBox<String>();
	JComboBox<String> workID = new JComboBox<String>();
	JComboBox<String> storage = new JComboBox<String>();
	
	private JLabel Cus = new JLabel("   客户");
	private JLabel Wor = new JLabel("工作编号");
	private JLabel Sto = new JLabel("仓库编号");
	
	private final static int width = 960;
	private final static int height = 80;
	
	private final static int LW = 100;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int up = 0;
	private final static int left = 80;
	
	public AlterFactPanel(){
		
		Cus.setSize(BW, LH);
		Cus.setLocation(left, up);
		customer.setSize(LW, LH);
		customer.setLocation(left+BW, up);
		
		Wor.setSize(BW, LH);
		Wor.setLocation(left+2*LW+BW, up);
		workID.setSize(LW, LH);
		workID.setLocation(left+2*LW+2*BW, up);
		
		Sto.setSize(BW, LH);
		Sto.setLocation(left+4*LW+2*BW, up);
		storage.setSize(LW, LH);
		storage.setLocation(left+4*LW+3*BW, up);
		
		customer.setBackground(Color.white);
		workID.setBackground(Color.white);
		storage.setBackground(Color.white);
		
		this.add(Cus);
		this.add(customer);
		this.add(Wor);
		this.add(workID);
		this.add(Sto);
		this.add(storage);
		
		setCustomerBox();
		setWorkIDBox();
		setStroageBox();
		
		this.setSize(width, height);
		this.setLocation(0, height);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	private void setCustomerBox(){
		CustomerOprBLservice getCustomer = new CustomerOpr(TableInquirePanel.IP);
		ArrayList<CustomerVO> list = getCustomer.getAllCustomerList();
		if(list == null) return;
		for(int i = 0; i < list.size(); i++){
			customer.addItem(list.get(i).getName()+" "+list.get(i).getNum());
		}
	}
	
	private void setWorkIDBox(){
		ForAllUserService getWorkID = new ForAllUserController(TableInquirePanel.IP);
		ArrayList<String> list = getWorkID.getWorkNumberList();
		if(list == null) return;
		for(int i = 0; i < list.size(); i++){
			workID.addItem(list.get(i));
		}
	}
	
	private void setStroageBox(){
		storage.addItem("仓库1");
		storage.addItem("仓库2");
		storage.addItem("仓库3");
	}
	
}
