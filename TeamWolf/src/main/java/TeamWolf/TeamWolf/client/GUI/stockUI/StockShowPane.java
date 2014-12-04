package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class StockShowPane extends JPanel implements ItemListener, ActionListener {

	GoodsBLController gbcontroller;
	
	int beginYear, endYear, beginMonth, endMonth, beginDay, endDay; 
	String[] years=null;
	String[] months=new String[12];
	String[] tableTitle={"   ", "商品编号", "商品名称", "商品型号", "商品库存数量", "库存均价", "商品进价", "商品售价", "商品最近进价", "商品最近售价", "商品进货量", "平均进货价", "进货总价", "商品出货量", "平均出货价", "出货总价"};
	Object[][] stockInfoList={{"1" ,"12102", "样板", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试", "测试"}};
	String todayDate;
	int year;
	JComboBox beginY;
	JComboBox beginM;
	JComboBox beginD;
	JComboBox endY;
	JComboBox endM;
	JComboBox endD;
	JLabel to;
	JTable StockShoArea;
	JScrollPane SSAContainer;
	JButton checkStock;
	JButton daliyStock;
	JButton exportExcel;
	
	 	
	public StockShowPane(String iP) {
		// TODO Auto-generated constructor stub
		
		gbcontroller=new GoodsBLController(iP);
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
		this.initialOperationArea();
		this.add(SSAContainer);
		this.add(daliyStock);
		this.add(checkStock);
		this.add(exportExcel);
		this.add(beginY);
		this.add(beginM);
		this.add(beginD);
		this.add(to);
		this.add(endY);
		this.add(endM);
		this.add(endD);
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
		SSAContainer.setBounds(20, 50, 915, 300);
		
	}
	
	public void initialOperationArea(){
		 
		beginY=new JComboBox(years);
		beginM=new JComboBox(months);
		beginD=new JComboBox(new DefaultComboBoxModel());
		endY=new JComboBox(years);
		endM=new JComboBox(months);
		endD=new JComboBox(new DefaultComboBoxModel());
		for(int i=0;i<31;i++){
			endD.addItem(""+(i+1));
			beginD.addItem(""+(i+1));
		}
		beginY.setBounds(120, 380, 100, 25);
		beginY.setVisible(true);
		beginY.addItemListener(this);
		beginM.setBounds(240,380, 100, 25);
		beginM.setVisible(true);
		beginM.addItemListener(this);
		beginD.setBounds(360, 380, 100, 25);
		beginD.setVisible(true);
		beginD.addItemListener(this);
		to=new JLabel("～");
		to.setFont(new Font("SansSerif", Font.BOLD, 16));
		to.setBounds(480, 380, 100, 25);
		endY.setBounds(520, 380, 100, 25);
		endY.setVisible(true);
		endY.addItemListener(this);
		endM.setBounds(640, 380, 100, 25);
		endM.setVisible(true);
		endM.addItemListener(this);
		endD.setBounds(760, 380, 100, 25);
		endD.setVisible(true);
		endD.addItemListener(this);
		daliyStock=new JButton("库存快照");
		daliyStock.setBounds(200, 430, 120, 25);
		daliyStock.setVisible(true);
		daliyStock.addActionListener(this);
		daliyStock.setToolTipText(todayDate);
		
		checkStock=new JButton("查看库存");
		checkStock.setBounds(600, 430, 120, 25);
		checkStock.setVisible(true);
		checkStock.addActionListener(this);
		
		exportExcel=new JButton("导出表单");
		exportExcel.setVisible(true);
		exportExcel.setBounds(400, 430, 120, 25);
		exportExcel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
			    
				ExcelExporter eep=new ExcelExporter();
				Calendar c=Calendar.getInstance();
				SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd-HHmmss");
				String date=s.format(c.getTime());
				try {
					eep.exportTable(StockShoArea, new File(date+"-库存表单.xls"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange()==ItemEvent.SELECTED){
						
			if(((JComboBox)e.getSource()).equals(beginY)){
				
				beginYear=Integer.parseInt((String)e.getItem());
				System.out.println(beginYear);
			}
			else if(((JComboBox)e.getSource()).equals(endY)){
				
				endYear=Integer.parseInt((String)e.getItem());
				System.out.println(endYear);
			}			
			else if(((JComboBox)e.getSource()).equals(beginM)){
			   
			   beginMonth=Integer.parseInt((String)e.getItem());
			   int days=0;
			   if(beginMonth==1||beginMonth==3||beginMonth==5||beginMonth==7||beginMonth==8||beginMonth==10||beginMonth==12){
				    days=31;
			    }
			   else if(beginMonth==2){
				   if(beginYear!=0){
					   if((beginYear%4!=0)||(beginYear%100==0&&beginYear%400!=0)){
						     days=28;
					   }
					   else{
						     days=29;
					   }
				   }
			   }
			   else{
				   days=30;
			   }
			   beginD.removeAllItems();
			   for(int i=0;i<days;i++){
				    beginD.addItem(""+(i+1));
			   }		
			   this.remove(beginD);
			   this.add(beginD);	
			   //System.out.println(beginMonth);
			}
			else if(((JComboBox)e.getSource()).equals(endM)){
				   endMonth=Integer.parseInt((String)e.getItem());
				   int days=0;
				   if(endMonth==1||endMonth==3||endMonth==5||endMonth==7||endMonth==8||endMonth==10||endMonth==12){
					    days=31;
				    }
				   else if(endMonth==2){
					   if(endYear!=0){
						   if((endYear%4!=0)||(endYear%100==0&&endYear%400!=0)){
							     days=28;
						   }
						   else{
							     days=29;
						   }
					   }
				   }
				   else{
					   days=30;
				   }
				   endD.removeAllItems();
				   for(int i=0;i<days;i++){
					    endD.addItem(""+(i+1));
				   }		
				   this.remove(endD);
				   this.add(endD);	
				   //System.out.println(endMonth);
			}
			else if(((JComboBox)e.getSource()).equals(beginD)){
				
				beginDay=Integer.parseInt((String)e.getItem());
				//System.out.println(beginDay);
			}
			else{
				
				endDay=Integer.parseInt((String)e.getItem());
				//System.out.println(endDay);
			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*stockInfoList=null;
		stockInfoList=new Object[1][14];
		for(int i=0;i<1;i++){
			for(int j=0;j<14;j++){
				stockInfoList[i][j]=""+j;
			}
		}*/
		
		GoodsStockListVO gsl=null;
		
		if(((JButton)e.getSource()).equals(daliyStock)){
			
			gsl=gbcontroller.shoStockDaily();
		  
		}
		else{
			
			int beginDate=beginYear*10000+beginMonth*100+beginDay;
			int endDate=endYear*10000+endMonth*100+endDay;
		    gsl=gbcontroller.shoStockList(beginDate, endDate);
		}
		
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
		   this.add(SSAContainer);
		   this.repaint();
	}
	
	
}
