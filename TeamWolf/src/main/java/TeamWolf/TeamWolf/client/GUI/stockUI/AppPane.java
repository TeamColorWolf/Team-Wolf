package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.GUI.manageUI.ManageFrame;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.GoodsAlarmVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public class AppPane extends JPanel implements ActionListener {
	
	StockApplicationController sacontroller;
	GoodsBLController gbcontroller;
	
	JTabbedPane back;
	
	JButton refreshITM;
	JPanel ITMOprArea;
	JScrollPane ITMContainer;
	JTextArea ITMArea;
	JPanel ITMP;
	
	JButton refreshDTM;
	JPanel DTMOprArea;
	JScrollPane DTMContainer;
	JTextArea DTMArea;
	JPanel DTMP;
	
	JButton refresh;
	JPanel WOprArea;
	JScrollPane WAContainer;
	JTextArea WArea;
	JPanel WarningP;
	
	String[] tableTitle={"单据号", "赠送客户", "商品编号", "商品名称", "赠送数量", "商品进价"};
	Object[][] stockInfoList={{"20141223", "样板", "测试", "测试", "测试", "测试"}};
	JPanel PresentListP;
	JTable shoP;
	JScrollPane shoContainer;
	JPanel oprP;
	JButton pRefresh;
	
	public void initialTMP(){
		
		
	}
	
	public void initialWOprArea(){
		
		WArea=new JTextArea();
		WArea.setEditable(false);
		WArea.setFont(new Font("幼圆", Font.BOLD, 16));
		String alarmInfo="";
		ArrayList<GoodsAlarmVO> gal=gbcontroller.getGoodsAlarm();
		for(GoodsAlarmVO ga: gal){
			alarmInfo=alarmInfo+ga.getWarningInfo()+"\n";
		}
		
		WArea.setText(alarmInfo);
	    WAContainer=new JScrollPane(WArea);
		WOprArea=new JPanel();
		WOprArea.setLayout(new FlowLayout());
		refresh=new JButton("刷新");
		refresh.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String alarmInfo="";
				ArrayList<GoodsAlarmVO> gal=gbcontroller.getGoodsAlarm();
				for(GoodsAlarmVO ga: gal){
					alarmInfo=alarmInfo+ga.getWarningInfo()+"\n";
				}
				
				WArea.setText(alarmInfo);
			}
		});
		WOprArea.add(refresh);
		
	}
	
	public void initialITMP(){
		
		ITMArea=new JTextArea();
		ITMArea.setEditable(false);
		ITMArea.setFont(new Font("幼圆", Font.BOLD, 16));
		String ITMInfo="";
		ArrayList<String> itmL=sacontroller.getITMList();
		for(String itm: itmL){
			ITMInfo=ITMInfo+itm+"\n";
		}
		
		ITMArea.setText(ITMInfo);
	    ITMContainer=new JScrollPane(ITMArea);
	    ITMOprArea=new JPanel();
		ITMOprArea.setLayout(new FlowLayout());
		refreshITM=new JButton("刷新");
		refreshITM.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String ITMInfo="";
				ArrayList<String> itmL=sacontroller.getITMList();
				for(String itm: itmL){
					ITMInfo=ITMInfo+itm+"\n";
				}
				
				ITMArea.setText(ITMInfo);
			}
		});
		ITMOprArea.add(refreshITM);
	}
	
	public void initialDTMP(){
		
		DTMArea=new JTextArea();
		DTMArea.setEditable(false);
		DTMArea.setFont(new Font("幼圆", Font.BOLD, 16));
		String DTMInfo="";
		ArrayList<String> dtmL=sacontroller.getDTMList();
		for(String dtm: dtmL){
			DTMInfo=DTMInfo+dtm+"\n";
		}
		
		DTMArea.setText(DTMInfo);
	    DTMContainer=new JScrollPane(DTMArea);
	    DTMOprArea=new JPanel();
		DTMOprArea.setLayout(new FlowLayout());
		refreshDTM=new JButton("刷新");
		refreshDTM.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String DTMInfo="";
				ArrayList<String> dtmL=sacontroller.getDTMList();
				for(String dtm: dtmL){
					DTMInfo=DTMInfo+dtm+"\n";
				}
				
				DTMArea.setText(DTMInfo);
			}
		});
		DTMOprArea.add(refreshDTM);
	}

	public void initialPane(){
		
		back=new JTabbedPane(JTabbedPane.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);
		ITMP=new JPanel();
		ITMP.setLayout(new BorderLayout());
		ITMP.setVisible(true);
		ITMP.add(ITMContainer, BorderLayout.CENTER);
		ITMP.add(ITMOprArea, BorderLayout.SOUTH);
		back.addTab("库存报溢单", ITMP);
		back.setEnabledAt(0, true);
		DTMP=new JPanel();
		DTMP.setLayout(new BorderLayout());
		DTMP.setVisible(true);
		DTMP.add(DTMContainer, BorderLayout.CENTER);
		DTMP.add(DTMOprArea, BorderLayout.SOUTH);
		back.addTab("库存报损单", DTMP);
		back.setEnabledAt(1, true);
		WarningP=new JPanel();
		WarningP.setLayout(new BorderLayout());
		WarningP.setVisible(true);
		WarningP.add(WAContainer, BorderLayout.CENTER);
		WarningP.add(WOprArea, BorderLayout.SOUTH);
		back.addTab("查看警报", WarningP);
		back.setEnabledAt(2, true);
		PresentListP=new JPanel();
		PresentListP.setLayout(new BorderLayout());
		PresentListP.setVisible(true);
		PresentListP.add(shoContainer);
		PresentListP.add(oprP, BorderLayout.SOUTH);
		back.addTab("赠送单", PresentListP);
		back.setEnabledAt(3, true);
	}
	
	public void initialPList(){
		
		DefaultTableModel model=new DefaultTableModel(stockInfoList, tableTitle);
		//StockShoArea=new JTable(stockInfoList, tableTitle);
		shoP=new JTable(model);
		shoP.setVisible(true);
		shoP.setBounds(0, 0, 1400, 300);
		shoP.getColumnModel().getColumn(0).setPreferredWidth(200);
		for(int i=1;i<6;i++){						
			shoP.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		shoP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//StockShoArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		shoContainer=new JScrollPane(shoP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		shoContainer.setVisible(true);
		shoContainer.setBounds(20, 50, 915, 300);
		
		oprP=new JPanel();
		oprP.setVisible(true);
		oprP.setLayout(new FlowLayout());
		pRefresh=new JButton("刷新赠送单");
		pRefresh.setVisible(true);
		pRefresh.addActionListener(this);
		oprP.add(pRefresh);		
	}
	
	public AppPane(String iP) {
		// TODO Auto-generated constructor stub
		sacontroller=new StockApplicationController(iP);
		gbcontroller=new GoodsBLController(iP);
		initialWOprArea();
		initialITMP();
		initialDTMP();
		initialPList();
		initialPane(); 		   
		this.setLayout(new BorderLayout());
		this.add(back, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		ArrayList<PresentListVO> pl=sacontroller.getPresentList();
		if(pl!=null){
		int size=0;
		for(PresentListVO p:pl){
			size+=p.getPList().size();
		}
	    PresentListP.remove(shoContainer);
		PresentListP.repaint();
		stockInfoList=new Object[size][6];
		int i=0;
		for(PresentListVO p:pl){
			String number=p.number;
			String customer=p.customer.getName();
			ArrayList<GoodsVO> gl=p.getPList();
			for(GoodsVO g:gl){
				stockInfoList[i][0]=number;
				stockInfoList[i][1]=customer;
				stockInfoList[i][2]=g.getNumber();
				stockInfoList[i][3]=g.getName();
				stockInfoList[i][4]=g.getAmount();
				stockInfoList[i][5]=g.getImprice();
				i++;
			}
		}
		 this.initialPList();
		 PresentListP.add(shoContainer, BorderLayout.CENTER);
		 PresentListP.repaint();
		 back.updateUI();
		 this.updateUI();
		}
		else
			new MessageFrame(404);
	}
	
}
