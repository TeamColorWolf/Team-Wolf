package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.financeBL.Initial;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.GUI.financeUI.INIAccount.HistoryListener;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.INIVO;

public class INIFrame extends JFrame{
	InitialBLservice ib;
	String IP;
	String Content="";
	int numberofAll;
	public static final int width = 480;
	public static final int height = 320;
	public static final int LH = 25;
	public static final int LL = 200;
	JLabel InfoLabel = new JLabel("请输入想要查看期初建账的编号");
	public JButton insure = new JButton("万分确定 ");
	JTextField InputLabel = new JTextField(); 
	public INIFrame(String IP){
		super("查看期初建账信息输入");
		this.IP = IP;
		ib = new Initial(IP);
		int all = ib.getINIList().size();
		numberofAll = all;
		JLabel NumberLabel = new JLabel("共有"+(all)+"次期初建账(输入从0开始)");
		InfoLabel.setLocation(width/5, height/6);
		NumberLabel.setLocation(width/5, 2*height/6);
		InputLabel.setLocation(width/5, 6*height/12);
		insure.setLocation(width/5+LL+LH, 6*height/12);
		
		InfoLabel.setSize(LL, LH);
		NumberLabel.setSize(LL, LH);
		InputLabel.setSize(LL, LH);
		insure.setSize(5*LH,LH);
		
		insure.setVisible(true);		
		InfoLabel.setVisible(true);
		NumberLabel.setVisible(true);
		InputLabel.setVisible(true);
		
		insure.addActionListener(new insureListener());
		
		this.setSize(width, height);
		this.getFocusableWindowState();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.add(InfoLabel);
		this.add(NumberLabel);
		this.add(InputLabel);
		this.add(insure);
		this.setVisible(true);
	}
	
	/*public static void main(String[]args){
		INIFrame i = new INIFrame("127.0.0.1");
	}
*/
	
	class insureListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
            Content = InputLabel.getText();
            if(Content.equals("")){
            	MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
	    		return;
            }
            if((!Content.contains("0"))&&(!Content.contains("1"))
    		    	&&(!Content.contains("2"))&&(!Content.contains("3"))
    		        &&(!Content.contains("4"))&&(!Content.contains("5"))
    		    	&&(!Content.contains("6"))&&(!Content.contains("7"))
    		    	&&(!Content.contains("8"))&&(!Content.contains("9"))){
            	MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
	    		return;
            }
            int number = Integer.parseInt(Content);
            if(number>=numberofAll){
            //if(number>numberofAll){
            	MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
	    		return;
            }
          
            
            INIHistoryFrame ihf = new INIHistoryFrame(IP,number);
		}
		
	}
}


