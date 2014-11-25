package TeamWolf.TeamWolf.client.GUI.stockUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import TeamWolf.TeamWolf.client.vo.UserVO;

public class MainPane extends JPanel {

	UserVO user;
	String IP;
	JTextPane InfoArea=new JTextPane();
	JTextPane AnnouceArea=new JTextPane();
	JScrollPane APContainer;	
	JButton refresh;
	
	public MainPane(UserVO user, String IP){
		
		this.user=user;
		this.IP=IP;
		this.setLayout(null);
		this.setVisible(true);
		this.initialRefresh();
		this.initialInfoArea();
		this.initialAnnouceArea();
		this.add(InfoArea);
		this.add(APContainer);
		this.add(refresh);
		this.repaint();
	}
	
	public void initialRefresh(){
		
		refresh=new JButton("刷新");
		refresh.setBounds(420, 435, 120, 30);
		refresh.setEnabled(true);
		refresh.setVisible(true);
	}
	
	public void initialInfoArea(){
		
		/*SimpleAttributeSet aSet = new SimpleAttributeSet();   
	    StyleConstants.setForeground(aSet, Color.blue);  
	    StyleConstants.setBackground(aSet, Color.orange);  
	    StyleConstants.setFontFamily(aSet, "lucida bright italic");  
	    StyleConstants.setFontSize(aSet, 10);*/  
	   
	    SimpleAttributeSet bSet = new SimpleAttributeSet();  
	    StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);   
	    StyleConstants.setFontFamily(bSet, "lucida typewriter bold");  
	    StyleConstants.setFontSize(bSet, 18);  
	        
		InfoArea.setVisible(true);
		InfoArea.setSize(800, 30);
		InfoArea.setLocation(75, 50);
		InfoArea.setEditable(false);
		InfoArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		InfoArea.setText("操作员："+user.workID+"--"+user.userName+"             IP地址："+IP);
		StyledDocument doc = InfoArea.getStyledDocument();  
	    //doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);  
	    doc.setParagraphAttributes(0, 104, bSet, false);  
	}
	
	public void initialAnnouceArea(){
		
		SimpleAttributeSet aSet = new SimpleAttributeSet();   
	    StyleConstants.setForeground(aSet, Color.blue);  
	    StyleConstants.setBackground(aSet, Color.orange);  
	    StyleConstants.setFontFamily(aSet, "lucida bright italic");  
	    StyleConstants.setFontSize(aSet, 10);  
	   
	    SimpleAttributeSet bSet = new SimpleAttributeSet();  
	    StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);   
	    StyleConstants.setFontFamily(bSet, "lucida typewriter bold");  
	    StyleConstants.setFontSize(bSet, 14);  
	    
		AnnouceArea.setVisible(true);
		AnnouceArea.setEditable(true);
		AnnouceArea.setBounds(0, 0, 800, 300);
		AnnouceArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		StyledDocument doc = AnnouceArea.getStyledDocument();  
	    doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);  
	    doc.setParagraphAttributes(0, 104, bSet, false);  
	    
		APContainer=new JScrollPane(AnnouceArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		APContainer.setBounds(75, 120, 800, 300);
		APContainer.setVisible(true);
	}
}
