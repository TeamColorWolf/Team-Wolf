package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.userBL.ForAllUserController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.ForAllUserService;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class CustomerModPanel extends JPanel{
	
	CustomerOprBLservice customerLogic;
	ForAllUserService userServ;
	
	CustomerVO customer;
	static ArrayList<CustomerVO> customerList;
	ArrayList<String> workerID;
	
	//组件们
	JComboBox<String> kindBox;
	JComboBox<String> levelBox;
	JComboBox<String> salesManBox;
	JButton addButton;
	JTextField nameField;
	JTextField zipCodeField;
	JTextField telField;
	JTextField topLimitField;
	JTextField emailField;
	JTextField addressField;
	JLabel nameLabel;
	JLabel zipCodeLabel;
	JLabel telLabel;
	JLabel topLimitLabel;
	JLabel emailLabel;
	JLabel addressLabel;
	private JScrollPane scroll_customer;
	private JTable customerListTable;
	private DefaultTableModel tModel_customer;
	
	private String[] customerInfo = {"编号", "姓名"};
	private Object[][] object_customerList;
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1000;
	
	/**
	 * 面板高度
	 */
	private static final int h = 500;
	
	/**
	 * 组件宽度(不包括按钮)
	 */
	private static final int conpW = 150;
	
	/**
	 * 组件高度(不包括按钮)
	 */
	private static final int conpH = 50;
	
	/**
	 * 字体
	 */
	Font Btn_FONT = new Font("黑体", Font.BOLD, 16);
	
	//按钮尺寸
	private static final int btnW = 120;
	private static final int btnH = 40;
	
	//组件间距
	private static final int Xgap = 30;
	private static final int Ygap = 40;
	
	//TextField尺寸
	private static final int TField_W_short = 100;
	private static final int TField_W_long = 300;
	private static final int TField_H = 30;
	private static final Dimension TField_Size_S = new Dimension(TField_W_short, TField_H);
	private static final Dimension TField_Size_L = new Dimension(TField_W_long, TField_H);
	
	//标签尺寸
	private static final int Label_W = 70;
	private static final int Label_H = 30;
	private static final Dimension Label_Size = new Dimension(Label_W, Label_H);
	
	public CustomerModPanel(UserVO user, String ip) {
		customerLogic = new CustomerOpr(ip);
		userServ = new ForAllUserController(ip);
		
		customerList = customerLogic.getAllCustomerList();
		workerID = userServ.getWorkNumberList();
		if(customerList == null){
			customerList = new ArrayList<CustomerVO>();
		}
		if(workerID == null){
			workerID = new ArrayList<String>();
		}
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.comboBoxPanel());
		this.add(this.messageFillPanel());
		this.add(this.customerListTable());
		this.add(this.showBtn());
		
		this.setVisible(true);
	}
	
	/**
	 * 客户信息
	 * @return
	 */
	private JScrollPane customerListTable(){
		tModel_customer = new DefaultTableModel(object_customerList, customerInfo);
		customerListTable = new JTable(tModel_customer);
		
		
		//表格设置
		customerListTable.setRowHeight(30);
		TableColumn tc0 = customerListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(customerListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(customerListTable.getDefaultRenderer(Boolean.class));
		
		scroll_customer = new JScrollPane(customerListTable);
		scroll_customer.setSize(220, h - 100);
		scroll_customer.setLocation(10, 10);
		
		customerListTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}		
			public void mouseExited(MouseEvent e) {}		
			public void mouseEntered(MouseEvent e) {}		
			public void mouseClicked(MouseEvent e) {
				int row = customerListTable.getSelectedRow();
				showCustomerInfo(row);
			}
		});
		
		return scroll_customer;
	}
	
	/**
	 * 显示按钮
	 * @return
	 */
	private JButton showBtn(){
		JButton show = new JButton("显示");
		
		show.setSize(btnW, btnH);
		show.setLocation(Xgap, scroll_customer.getHeight() + 20);
		show.setFont(Btn_FONT);
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBtnEvent();
			}
		});
		
		return show;
	}
	
	/**
	 * ComboBox面板(还有添加按钮)
	 * @return
	 */
	private JPanel comboBoxPanel(){

		JPanel jp = new JPanel();
		//panel设置
		jp.setLayout(null);
		jp.setLocation(750, 0);
		jp.setSize(250, h);
		
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		String[] custKind = {"进货商", "销售商"};
		String[] custLevel = {"1", "2", "3", "4", "5"};
		
		kindBox = new JComboBox<String>(custKind);
		levelBox = new JComboBox<String>(custLevel);
		salesManBox = new JComboBox<String>();
		addButton = new JButton("修改");
		
		//设置默认业务员
		for (int i = 0; i < workerID.size(); i++) {
			salesManBox.addItem(workerID.get(i));
		}
		
		//设置Box和button
		kindBox.setSize(conpW, conpH);
		levelBox.setSize(conpW, conpH);
		salesManBox.setSize(conpW, conpH);
		addButton.setSize(btnW, btnH);
		
		kindBox.setLocation(Xgap, Ygap);
		levelBox.setLocation(Xgap, kindBox.getY() + kindBox.getHeight() + Ygap);
		salesManBox.setLocation(Xgap, levelBox.getY() + levelBox.getHeight() + Ygap);
		addButton.setLocation(Xgap, salesManBox.getY() + salesManBox.getHeight() + Ygap * 2);
		
		kindBox.setBorder(BorderFactory.createTitledBorder("客户种类选择"));
		levelBox.setBorder(BorderFactory.createTitledBorder("客户等级选择"));
		salesManBox.setBorder(BorderFactory.createTitledBorder("默认业务员选择"));
		addButton.setFont(ChooseBtn_FONT);
		
		kindBox.setEnabled(true);
		levelBox.setEnabled(true);
		salesManBox.setEnabled(true);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MessageFrame(modBtnAction());
			}
		});
		
		jp.add(kindBox);
		jp.add(levelBox);
		jp.add(salesManBox);
		jp.add(addButton);
		
		return jp;
	}
	
	/**
	 * 信息填写面板
	 * @return
	 */
	private JPanel messageFillPanel(){
		JPanel jp = new JPanel();
		//panel设置
		jp.setLayout(null);
		jp.setLocation(250, 0);
		jp.setSize(500, h);
		
		Font Label_FONT = new Font("黑体", Font.BOLD, 16);
		
		//设置组件
		nameLabel = new JLabel("姓名");
		zipCodeLabel = new JLabel("邮编");
		telLabel = new JLabel("电话");
		topLimitLabel = new JLabel("应收额度");
		emailLabel = new JLabel("电子邮箱");
		addressLabel = new JLabel("地址");
		nameField = new JTextField();
		zipCodeField = new JTextField();
		telField = new JTextField();
		topLimitField = new JTextField();
		emailField = new JTextField();
		addressField = new JTextField();
		
//		//TODO:TEST
//		nameField.setText("name");
//		zipCodeField.setText("zipCode");
//		telField.setText("tel");
//		topLimitField.setText("topLimit");
//		emailField.setText("e-mail");
//		addressField.setText("address");
		
		nameLabel.setSize(Label_Size);
		zipCodeLabel.setSize(Label_Size);
		telLabel.setSize(Label_Size);
		topLimitLabel.setSize(Label_Size);
		emailLabel.setSize(Label_Size);
		addressLabel.setSize(Label_Size);
		nameField.setSize(TField_Size_S);
		zipCodeField.setSize(TField_Size_S);
		telField.setSize(TField_Size_S);
		topLimitField.setSize(TField_Size_S);
		emailField.setSize(TField_Size_L);
		addressField.setSize(TField_Size_L);
		
		nameLabel.setFont(Label_FONT);
		zipCodeLabel.setFont(Label_FONT);
		telLabel.setFont(Label_FONT);
		topLimitLabel.setFont(Label_FONT);
		emailLabel.setFont(Label_FONT);
		addressLabel.setFont(Label_FONT);

		
		nameLabel.setLocation(Xgap, Ygap);
		telLabel.setLocation(Xgap, nameLabel.getY() + nameLabel.getHeight() + Ygap);
		topLimitLabel.setLocation(Xgap, telLabel.getY() + telLabel.getHeight() + Ygap);
		zipCodeLabel.setLocation(Xgap, topLimitLabel.getY() + topLimitLabel.getHeight() + Ygap);
		emailLabel.setLocation(Xgap, zipCodeLabel.getY() + zipCodeLabel.getHeight() + Ygap);
		addressLabel.setLocation(Xgap, emailLabel.getY() + emailLabel.getHeight() + Ygap);
		nameField.setLocation(Xgap + Label_W, nameLabel.getY());
		telField.setLocation(Xgap + Label_W, telLabel.getY());
		topLimitField.setLocation(Xgap + Label_W, topLimitLabel.getY());
		zipCodeField.setLocation(Xgap + Label_W, zipCodeLabel.getY());
		emailField.setLocation(Xgap + Label_W, emailLabel.getY());
		addressField.setLocation(Xgap + Label_W, addressLabel.getY());
		
		jp.add(nameLabel);
		jp.add(telLabel);
		jp.add(topLimitLabel);
		jp.add(zipCodeLabel);
		jp.add(emailLabel);
		jp.add(addressLabel);
		jp.add(nameField);
		jp.add(telField);
		jp.add(topLimitField);
		jp.add(zipCodeField);
		jp.add(emailField);
		jp.add(addressField);
		
		return jp;
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnEvent(){
		clearCustomerTable();
		System.out.println("customerList: " + customerList.size());
//		customerList = TestMain.getCustVOListTEST();
		tModel_customer = (DefaultTableModel) customerListTable.getModel();
		
		for (int i = 0; i < customerList.size(); i++) {
			CustomerVO cvo = customerList.get(i);
			//"编号", "姓名"
			Object[] data = new Object[2];
			data[0] = cvo.getNum();
			data[1] = cvo.getName();	
			tModel_customer.addRow(data);
			customerListTable.setModel(tModel_customer);
		}
	}
	
	/**
	 * 修改按钮事件
	 */
	private int modBtnAction(){
		//未选择要修改的客户
		if(customer == null){
			return ErrorTW.chooseNoModCustomer;
		}
		//信息填写不完整
		if(kindBox.getSelectedItem() == null || levelBox.getSelectedItem() == null ||
				nameField.getText().equals("") || telField.getText().equals("") ||
				addressField.getText().equals("") || zipCodeField.getText().equals("") ||
				emailField.getText().equals("") || topLimitField.getText().equals("")){
			return ErrorTW.lackCustomerInfo;
		}
		//应收额度不能为负
		if(Double.parseDouble(topLimitField.getText()) < 0){
			return ErrorTW.wrongTopLimit;
		}
		
		String num = customer.getNum();
		String kind = (String) kindBox.getSelectedItem();
		String level = (String) levelBox.getSelectedItem();
		String name = nameField.getText();
		String tel = telField.getText();
		String address = addressField.getText();
		String zipCode = zipCodeField.getText();
		String email = emailField.getText();
		String topLimit = topLimitField.getText();
		String receive = Double.toString(customer.getReceive());
		String pay = Double.toString(customer.getPay());
		String businessMan = (String) salesManBox.getSelectedItem();
		
		CustomerVO newVO = new CustomerVO(num, kind, level, name, tel, address, zipCode,
				email, topLimit, receive, pay, businessMan);
		
		int result = customerLogic.Customerupdate(customer, newVO);
		CustomerAddPanel.customerList = customerLogic.getAllCustomerList();
		CustomerDelPanel.customerList = customerLogic.getAllCustomerList();
		customerList = customerLogic.getAllCustomerList();
		return result;
	}
	
	/**
	 * 显示所选客户详细信息
	 */
	private void showCustomerInfo(int row){
		customer = customerList.get(row);
		nameField.setText(customer.getName());
		zipCodeField.setText(customer.getZipCode());
		telField.setText(customer.getTel());
		topLimitField.setText(Double.toString(customer.getTopLimit()));
		emailField.setText(customer.getEmail());
		addressField.setText(customer.getAddress());
		salesManBox.setSelectedItem(customer.getBusinessMan());
		levelBox.setSelectedItem(Integer.toString(customer.getLevel()));
		kindBox.setSelectedItem(customer.getKind());
	}
	
	/**
	 * 清空表格方法
	 */
	private void clearCustomerTable(){
		object_customerList = null;
		tModel_customer.setDataVector(object_customerList, customerInfo);
		customerListTable.updateUI();
		customerListTable.setRowHeight(30);
	}
}
