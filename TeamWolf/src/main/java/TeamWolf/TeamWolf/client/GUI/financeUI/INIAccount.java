package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.financeBL.Initial;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.GUI.userUI.AdminFrame;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.INIVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
//期初账户信息
public class INIAccount extends JPanel{
	AccountBlservice service = FinanceFrame.service;
	InitialBLservice iservice;
    String IP;
	public static final int width = 960;
	public static final int height = 540;
	public static final int sho = 10;
	
	ArrayList<financeVO> list1 ;
	ArrayList<CustomerVO> list2;
	GoodsStockListVO list3;
	
	static String[] columnName = {"账户名", "账户余额"};
	DefaultTableModel tableModel = new DefaultTableModel();
	Object[][] content;
	
	JButton jb = new JButton();
	JButton jbHistory = new JButton();
	
	String UpdateString = "";
	JTable accountTable;
	JScrollPane scroll;
	private final int LH = 25;
	public INIAccount(String IP){
		super();
		this.IP = IP;
		this.getContent();
		iservice = new Initial(IP);
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
		jb.addActionListener(new NewListener());
		
		jbHistory.setLocation(width/2,380-(int)(LH*2.5));
		jbHistory.setSize((int)(width/2.2), LH*2);
		jbHistory.setText("单击此处，查看过往的期初建账情况");
		jbHistory.setVisible(true);
		jbHistory.addActionListener(new HistoryListener());
		
		scroll.setLocation(40, 40);
		
		
		this.add(scroll);
		this.add(jb);
		this.add(jbHistory);
		this.setLayout(null);
		this.setSize(width,height);
		this.setVisible(true);
		this.setLocation(0,0);
	}
	//获取内容
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
	//刷新
	public void flashPanel(){
		this.getContent();
		tableModel.setDataVector(content, columnName);
		accountTable.updateUI();
		this.updateUI();
	}
	//监听“历史信息”
	class HistoryListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//INIHistoryFrame ihf = new INIHistoryFrame();
		   
			INIFrame iframe = new INIFrame(IP);
		}
		
	}
	//监听“新的期初账”
	class NewListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			 list1 =service.checkVO();
			 list2 = INICustomer.customerList;
			 list3 = INIGoods.gsl;
			 int success = iservice.DoInitial(0, list1,list3,list2);
			 if(success == 0){
				 MessageFrame mf = new MessageFrame(0);
			 }else{
				 MessageFrame mf = new MessageFrame(ErrorTW.webError);
			 }
		}
		
	}
	
	//表格监听
	class TableListener implements MouseListener{
		JTable t;
		public TableListener(JTable table){
			t = table;
		}
		public void mouseClicked(MouseEvent arg0) {
			flashPanel();
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}

}