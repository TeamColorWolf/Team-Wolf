package TeamWolf.TeamWolf.client.GUI.financeUI;

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

import TeamWolf.TeamWolf.client.BL.userBL.AdminController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.GUI.userUI.SetComboBoxUser;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class AccountPanel extends JPanel{
	/*AccountBlservice service = FinanceFrame.service;
	
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
	
	*/public AccountPanel(){
		super();
		this.setLayout(null);
		this.setVisible(true);}}
		//this.getContent();
		/*tableModel.setDataVector(content, columnName);
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
		this.setSize(FinanceFrame.width, FinanceFrame.height-FinanceFrame.sho);
		this.setVisible(true);
		this.setLocation(0, FinanceFrame.sho);
		
		workID.setEditable(false);
		
		check.addMouseListener(new CheckListener());
		update.addMouseListener(new UpdateListener());
		delete.addMouseListener(new DeleteListener());
	}*/
	/*
	private void getContent(){
		ArrayList<financeVO> list = service.checkVO();
		if(list == null){
			content = new Object[15][3];
		}
		else{
			if(list.size() > 15)
				content = new Object[list.size()][2];
			else 
				content = new Object[15][2];
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).getName();
				content[i][1] = list.get(i).getAccount();
			}
		}
	}
	
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		userTable.updateUI();
	}
	
	class CheckListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String name = userName.getText();
			financeVO finatemp = new financeVO(name);
			financeVO vo = service.find(finatemp);
			if(vo!= null){
				userName.setText(null);
				workID.setText(null);
				password.setText(null);
			}
			else{
				userName.setText(vo.getName());
				workID.setText(""+vo.getAccount());
			//	SetComboBoxUser.setDefault(power, vo.power);
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
			if(name != null){
				financeVO vo = new financeVO(name);
				financeVO newvo = new financeVO(name);
				success = service.update(vo,newvo);
			}
			if(success == 0){
				System.out.println("update successfully.");
				//flashPanel();
			}
			else if(success == -1){
				System.out.println("no enough information.");
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
				financeVO vo = new financeVO(name);
				success = service.delete(vo);
			}
			if(success == 0){
				System.out.println("delete successfully.");
				//flashPanel();
			}
			else if(success == -1){
				System.out.println("no enough information.");
			}
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
}*/
