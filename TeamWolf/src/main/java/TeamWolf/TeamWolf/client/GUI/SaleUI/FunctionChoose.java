package TeamWolf.TeamWolf.client.GUI.SaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/**
 * 
 * @author HalaWKS
 *
 */
public class FunctionChoose extends JFrame{
	
	/**
	 * 选择类型判断
	 * a = 1:客户管理；a = 2:单据添加
	 */
	private int a;
	
	/**
	 * 登录面板高度
	 */
	private static final int h = 400;
	
	/**
	 * 登录面板宽度
	 */
	private static final int w = 500;
	
	
	public FunctionChoose(String name, String num, String ip) {
		//设置布局管理器为“null”
		this.setLayout(null);
		//设置标题
		this.setTitle("进货销售员——功能选择");
		//设置大小
		this.setSize(w, h);
		//居中
		FramUtil.setFrameCenter(this);
		//添加各种面板
		this.add(this.messagePanel(name, num));
		this.add(this.funChoosePanel());
		this.add(this.assistPanel(ip));
		this.add(this.buttonPanel());
		//设置不能变大小
		this.setResizable(false);
		//关闭方式
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	/**
	 * 用户信息显示面板
	 * @param name
	 * @param number
	 * @return
	 */
	private JPanel messagePanel(String name, String number){
		//创建标签面板
		JPanel jp = new JPanel();
		jp.setLayout(null);
//		jp.setBackground(Color.BLUE);
		JLabel userName = new JLabel("姓名:" + name);
		JLabel userNum = new JLabel("编号:" + number);
		Font message_FONT= new Font("楷体", Font.BOLD, 24);
		
		//设置面板大小
		jp.setSize(w / 2, h * 2 / 3);
		//设置标签大小
		userName.setSize(jp.getWidth(), jp.getHeight() / 3);
		userNum.setSize(userName.getSize());
		//设置标签位置
		userName.setLocation(jp.getWidth() / 4, jp.getHeight() / 6);
		userNum.setLocation(userName.getX(), jp.getHeight() / 2);
		//设置标签字体
		userName.setFont(message_FONT);
		userNum.setFont(message_FONT);
		
		jp.add(userName);
		jp.add(userNum);
		
		return jp;
	}
	
	/**
	 * 辅助信息显示面板
	 * @param ip
	 * @return
	 */
	private JPanel assistPanel(String ip){
		//创建标签面板
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		JLabel ipLabel = new JLabel("当前ip:" + ip);
		Font message_FONT= new Font("楷体", Font.BOLD, 16);
		
		//设置面板属性
		jp.setSize(w / 3, h / 3);
		jp.setLocation(0, h * 2 / 3);
		//设置标签大小
		ipLabel.setSize(jp.getWidth(), jp.getHeight() / 3);
		//设置标签位置
		ipLabel.setLocation(jp.getWidth() / 6, jp.getHeight() / 6);
		//设置标签字体
		ipLabel.setFont(message_FONT);

		jp.add(ipLabel);
		
		return jp;
	}
	
	/**
	 * 功能选择面板
	 * @return
	 */
	private JPanel funChoosePanel(){
		//创建功能选择面板
		JPanel jp = new JPanel();
//		jp.setBackground(Color.GREEN);
		//设置布局方式为null
		jp.setLayout(null);
		
		JRadioButton btnCustomerAdmin = new JRadioButton("客户管理");
		JRadioButton btnCreateList = new JRadioButton("创建单据");
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 14);
		
		//设置面板属性
		jp.setSize(w / 2, h * 2 / 3);
		jp.setLocation(w / 2, 0);

		//按钮属性设置
		btnCustomerAdmin.setSize(jp.getWidth(), jp.getHeight() / 3);
		btnCreateList.setSize(btnCustomerAdmin.getSize());
		btnCustomerAdmin.setFont(ChooseBtn_FONT);
		btnCreateList.setFont(ChooseBtn_FONT);
		btnCustomerAdmin.setLocation(jp.getWidth() / 4, jp.getHeight() / 6);
		btnCreateList.setLocation(btnCustomerAdmin.getX(), jp.getHeight() / 2);
		//添加到按钮组里，用以单选
		ButtonGroup userChoose = new ButtonGroup();
		userChoose.add(btnCustomerAdmin);
		userChoose.add(btnCreateList);
		
		//对按钮添加事件监听
		btnCustomerAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 1;
				System.out.println(a);
			}
		});
		btnCreateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 2;
				System.out.println(a);
			}
		});
		
		jp.add(btnCustomerAdmin);
		jp.add(btnCreateList);
		
		return jp;
	}
	
	/**
	 * 按钮面板
	 * @return
	 */
	private JPanel buttonPanel(){
		//创建标签面板
		JPanel jp = new JPanel();
		jp.setLayout(null);

		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 14);
		JButton buttonConfirm = new JButton("确定");
		JButton buttonExit = new JButton("注销");
		
		//设置面板属性
		jp.setSize(w * 2 / 3, h / 3);
		jp.setLocation(w / 3, h * 2 / 3);
		//设置按钮
		buttonConfirm.setSize(jp.getWidth() / 3, 40);
		buttonExit.setSize(buttonConfirm.getSize());
		buttonConfirm.setLocation(jp.getWidth() / 9, jp.getHeight() / 6);
		buttonExit.setLocation(5 * buttonConfirm.getX(), buttonConfirm.getY());
		buttonConfirm.setFont(ChooseBtn_FONT);
		buttonExit.setFont(ChooseBtn_FONT);
		
		
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonEvent();
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jp.add(buttonConfirm);
		jp.add(buttonExit);
		
		return jp;
	}
	
	/**
	 * 点击确定按钮事件
	 */
	private void confirmButtonEvent(){
		switch (a) {
		case 1:
			new CustomerAdminFrame();
			break;
		case 2:
			new CreateListFrame();
			break;
		default:
			break;
		}
	}
}
