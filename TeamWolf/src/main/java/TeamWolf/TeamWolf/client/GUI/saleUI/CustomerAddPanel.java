package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class CustomerAddPanel extends JPanel{
	
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
	private static final int conpW = 200;
	
	/**
	 * 组件高度(不包括按钮)
	 */
	private static final int conpH = 60;
	

	//按钮尺寸
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	//组件间距
	private static final int Xgap = 30;
	private static final int Ygap = 40;
	
	//TextField尺寸
	private static final int TField_W_short = 150;
	private static final int TField_W_long = 500;
	private static final int TField_H = 30;
	private static final Dimension TField_Size_S = new Dimension(TField_W_short, TField_H);
	private static final Dimension TField_Size_L = new Dimension(TField_W_long, TField_H);
	
	//标签尺寸
	private static final int Label_W = 70;
	private static final int Label_H = 30;
	private static final Dimension Label_Size = new Dimension(Label_W, Label_H);
		
	public CustomerAddPanel(UserVO user, String ip) {
		userServ = new ForAllUserController(ip);
		customerLogic = new CustomerOpr(ip);
		
		workerID = userServ.getWorkNumberList();
		customerList = customerLogic.getAllCustomerList();
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
		
		this.setVisible(true);
	}
	
	/**
	 * ComboBox面板(还有添加按钮)
	 * @return
	 */
	private JPanel comboBoxPanel(){

		JPanel jp = new JPanel();
		//panel设置
		jp.setLayout(null);
		jp.setLocation(700, 0);
		jp.setSize(300, h);
		
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		String[] custKind = {"进货商", "销售商"};
		String[] custLevel = {"1", "2", "3", "4", "5"};

		
		kindBox = new JComboBox<String>(custKind);
		levelBox = new JComboBox<String>(custLevel);
		salesManBox = new JComboBox<String>();
		addButton = new JButton("添加");
		
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
				new MessageFrame(addBtnAction());
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
		jp.setLocation(0, 0);
		jp.setSize(690, h);
		
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
	 * 添加按钮事件
	 */
	private int addBtnAction(){
		//信息填写不完整
		if(kindBox.getSelectedItem() == null || levelBox.getSelectedItem() == null ||
				nameField.getText().equals("") || telField.getText().equals("") ||
				addressField.getText().equals("") || zipCodeField.getText().equals("") ||
				emailField.getText().equals("") || topLimitField.getText().equals("")){
			return 701;
		}
		//检查该客户是否已经存在
		for (int i = 0; i < customerList.size(); i++) {
			CustomerVO cvo = customerList.get(i);
			if(nameField.getText().equals(cvo.getName()) && telField.getText().equals(cvo.getTel())){
				return 704;
			}
		}
		//应收额度不能为负
		if(Double.parseDouble(topLimitField.getText()) < 0){
			return 706;
		}
		
		String num =  getCustomerNum();
		String kind = (String) kindBox.getSelectedItem();
		String level = (String)levelBox.getSelectedItem();
		String name = nameField.getText();
		String tel = telField.getText();
		String address = addressField.getText();
		String zipCode = zipCodeField.getText();
		String email = emailField.getText();
		String topLimit = topLimitField.getText();
		String receive = "0";
		String pay = "0";
		String businessMan = (String) salesManBox.getSelectedItem();
		customer = new CustomerVO(num, kind, level, name, tel, address,
				zipCode, email, topLimit, receive, pay, businessMan);
		System.out.println("addsuccess");
		
//		CustomerDelPanel.customerList.add(customer);
		int result = customerLogic.Customeradd(customer);
		CustomerDelPanel.customerList = customerLogic.getAllCustomerList();
		CustomerModPanel.customerList = customerLogic.getAllCustomerList();
		return result;
	}
	
	/**
	 * 获取客户编号
	 * @return
	 */
	private String getCustomerNum(){
		if(customerList.size() == 0){
			return String.format("%05d", 1);
		}
		int num = Integer.parseInt(customerList.get(customerList.size() - 1).getNum());
		String number = String.format("%05d", num + 1);
		return number;
	}
}
