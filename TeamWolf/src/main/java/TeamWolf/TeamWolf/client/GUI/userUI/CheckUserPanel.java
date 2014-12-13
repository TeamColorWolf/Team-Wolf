package TeamWolf.TeamWolf.client.GUI.userUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.userBL.AdminController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class CheckUserPanel extends JPanel{
	AdminBLservice service = AdminFrame.service;
	
	static String[] columnName = {"用户名", "工作编号", "用户类型"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JTable userTable;
	JScrollPane scroll;
	JButton update = new JButton("确认修改");
	JButton delete = new JButton("确认删除");
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
	
	private String work;
	private UserType type;
	
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
		delete.setSize(LW, BH);
		cancel.setSize(LW, BH);
		check.setSize(LW, BH);
		
		userName.setSize(TW, LH);
		password.setSize(TW, LH);
		workID.setSize(TW, LH);
		power.setSize(TW, LH);
		SetComboBoxUser.set(power);
		
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
		delete.setLocation(left+140, up+4*dis);
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
		this.add(delete);
		this.add(cancel);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(AdminFrame.width, AdminFrame.height-AdminFrame.sho);
		this.setVisible(true);
		this.setLocation(0, AdminFrame.sho);
		
		workID.setEditable(false);
		
		check.addMouseListener(new CheckListener());
		update.addMouseListener(new UpdateListener());
		delete.addMouseListener(new DeleteListener());
		power.addActionListener(new PowerListener());
		userTable.addMouseListener(new TableListener(userTable));
	}
	
	private void getContent(){
		ArrayList<UserVO> list = service.checkUserVO();
		if(list == null){
			content = new Object[15][3];
			new MessageFrame(ErrorTW.webError);
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
	
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		userTable.updateUI();
		userTable.setRowHeight(LH);
	}
	
	class CheckListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String name = userName.getText();
			UserVO vo = service.findUser(name);
			if(vo.error != 0){
				userName.setText(null);
				workID.setText(null);
				password.setText(null);
				new MessageFrame(ErrorTW.userNameNotExist);
			}
			else{
				userName.setText(vo.userName);
				workID.setText(vo.workID);
				password.setText(vo.password);
				SetComboBoxUser.setDefault(power, vo.power);
				work = vo.workID;
				type = vo.power;
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class UpdateListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int success = -1;
			String name = userName.getText();
			String pass = password.getText();
			String work = workID.getText();
			UserType Power = (UserType)power.getSelectedItem();
			if(name != null && pass != null && work != null){
				UserVO vo = new UserVO(name, pass, work, Power);
				success = service.update(vo);
			}
			if(success == 0){
				System.out.println("update successfully.");
				flashPanel();
				new MessageFrame(success);
			}
			else if(success == -1){
				System.out.println("no enough information.");
				new MessageFrame(ErrorTW.userInformationLack);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class DeleteListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int success = -1;
			String name = userName.getText();
			if(name != null){
				success = service.removeUser(name);
			}
			if(success == 0){
				System.out.println("delete successfully.");
				flashPanel();
				new MessageFrame(success);
			}
			else if(success == -1){
				System.out.println("no enough information.");
				new MessageFrame(ErrorTW.userInformationLack);
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class PowerListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(type == (UserType)power.getSelectedItem()){
				workID.setText(work);
			}
			else{
				String choice = service.creatWorkID((UserType)power.getSelectedItem());
				workID.setText(choice);
			}
		}
		
	}
	
	class TableListener implements MouseListener{
		JTable t;
		public TableListener(JTable table){
			t = table;
		}
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row = t.getSelectedRow();
			String name = (String)t.getValueAt(row, 0);
			if(name != null){
				userName.setText(name);
				UserVO vo = service.findUser(name);
				if(vo.error != 0){
					userName.setText(null);
					workID.setText(null);
					password.setText(null);
				}
				else{
					userName.setText(vo.userName);
					workID.setText(vo.workID);
					password.setText(vo.password);
					SetComboBoxUser.setDefault(power, vo.power);
					work = vo.workID;
					type = vo.power;
				}
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
}
