package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class DetialPanel extends JPanel{
	
	static final String[] goodsList = {"编号", "名称", "数量", "单价", "总额"};
	static final String[] financeList = {"账目名", "账目金额"};
	
	static String[] columnName;
	
	static JTable table;
	static DefaultTableModel tableModel = new DefaultTableModel();
	
	static Object[][] content;
	
	static JScrollPane scroll;
	
	private final static int width = ManageFrame.width/2;
	private final static int height = ManageFrame.height-60;
	private final static int rowH = 25;
	private final static int tableW = 450;
	private final static int tableH = height;
	
	public DetialPanel(){
		super();
		
		this.getContent(null);
		columnName = goodsList;
		tableModel.setDataVector(content, columnName);
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		
		table.setSize(tableW, tableH);
		table.setLocation(0, 0);
		table.setRowHeight(rowH);
		scroll.setSize(tableW, tableH);
		scroll.setLocation(0, 0);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(width, height);
		this.setLocation(width, 0);
	}
	
	public void getContent(ApplicationVO vo){
		ArrayList<GoodsVO> list = null;
		String customer = null;
		double total = -1;
		if(vo == null){
			content = new Object[18][5];
			columnName = goodsList;
			return;
		}
		if(vo instanceof ImportListVO){
			columnName = goodsList;
			list = ((ImportListVO)vo).getGoodsList();
			customer = ((ImportListVO)vo).getCustomer().getName();
			total = ((ImportListVO)vo).getTotal();
		}
		//TODO 还要补充其他的单据情况
		if(list == null){
			content = new Object[18][5];
		}
		else if(list != null && list.size() < 17){
			content = new Object[18][5];
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).getNumber();
				content[i][1] = list.get(i).getName() + " " + list.get(i).getModel();
				content[i][2] = list.get(i).getAmount();
				content[i][3] = list.get(i).getExprice();
				content[i][4] = list.get(i).getAmount() * list.get(i).getExprice();
			}
		}
		else{
			content = new Object[list.size()+1][5];
			for(int i = 0; i < list.size(); i++){
				content[i][0] = list.get(i).getNumber();
				content[i][1] = list.get(i).getName() + " " + list.get(i).getModel();
				content[i][2] = list.get(i).getAmount();
				content[i][3] = list.get(i).getExprice();
				content[i][4] = (Double)content[i][3] * (Double)content[i][2];
			}
		}
		if(list != null && customer != null && total >= 0){
			content[list.size()][0] = "客户名";
			content[list.size()][1] = customer;
			content[list.size()][3] = "总金额";
			content[list.size()][4] = total;
		}
	}
	
	public void flashPanel(ApplicationVO vo){
		getContent(vo);
		tableModel.setDataVector(content, columnName);
		table.updateUI();
	}
}
