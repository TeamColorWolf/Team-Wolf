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

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.vo.GoodsAlarmVO;

public class AppPane extends JPanel  {
	
	GoodsBLController gbcontroller;
	
	JTabbedPane back;
	JPanel ITMP;
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

	public void initialPane(){
		
		back=new JTabbedPane(JTabbedPane.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);
		ITMP=new JPanel();
		ITMP.setLayout(null);
		ITMP.setVisible(true);
		back.addTab("库存报溢单", ITMP);
		back.setEnabledAt(0, true);
		DTMP=new JPanel();
		DTMP.setLayout(null);
		DTMP.setVisible(true);
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
		gbcontroller=new GoodsBLController(iP);
		initialWOprArea();
		initialPane(); 		   
		this.setLayout(new BorderLayout());
		this.add(back, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
}
