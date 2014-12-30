package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BL.financeBL.Initial;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.vo.financeVO;
//历史期初建账——账户信息
public class INIHAccount extends JPanel{
	InitialBLservice ibs;
	
	int number;
    String IP;
	public static final int width = 960;
	public static final int height = 540;
	public static final int sho = 10;
	
	static String[] columnName = {"账户名", "账户余额"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	
	String UpdateString = "";
	JTable accountTable;
	JScrollPane scroll;
	private final int LH = 25;
	public INIHAccount(String IP,int number){
		super();
		
		ibs = new Initial(IP);
		this.IP = IP;
		this.number = number;
		this.getContent();
		tableModel.setDataVector(content, columnName);
		accountTable = new JTable(tableModel);
		accountTable.setSize(400, 400);
		accountTable.setLocation(0,0);
		accountTable.setVisible(true);
		accountTable.setRowHeight(LH);
		scroll = new JScrollPane(accountTable);
		scroll.setSize(400, 400);
		
		scroll.setLocation(40, 40);
		
		
		this.add(scroll);
		this.setLayout(null);
		this.setSize(width,height);
		this.setVisible(true);
		this.setLocation(0,0);
	}
	
	private void getContent(){
		//ArrayList<financeVO> list = service.checkVO();
		ArrayList<financeVO> list = ibs.getINIList().get(number).getAccArray();
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
	
	class HistoryListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//INIHistoryFrame ihf = new INIHistoryFrame();
			INIFrame iframe = new INIFrame(IP);
		}
		
	}

}