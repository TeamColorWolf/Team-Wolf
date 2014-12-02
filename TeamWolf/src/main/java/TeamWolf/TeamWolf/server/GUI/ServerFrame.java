package TeamWolf.TeamWolf.server.GUI;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.server.DATAfactory.DATAfactory;

import java.awt.Font;

public class ServerFrame extends JFrame{
	
	JLabel localIP = new JLabel();
	JLabel port = new JLabel();
	
	JPanel panel = new JPanel();
	
	private final static int width = 500;
	private final static int height = 500;
	
	public ServerFrame(){
		DATAfactory fac = new DATAfactory();
		
		localIP.setFont(new Font("微软雅黑", Font.BOLD, 35));
		localIP.setLocation(0, 0);
		
		localIP.setSize(width, height/2);
		port.setFont(new Font("微软雅黑", Font.BOLD, 35));
		port.setLocation(0, 214);
		port.setSize(width,height/2);
		
		localIP.setText("   Local IP : " + getlocalIP());
		port.setText("      Using port is 1099" );
		
		panel.add(localIP);
		panel.add(port);
		
		panel.setSize(width, height);
		panel.setLayout(null);
		panel.setLocation(0, 0);
		
		this.setContentPane(panel);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private String getlocalIP(){
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			return addr.getHostAddress().toString();//获得本机IP
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private int getPort(){
		return 1099;
	}
	
	public static void main(String[] args){
		new ServerFrame();
	}
	
}
