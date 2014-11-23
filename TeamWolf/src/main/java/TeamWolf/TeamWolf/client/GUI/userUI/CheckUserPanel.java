package TeamWolf.TeamWolf.client.GUI.userUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BL.userBL.AdminController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class CheckUserPanel extends JPanel{
	AdminBLservice service = new AdminController(AdminFrame.IP);
	
	static String[] columnName = {"用户名", "工作编号", "用户类型"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JTable userTable;
	JScrollPane scroll;
	JButton update = new JButton("确认修改");
	JButton delet = new JButton("确认删除");
	JButton cancel = new JButton("取消");
	JButton check = new JButton("查找");
	
	JTextField userName = new JTextField();
	JTextField password = new JTextField();
	JTextField workID = new JTextField();
	JComboBox<UserType> power = new JComboBox<UserType>();
	
	private JLabel name = new JLabel("用户名");
	private JLabel pass = new JLabel("密码");
	private JLabel workNum = new JLabel("工作编号");
	private JLabel Power = new JLabel("用户类型");
	
	private final int LW = 100;
	private final int LH = 25;
	private final int TW = 150;
	private final int BH = 30;
	
	private final int left = 530;
	private final int up = 50;
	private final int dis = 80;
	
	public CheckUserPanel(){
		super();
		this.getContent();
		tableModel.setDataVector(content, columnName);
		userTable = new JTable(tableModel);
		userTable.setSize(400, 400);
		userTable.setLocation(0, 0);
		userTable.setVisible(true);
		userTable.setRowHeight(LH);
		scroll = new JScrollPane(userTable);
		scroll.setSize(400, 400);
		
		update.setSize(LW, BH);
		delet.setSize(LW, BH);
		cancel.setSize(LW, BH);
		check.setSize(LW, BH);
		
		userName.setSize(TW, LH);
		password.setSize(TW, LH);
		workID.setSize(TW, LH);
		power.setSize(TW, LH);
		power.addItem(UserType.库存管理员);
		power.addItem(UserType.总经理);
		power.addItem(UserType.系统管理员);
		power.addItem(UserType.财务人员);
		power.addItem(UserType.销售人员);
		power.addItem(UserType.销售经理);
		
		name.setSize(LW, LH);
		pass.setSize(LW, LH);
		workNum.setSize(LW, LH);
		Power.setSize(LW, LH);
		
		scroll.setLocation(40, 40);
		
		name.setLocation(left, up);
		userName.setLocation(left+LW, up);
		check.setLocation(left+280, up);
		
		workNum.setLocation(left, up+dis);
		workID.setLocation(left+LW, up+dis);
		
		pass.setLocation(left, up+2*dis);
		password.setLocation(left+LW, up+2*dis);
		
		Power.setLocation(left, up+3*dis);
		power.setLocation(left+LW, up+3*dis);
		
		update.setLocation(left, up+4*dis);
		delet.setLocation(left+140, up+4*dis);
		cancel.setLocation(left+280, up+4*dis);
		
		this.add(name);
		this.add(userName);
		this.add(check);
		this.add(workNum);
		this.add(workID);
		this.add(pass);
		this.add(password);
		this.add(power);
		this.add(Power);
		this.add(update);
		this.add(delet);
		this.add(cancel);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(AdminFrame.width, AdminFrame.height-AdminFrame.sho);
		this.setVisible(true);
		this.setLocation(0, AdminFrame.sho);
	}
	
	private void getContent(){
		ArrayList<UserVO> list = service.checkUserVO();
		if(list == null){
			content = new Object[15][3];
		}
		else{
			if(list.size() > 15)
				content = new Object[list.size()][3];
			else 
				content = new Object[15][3];
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).userName;
				content[i][1] = list.get(i).workID;
				content[i][2] = list.get(i).power;
			}
		}
	}
}
