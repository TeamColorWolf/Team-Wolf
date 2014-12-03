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
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.vo.GoodsAlarmVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class AppPane extends JPanel  {
	
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
				
				ITMArea.setText(DTMInfo);
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
	}
	
	public AppPane(String iP) {
		// TODO Auto-generated constructor stub
		sacontroller=new StockApplicationController(iP);
		gbcontroller=new GoodsBLController(iP);
		initialWOprArea();
		initialITMP();
		initialDTMP();
		initialPane(); 		   
		this.setLayout(new BorderLayout());
		this.add(back, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
}
