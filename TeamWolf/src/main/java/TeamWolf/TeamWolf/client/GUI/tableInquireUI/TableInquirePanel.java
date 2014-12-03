package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import javax.swing.JFrame;

public class TableInquirePanel {
	public static String IP;
	
	final static int width = 960;
	final static int height = 160;
	
	public TableInquirePanel(String IP){
		this.IP = IP;
	}
	
	public static void main(String[] args){
		IP = "127.0.0.1";
		TimeSelectPanel t = new TimeSelectPanel();
		AlterFactPanel a = new AlterFactPanel();
		JFrame f = new JFrame();
		
		f.add(t);
		f.add(a);
		
		f.setLayout(null);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
