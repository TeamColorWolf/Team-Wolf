package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.GUI.userUI.AdminFrame;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class INIAccount extends JPanel{
	AccountBlservice service = FinanceFrame.service;
	

	public static final int width = 960;
	public static final int height = 540;
	public static final int sho = 10;
	
	static String[] columnName = {"账户名", "账户余额"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JButton jb = new JButton();
	
	String UpdateString = "";
	JTable accountTable;
	JScrollPane scroll;
	private final int LH = 25;
	public INIAccount(){
		super();
		this.getContent();
		tableModel.setDataVector(content, columnName);
		accountTable = new JTable(tableModel);
		accountTable.setSize(400, 400);
		accountTable.setLocation(0,0);
		accountTable.setVisible(true);
		accountTable.setRowHeight(LH);
		scroll = new JScrollPane(accountTable);
		scroll.setSize(400, 400);
		jb.setLocation(width/2,380);
		jb.setSize((int)(width/2.2), LH*2);
		jb.setText("确认期初信息无误后，单击此处进行期初建账");
		jb.setVisible(true);
		
		
		scroll.setLocation(40, 40);
		
		
		this.add(scroll);
		this.add(jb);
		this.setLayout(null);
		this.setSize(width,height);
		this.setVisible(true);
		this.setLocation(0,0);
	}
	
	private void getContent(){
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
	
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		accountTable.updateUI();
		this.updateUI();
	}
	

}