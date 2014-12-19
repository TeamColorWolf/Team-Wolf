package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;

public class RunProcessPanel extends JPanel{
	
	TableInquireBLservice service = TableInquirePanel.service;
	
	public TimeSelectPanel timeSelect;
	static String[] column = {"单据编号", "客户", "业务员", "仓库编号", "商品名", "销售量", "销售单价"};
	
	public Object[][] content;
	JTable table;
	DefaultTableModel tableModel = new DefaultTableModel();
	JScrollPane scroll;
	
	JButton expert = new JButton("导出");
	
	private final static int width = 960;
	private final static int height = 520;
	private final static int RowH = 25;
	private final static int BW = 80;
	private final static int BH = 25;
	
	private final static int tableW = 955;
	private final static int tableH = 325;
	
	public RunProcessPanel(){
		super();
		
		timeSelect = new TimeSelectPanel();
		
		this.add(timeSelect);
		
		getContent();
		tableModel.setDataVector(content, column);
		table = new JTable(tableModel);
		table.setRowHeight(RowH);
		scroll = new JScrollPane(table);
		scroll.setSize(tableW, tableH);
		scroll.setLocation(0, 70);
		
		this.add(scroll);
		
		expert.setSize(BW, BH);
		expert.setLocation(800, 410);
		
		this.add(expert);
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setVisible(true);
		
		timeSelect.setCheckListener(new RunProcessCheck());
		expert.addActionListener(new ExpertListener(table, "经营历程表"));
		
	}
	
	public void getContent(){
		ArrayList<RunProcessVO> list = service.runProcess(timeSelect.getBeginVO(), timeSelect.getEndVO());
		if(list == null || list.size() < 12){
			content = new Object[12][7];
		}
		else{
			content = new Object[list.size()][7];
		}
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).number;
				content[i][1] = list.get(i).customer;
				content[i][2] = list.get(i).operator;
				content[i][3] = list.get(i).storage;
				content[i][4] = list.get(i).goodsName;
				content[i][5] = list.get(i).goodsAmo;
				content[i][6] = list.get(i).price;
			}
		}
	}
	
	public void flashPanel(){
		getContent();
		tableModel.setDataVector(content, column);
		table.updateUI();
		table.setRowHeight(RowH);
	}
	
	class RunProcessCheck implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(timeSelect.getBeginVO().timeCompare(timeSelect.getEndVO()) > 0){
				new MessageFrame(ErrorTW.timeError);
				return;
			}
			flashPanel();
		}
		
	}
}

