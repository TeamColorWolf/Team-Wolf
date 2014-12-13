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
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;

public class SaleDetialPanel extends JPanel{
	TableInquireBLservice service = TableInquirePanel.service;
	
	TimeSelectPanel timeSelect = new TimeSelectPanel();
	AlterFactPanel alter = new AlterFactPanel();
	
	static String[] column = {"单据编号", "客户", "业务员", "仓库编号", "商品名", "销售量", "销售单价"};
	
	Object[][] content;
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
	private final static int tableH = 300;
	
	public SaleDetialPanel(){
		super();
		
		this.add(timeSelect);
		this.add(alter);
		
		getContent(null);
		tableModel.setDataVector(content, column);
		table = new JTable(tableModel);
		table.setRowHeight(RowH);
		scroll = new JScrollPane(table);
		scroll.setSize(tableW, tableH);
		scroll.setLocation(0, 105);
		
		this.add(scroll);
		
		expert.setSize(BW, BH);
		expert.setLocation(800, 410);
		
		this.add(expert);
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setVisible(true);
		
		timeSelect.setCheckListener(new SaleDetialCheck());
		expert.addActionListener(new ExpertListener(table, "销售明细表"));
	}
	
	private void getContent(SaleDetialSelectFactVO fact){
		if(fact == null){
			content = new Object[11][7];
			return;
		}
		else{
			ArrayList<SaleDetialVO> list = service.saleDetial(alter.getFact(), timeSelect.getBeginVO(), timeSelect.getEndVO());
			if(list == null || list.size() < 11){
				content = new Object[11][7];
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
	}
	
	private void flashPanel(){
		getContent(alter.getFact());
		tableModel.setDataVector(content, column);
		table.updateUI();
		table.setRowHeight(RowH);
	}
	
	class SaleDetialCheck implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(timeSelect.getBeginVO().timeCompare(timeSelect.getEndVO()) > 0){
				new MessageFrame(ErrorTW.timeError);
				return;
			}
			flashPanel();
		}
		
	}
	
}
