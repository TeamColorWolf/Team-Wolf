package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class DetialPanel extends JPanel{
	
	static final String[] goodsList = {"编号", "名称", "数量", "单价", "总额"};
	static final String[] financeList = {"账目名", "账目金额"};
	static final String[] stockList = {"编号", "名称", "型号", "数量"};
	
	static String[] columnName;
	
	static JTable table;
	static DefaultTableModel tableModel = new DefaultTableModel();
	
	static Object[][] content;
	
	static JScrollPane scroll;
	
	private final static int width = ManageFrame.width/2;
	private final static int height = ManageFrame.height-60;
	private final static int rowH = 25;
	private final static int tableW = 450;
	private final static int tableH = height-50;
	
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
		int type = 0;
		ArrayList<GoodsVO> list = null;
		ArrayList<financeVO> flist = null;
		String customer = null;
		double total = -1;
		if(vo == null){
			content = new Object[16][5];
			columnName = goodsList;
			return;
		}
		//强制转换并赋值
		if(vo instanceof ImportListVO){
			columnName = goodsList;
			list = ((ImportListVO)vo).getGoodsList();
			customer = ((ImportListVO)vo).getCustomer().getName();
			total = ((ImportListVO)vo).getTotal();
		}
		else if(vo instanceof ImportRejectListVO){
			columnName = goodsList;
			list = ((ImportRejectListVO)vo).getGoodsList();
			customer = ((ImportRejectListVO)vo).getCustomer().getName();
			total = ((ImportRejectListVO)vo).getTotal();
		}
		else if(vo instanceof SaleListVO){
			columnName = goodsList;
			list = ((SaleListVO)vo).getGoodsList();
			customer = ((SaleListVO)vo).getCustomer().getName();
			total = ((SaleListVO)vo).getTotal();
		}
		else if(vo instanceof SaleRejectListVO){
			columnName = goodsList;
			list = ((SaleRejectListVO)vo).getGoodsList();
			customer = ((SaleRejectListVO)vo).getCustomer().getName();
			total = ((SaleRejectListVO)vo).getTotal();
		}
		else if(vo instanceof IncreaseToMatchVO){
			type = 1;
			columnName = stockList;
			content = new Object[16][4];
			content[0][0] = ((IncreaseToMatchVO)vo).getNumber();
			content[0][1] = ((IncreaseToMatchVO)vo).getName();
			content[0][2] = ((IncreaseToMatchVO)vo).getModel();
			content[0][3] = ((IncreaseToMatchVO)vo).getAmount();
			customer = null;
			total = 0;
		}
		else if(vo instanceof DecreaseToMatchVO){
			type = 1;
			columnName = stockList;
			content = new Object[16][4];
			content[0][0] = ((DecreaseToMatchVO)vo).getNumber();
			content[0][1] = ((DecreaseToMatchVO)vo).getName();
			content[0][2] = ((DecreaseToMatchVO)vo).getModel();
			content[0][3] = ((DecreaseToMatchVO)vo).getAmount();
			customer = null;
			total = 0;
		}
		else if(vo instanceof PaymentApplicationVO){
			type = 2;
			columnName = financeList;
			flist = ((PaymentApplicationVO)vo).getAccountList();
		}
		else if(vo instanceof RecieptApplicationVO){
			type = 2;
			columnName = financeList;
			flist = ((RecieptApplicationVO)vo).getAccountList();
		}
		
		if(type == 0){
			if(list == null){
				content = new Object[16][5];
			}
			else if(list != null && list.size() < 15){
				content = new Object[16][5];
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
					content[i][4] = list.get(i).getAmount() * list.get(i).getExprice();
				}
			}
			if(list != null && customer != null && total >= 0){
				content[list.size()][0] = "客户名";
				content[list.size()][1] = customer;
				content[list.size()][3] = "总金额";
				content[list.size()][4] = total;
			}
		}
		else if(type == 2){
			if(flist == null){
				content = new Object[16][2];
			}
			else if(flist != null && flist.size() < 16){
				content = new Object[16][2];
				for(int i = 0; i < flist.size(); i++){
					content[i][0] = flist.get(i).getName();
					content[i][1] = flist.get(i).getAccount();
				}
			}
			else{
				content = new Object[flist.size()][2];
				for(int i = 0; i < flist.size(); i++){
					content[i][0] = flist.get(i).getName();
					content[i][1] = flist.get(i).getAccount();
				}
			}
		}
	}
	
	public void flashPanel(ApplicationVO vo){
		getContent(vo);
		tableModel.setDataVector(content, columnName);
		table.updateUI();
		table.setRowHeight(rowH);
	}
}
