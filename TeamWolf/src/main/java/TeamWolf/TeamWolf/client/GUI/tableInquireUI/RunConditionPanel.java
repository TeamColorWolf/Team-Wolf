package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.RunConditionVO;

public class RunConditionPanel extends JPanel{
	TableInquireBLservice service = TableInquirePanel.service;
	
	public TimeSelectPanel timeSelect;
	static String[] column = {"收入类", "支出类", "利润"};
	
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
	
	public RunConditionPanel(){
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
		expert.addActionListener(new ExpertListener(table, "经营情况表"));
		
	}
	
	public void getContent(){
		RunConditionVO run = service.runCondition(timeSelect.getBeginVO(), timeSelect.getEndVO());
		if(run == null){
			new MessageFrame(ErrorTW.webError);
		}
		else{
			content = new Object[12][3];
			content[0][0] = "销售类:  " + run.saleIncome;
			content[1][0] = "商品类:  " + run.stockIncome;
			content[0][1] = "销售类:  " + run.SaleOutcome;
			content[1][1] = "商品类:  " + run.StockOutcome;
			content[0][2] = "销售类：   " + (run.saleIncome - run.SaleOutcome);
			content[1][2] = "商品类:  " + (run.stockIncome - run.StockOutcome);
			content[2][0] = "折让额:  " + run.discount;
			content[3][0] = "总利润:  " + run.profit;
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
