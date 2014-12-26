package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.UserVO;


/**
 * 
 * @author HalaWKS
 *
 */
public class CustomerFinPanel extends JPanel{

	CustomerVO customer;
	CustomerOprBLservice customerLogic;
	
	//组件们
	JButton inquireBtn;
	JTextField numberInputField;
	JTextField nameImpurField;
	JTextField kindField;
	JTextField levelField;
	JTextField salesManField;
	JTextField nameField;
	JTextField zipCodeField;
	JTextField telField;
	JTextField topLimitField;
	JTextField emailField;
	JTextField addressField;
	JTextArea shouldPayArea;
	JTextArea shouldReceiveArea;
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
	
	public CustomerFinPanel(UserVO user, String ip) {
		customerLogic = new CustomerOpr(ip);
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.messageShowPanel_one());
		this.add(this.messageShowPanel_two());
		this.add(this.messageFillIn());
		
		this.setVisible(true);
	}
	

	/**
	 * 搜索信息
	 * @return
	 */
	private JPanel messageFillIn(){
		JPanel jp = new JPanel();
		//panel设置
		jp.setLayout(null);
		jp.setSize(220, h - 100);
		jp.setLocation(10, 10);
		
		//组件设置
		numberInputField = new JTextField();
		nameImpurField = new JTextField();
		numberInputField.setSize(conpW, conpH);
		nameImpurField.setSize(conpW, conpH);
		numberInputField.setLocation(Xgap, Ygap);
		nameImpurField.setLocation(Xgap, numberInputField.getY() + numberInputField.getHeight() + Ygap);
		numberInputField.setBorder(BorderFactory.createTitledBorder("输入编号"));
		nameImpurField.setBorder(BorderFactory.createTitledBorder("输入姓名"));
		
		inquireBtn = new JButton("查询");
		inquireBtn.setSize(btnW, btnH);
		inquireBtn.setLocation(Xgap, nameImpurField.getY() + nameImpurField.getHeight() + Ygap);
		inquireBtn.setFont(Btn_FONT);
		inquireBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inquireBtnEvent();
			}
		});
		
		jp.add(numberInputField);
		jp.add(nameImpurField);
		jp.add(inquireBtn);
		
		return jp;
	}
	
	/**
	 * 信息显示2
	 * @return
	 */
	private JPanel messageShowPanel_two(){

		JPanel jp = new JPanel();
		//panel设置
		jp.setLayout(null);
		jp.setLocation(750, 0);
		jp.setSize(250, h);
		
		kindField = new JTextField("kind");
		levelField = new JTextField("level");
		salesManField = new JTextField("salesMan");
		shouldPayArea = new JTextArea();
		shouldReceiveArea = new JTextArea();
		
		//组件设置
		kindField.setSize(conpW, conpH);
		levelField.setSize(conpW, conpH);
		salesManField.setSize(conpW, conpH);
		shouldPayArea.setSize(conpW, conpH);
		shouldReceiveArea.setSize(conpW, conpH);
		
		kindField.setLocation(Xgap, Ygap);
		levelField.setLocation(Xgap, kindField.getY() + kindField.getHeight() + Ygap);
		salesManField.setLocation(Xgap, levelField.getY() + levelField.getHeight() + Ygap);
		shouldPayArea.setLocation(Xgap, salesManField.getY() + salesManField.getHeight() + Ygap);
		shouldReceiveArea.setLocation(Xgap, shouldPayArea.getY() + shouldPayArea.getHeight() + Ygap);
		
		kindField.setBorder(BorderFactory.createTitledBorder("客户种类"));
		levelField.setBorder(BorderFactory.createTitledBorder("客户等级"));
		salesManField.setBorder(BorderFactory.createTitledBorder("默认业务员"));
		shouldPayArea.setBorder(BorderFactory.createTitledBorder("应付金额"));
		shouldReceiveArea.setBorder(BorderFactory.createTitledBorder("应收金额"));

		kindField.setEditable(false);
		levelField.setEditable(false);
		salesManField.setEditable(false);
		shouldPayArea.setEditable(false);
		shouldReceiveArea.setEditable(false);
		
		jp.add(kindField);
		jp.add(levelField);
		jp.add(salesManField);
		jp.add(shouldPayArea);
		jp.add(shouldReceiveArea);
		
		return jp;
	}
	
	
	/**
	 * 信息显示面板
	 * @return
	 */
	private JPanel messageShowPanel_one(){
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
		
		//TODO:TEST
		nameField.setText("name");
		zipCodeField.setText("zipCode");
		telField.setText("tel");
		topLimitField.setText("topLimit");
		emailField.setText("e-mail");
		addressField.setText("address");
		
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
		
		nameField.setEditable(false);
		telField.setEditable(false);
		topLimitField.setEditable(false);
		zipCodeField.setEditable(false);
		emailField.setEditable(false);
		addressField.setEditable(false);
		
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
	 * 查询按钮事件
	 */
	private void inquireBtnEvent(){
		customer = customerLogic.findCustomer(nameImpurField.getText(), numberInputField.getText());
		if(customer == null){
			 new MessageFrame(ErrorTW.notFondCustomer);
			 return;
		}
		kindField.setText(customer.getKind());
		levelField.setText(Integer.toString(customer.getLevel()));
		salesManField.setText(customer.getBusinessMan());
		nameField.setText(customer.getName());
		zipCodeField.setText(customer.getZipCode());
		telField.setText(customer.getTel());
		topLimitField.setText(Double.toString(customer.getTopLimit()));
		emailField.setText(customer.getEmail());
		addressField.setText(customer.getAddress());
		shouldPayArea.setText(Double.toString(customer.getPay()));
		shouldReceiveArea.setText(Double.toString(customer.getReceive()));
	}
	
	
}
