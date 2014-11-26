package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class StockShowPane extends JPanel implements ItemListener, ActionListener {

	int beginYear, endYear, beginMonth, endMonth, beginDay, endDay; 
	String[] years=null;
	String[] months=new String[12];
	String[] tableTitle={"商品编号", "商品名称", "商品型号", "商品库存数量", "商品进价", "商品售价", "商品最近进价", "商品最近售价", "商品进货量", "平均进货价", "进货总价", "商品出货量", "平均出货价", "出货总价"};
	Object[][] stockInfoList={{"12102", "hi", "lala", "df", "sd", "sa", "er", "oo", "wqe", "rr", "iop", "asd", "pp", "132"}};
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
	
	public StockShowPane(){
		
		Calendar c=Calendar.getInstance();
		year=c.get(Calendar.YEAR);
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		todayDate=s.format(c.getTime());
		for(int i=0;i<12;i++){
			months[i]=""+(i+1);
		}
		years=new String[year-2013];
		for(int i=2014;i<=year;i++){
			years[i-2014]=""+i;
		}
		if((year-2013)==1){
			beginYear=endYear=year;
		}
		this.setVisible(true);
		this.setLayout(null);
		this.initialStockShoArea();
		this.initialOperationArea();
		this.add(SSAContainer);
		this.add(daliyStock);
		this.add(checkStock);
		this.add(beginY);
		this.add(beginM);
		this.add(beginD);
		this.add(to);
		this.add(endY);
		this.add(endM);
		this.add(endD);
	}
	
	public void initialStockShoArea(){
		
		StockShoArea=new JTable(stockInfoList, tableTitle);
		StockShoArea.setVisible(true);
		StockShoArea.setBounds(0, 0, 1400, 300);
		for(int i=0;i<14;i++){
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
		beginY.setBounds(120, 380, 100, 25);
		beginY.setVisible(true);
		beginY.addItemListener(this);
		beginM.setBounds(240,380, 100, 25);
		beginM.setVisible(true);
		beginM.addItemListener(this);
		beginD.setBounds(360, 380, 100, 25);
		beginD.setVisible(true);
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
		daliyStock=new JButton("库存快照");
		daliyStock.setBounds(200, 430, 120, 25);
		daliyStock.setVisible(true);
		daliyStock.addActionListener(this);
		daliyStock.setToolTipText(todayDate);
		checkStock=new JButton("查看库存");
		checkStock.setBounds(600, 430, 120, 25);
		checkStock.setVisible(true);
		checkStock.addActionListener(this);
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange()==ItemEvent.SELECTED){
						
			if(((JComboBox)e.getSource()).equals(beginY)){
				
				beginYear=Integer.parseInt((String)e.getItem());
			}
			else if(((JComboBox)e.getSource()).equals(endY)){
				
				endYear=Integer.parseInt((String)e.getItem());
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
			}
			else if(((JComboBox)e.getSource()).equals(endM)){
				   endMonth=Integer.parseInt((String)e.getItem());
				   int days=0;
				   if(beginMonth==1||beginMonth==3||beginMonth==5||beginMonth==7||beginMonth==8||beginMonth==10||beginMonth==12){
					    days=31;
				    }
				   else if(beginMonth==2){
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
			}
			else if(((JComboBox)e.getSource()).equals(beginD)){
				
				beginDay=Integer.parseInt((String)e.getItem());
			}
			else{
				
				endDay=Integer.parseInt((String)e.getItem());
			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(((JButton)e.getSource()).equals(daliyStock)){
			
			/*stockInfoList=null;
			stockInfoList=new Object[1][14];
			for(int i=0;i<1;i++){
				for(int j=0;j<14;j++){
					stockInfoList[i][j]=""+j;
				}
			}*/
		   this.remove(SSAContainer);
		   this.repaint();
		   this.initialStockShoArea();
		   this.add(SSAContainer);
		   this.repaint();
		}
	}
	
	
}
