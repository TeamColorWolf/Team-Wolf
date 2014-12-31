package TeamWolf.TeamWolf.client.GUI.financeUI;

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
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.GUI.userUI.AdminFrame;
import TeamWolf.TeamWolf.client.GUI.userUI.SetComboBoxUser;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.financeVO;
//修改，删除，查看账户信息的界面
public class AccountOprPanel extends JPanel{
	AccountBlservice service = FinanceFrame.service;
	
	static String[] columnName = {"账户名", "账户余额"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	String UpdateString = "";
	JTable accountTable;
	JScrollPane scroll;
	JButton update = new JButton("确认修改");
	JButton delete = new JButton("确认删除");
	JButton cancel = new JButton("取消");
	JButton check = new JButton("查找");
	String IP;
	JTextField AccountName = new JTextField();
	JTextField AccountMoney = new JTextField();
	
	private JLabel name = new JLabel("账户名");
	private JLabel pass = new JLabel("余额");
	
	
	private final int LW = 100;
	private final int LH = 25;
	private final int TW = 150;
	private final int BH = 30;
	
	private final int left = 530;
	private final int up = 50;
	private final int dis = 80;
	
	public AccountOprPanel(String IP){
		super();
		this.getContent();
		this.IP = IP;
		//service = new financeController(IP);
		tableModel.setDataVector(content, columnName);
		accountTable = new JTable(tableModel);
		accountTable.setSize(400, 400);
		accountTable.setLocation(0, 0);
		accountTable.setVisible(true);
		accountTable.setRowHeight(LH);
		scroll = new JScrollPane(accountTable);
		scroll.setSize(400, 400);
		
		update.setSize(LW, BH);
		delete.setSize(LW, BH);
		cancel.setSize(LW, BH);
		check.setSize(LW, BH);
		
		AccountName.setSize(TW, LH);
		AccountMoney.setSize(TW, LH);
		
		name.setSize(LW, LH);
		pass.setSize(LW, LH);
		
		scroll.setLocation(40, 40);
		
		name.setLocation(left, up);
		AccountName.setLocation(left+LW, up);
		check.setLocation(left+280, up);
		
		
		pass.setLocation(left, up+2*dis);
		AccountMoney.setLocation(left+LW, up+2*dis);
		
		
		update.setLocation(left, up+4*dis);
		delete.setLocation(left+140, up+4*dis);
		cancel.setLocation(left+280, up+4*dis);
		
		this.add(name);
		this.add(AccountName);
		this.add(check);
		this.add(pass);
		this.add(AccountMoney);
		this.add(update);
		this.add(delete);
		this.add(cancel);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(AdminFrame.width, AdminFrame.height-AdminFrame.sho);
		this.setVisible(true);
		this.setLocation(0, AdminFrame.sho);
		
		AccountMoney.setEditable(false);
		
		check.addMouseListener(new CheckListener());
		update.addMouseListener(new UpdateListener());
		delete.addMouseListener(new DeleteListener());
		accountTable.addMouseListener(new TableListener(accountTable));
	}
	//获取内容
	public void getContent(){
		ArrayList<financeVO> list = service.checkVO();
		if(list == null){
			content = new Object[15][3];
		}
		else{
			if(list.size() > 15)
				content = new Object[list.size()][3];
			else 
				content = new Object[15][3];
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).getName();
				content[i][1] = list.get(i).getAccount();
			}
		}
	}
	//刷新
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		accountTable.updateUI();
		this.updateUI();
	}
	//查找按钮的监听
	class CheckListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String name = AccountName.getText();
			financeVO fin=new financeVO(name);
			financeVO vo = service.find(fin);
			if(vo==null){
				MessageFrame mf = new MessageFrame(ErrorTW.notFound);
				return;
			}
			if(vo.error != 0){
				AccountName.setText(null);
				AccountMoney.setText(null);
			}
			else{
				AccountName.setText(vo.getName());
				AccountMoney.setText(""+vo.getAccount());
			}
			flashPanel();
			MessageFrame mf = new MessageFrame(0);
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	//更新按钮的监听
	class UpdateListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int success = -1;
			String oldname = UpdateString;
			String name =AccountName.getText();
			System.out.println(name);
			System.out.println(oldname);
			financeVO oldvo = new financeVO(oldname);
			if(name != null){
				financeVO vo = new financeVO(name);
				success = service.update(oldvo,vo);
			}
			if(success == 0){
				System.out.println("update successfully.");
				flashPanel();
			}
			else if(success == -1){
				System.out.println("no enough information.");
			}
			flashPanel();
			MessageFrame mf = new MessageFrame(0);
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	//删除按钮的监听
	class DeleteListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int success = -1;
			String name = AccountName.getText();
			financeVO vo =new financeVO(name);
			if(name != null){
				success = service.delete(vo);
			}
			if(success == 0){
				System.out.println("delete successfully.");
				flashPanel();
			}
			else if(success == -1){
				System.out.println("no enough information.");
			}
			MessageFrame mf = new MessageFrame(0);
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	//表格监听
	class TableListener implements MouseListener{
		JTable t;
		public TableListener(JTable table){
			t = table;
		}
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row = t.getSelectedRow();
			String name = (String)t.getValueAt(row, 0);
			UpdateString = name;
			if(name != null){
				AccountName.setText(name);
				financeVO  fin= new financeVO(name);
				financeVO vo = service.find(fin);
				if(vo.error != 0){
					AccountName.setText(null);
					AccountMoney.setText(null);
				}
				else{
					AccountName.setText(vo.getName());
				}
			}
			flashPanel();
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
}