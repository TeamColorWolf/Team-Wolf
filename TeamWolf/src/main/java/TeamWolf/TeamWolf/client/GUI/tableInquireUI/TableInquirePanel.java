package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import TeamWolf.TeamWolf.client.BL.tableInquireBL.TableInquireController;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;

public class TableInquirePanel extends JPanel{
	public static String IP;
	
	public static TableInquireBLservice service;
	
	JTabbedPane tab = new JTabbedPane();
	
	SaleDetialPanel saleDetial;
	public RunProcessPanel runProcess;
	
	final static int width = 960;
	final static int height = 540;
	
	public TableInquirePanel(String IP){
		super();
		this.IP = IP;
		
		service = new TableInquireController(IP);
		
		saleDetial = new SaleDetialPanel();
		runProcess = new RunProcessPanel();
		
		tab.add(runProcess, "经营历程表");
		tab.add(saleDetial, "销售明细表");
		tab.setSize(width, height);
		tab.setLocation(0, 0);
		
		this.add(tab);
		
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		IP = "127.0.0.1";
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame f = new JFrame();
		TableInquirePanel tip = new TableInquirePanel(IP);
		
		f.add(tip);
		
		f.setLayout(null);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
