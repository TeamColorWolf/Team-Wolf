package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BL.financeBL.Initial;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockVO;
//历史期初建账——商品信息
public class INIHGoods extends JPanel {
	InitialBLservice ibs;
	//GoodsBLController gbcontroller;
	
	int beginYear, endYear, beginMonth, endMonth, beginDay, endDay; 
	String[] years=null;
	String[] months=new String[12];
	String[] tableTitle={"   ", "商品编号", "商品名称", "商品型号", "商品库存数量", "库存均价", "商品进价", "商品售价", "商品最近进价", "商品最近售价", "商品进货量", "平均进货价", "进货总价", "商品出货量", "平均出货价", "出货总价"};
	Object[][] stockInfoList={{"" ,"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};
	String todayDate;
	int year;
	JTable StockShoArea;
	JScrollPane SSAContainer;
	public static GoodsStockListVO gsl=null;
	private static final int lineHeight = 25;
	public INIHGoods(String IP,int number) {
		// TODO Auto-generated constructor stub
		//gbcontroller = new GoodsBLController(IP);
		ibs = new Initial(IP);
		gsl = ibs.FinInitial(number).getGslArray();
        // gsl=gbcontroller.shoStockList(beginDate, endDate);
		Calendar c=Calendar.getInstance();
		year=c.get(Calendar.YEAR);
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		todayDate=s.format(c.getTime());
		for(int i=0;i<12;i++){
			months[i]=""+(i+1);
		}
		years=new String[year-2012];
		for(int i=2013;i<=year;i++){
			years[i-2013]=""+i;
		}
		beginYear=endYear=2013;
		beginMonth=endMonth=1;
		beginDay=endDay=1;
		this.setVisible(true);
		this.setLayout(null);
		this.initialStockShoArea();
		this.add(SSAContainer);
		 ArrayList<GoodsStockVO> gsvlist=gsl.getGoodsSL();
		 
		   int size=gsvlist.size();
		   
		   this.remove(SSAContainer);
		   this.repaint();
		   stockInfoList=new Object[size][16];
		   for(int i=0;i<size;i++){
			   for(int j=0;j<16;j++){
				   if(j==0)
					   stockInfoList[i][j]=""+(i+1);
				   else
				       stockInfoList[i][j]=gsvlist.get(i).getIndexOf(j-1);
			   }
		   }
		   this.initialStockShoArea();
		   StockShoArea.setRowHeight(lineHeight);
		   this.add(SSAContainer);
		   this.repaint();
	}

	public void initialStockShoArea(){
		
		DefaultTableModel model=new DefaultTableModel(stockInfoList, tableTitle);
		//StockShoArea=new JTable(stockInfoList, tableTitle);
		StockShoArea=new JTable(model);
		StockShoArea.setVisible(true);
		StockShoArea.setBounds(0, 0, 1400, 300);
		StockShoArea.getColumnModel().getColumn(0).setPreferredWidth(35);
		for(int i=1;i<16;i++){						
			StockShoArea.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		StockShoArea.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//StockShoArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		SSAContainer=new JScrollPane(StockShoArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		SSAContainer.setVisible(true);
		SSAContainer.setBounds(0,0, 960,450);
		
	}
	
		
}