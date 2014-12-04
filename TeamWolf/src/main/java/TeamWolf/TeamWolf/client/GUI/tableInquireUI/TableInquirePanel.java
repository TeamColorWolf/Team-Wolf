package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TableInquirePanel extends JPanel{
	public static String IP;
	
	final static int width = 960;
	final static int height = 540;
	
	public TableInquirePanel(String IP){
		super();
		this.IP = IP;
		
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		IP = "127.0.0.1";
		
		TimeSelectPanel t = new TimeSelectPanel();
		AlterFactPanel a = new AlterFactPanel();
		JFrame f = new JFrame();
		
		SwingUtilities.updateComponentTreeUI(f);
		
		f.add(t);
		f.add(a);
		
		f.setLayout(null);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
