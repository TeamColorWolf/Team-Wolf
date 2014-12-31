package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;

public class LogCheckPanel extends JPanel implements ActionListener{
	TableInquireBLservice service = TableInquirePanel.service;
	
	static String[] column = {"时间", "行为", "具体信息"};
	static int[] columnWidth = {150, 150, 650};
	
	Object[][] content;
	ArrayList<String> list;
	
	JButton flash = new JButton("刷新");
	
	JTable table;
	DefaultTableModel tableModel = new DefaultTableModel();
	JScrollPane scroll;
	
	private final static int width = 960;
	private final static int height = 520;
	private final static int RowH = 25;
	private final static int BW = 80;
	private final static int BH = 25;
	
	private final static int tableW = 955;
	private final static int tableH = 400;
	
	public LogCheckPanel(){
		
		flash.setSize(BW, BH);
		flash.setLocation(800, 410);
		
		getContent();
		tableModel.setDataVector(content, column);
		table = new JTable(tableModel);
		for(int i = 0; i < 3; i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(columnWidth[i]);
		}
		table.setRowHeight(RowH);
		scroll = new JScrollPane(table);
		scroll.setSize(tableW, tableH);
		scroll.setLocation(0, 0);
		
		this.add(scroll);
		this.add(flash);
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setVisible(true);
		
		flash.addActionListener(this);
	}
	
	private void getContent(){
		list = service.logCheck();
		if(list == null){
			content = new Object[15][3];
			return;
		}
		if(list.size() < 15){
			content = new Object[15][3];
		}
		else{
			content = new Object[list.size()][3];
		}
		for(int i = 0; i < list.size(); i++){
			try{
				String[] time = list.get(i).split(">>");//格式为  时间>>事项--具体信息
				if(time.length == 2){
					String[] work = time[1].split("--");
					content[i][0] = time[0];
					if(work.length == 2){
						content[i][1] = work[0];
						content[i][2] = work[1];
					}
				}
			} catch(Exception e){
				i--;
			}
		}
	}
	
	private void flashPanel(){
		getContent();
		tableModel.setDataVector(content, column);
		table.updateUI();
		table.setRowHeight(RowH);
		for(int i = 0; i < 3; i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(columnWidth[i]);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		flashPanel();
	}
}
