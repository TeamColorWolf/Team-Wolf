package TeamWolf.TeamWolf.client.GUI.userUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class LoginFrame extends JFrame implements LoginBLservice{
	
	public JButton login;
	public JTextField id;
	public JPasswordField password;
	
	private JLabel IDLabel;
	private JLabel PasswordLabel;
	
	private JButton cancel;
	
	private JPanel loginPanel;
	
	final private int label_1_y = 50;
	final private int label_2_y = 120;
	final private int button_3_y = 220;
	
	public LoginFrame(){
		super("用户登录");
		
		id = new JTextField();
		password = new JPasswordField();
		IDLabel = new JLabel("用户名");
		PasswordLabel = new JLabel("密码");
		login = new JButton("登录");
		cancel = new JButton("取消");
		loginPanel = new JPanel();
		
		IDLabel.setSize(50, 25);
		IDLabel.setLocation(50, label_1_y);
		loginPanel.add(IDLabel);
		
		id.setSize(150, 25);
		id.setLocation(100, label_1_y);
		loginPanel.add(id);
		
		PasswordLabel.setSize(50, 25);
		PasswordLabel.setLocation(50, label_2_y);
		loginPanel.add(PasswordLabel);
		
		password.setSize(150, 25);
		password.setLocation(100, label_2_y);
		loginPanel.add(password);
		
		login.setSize(80, 30);
		login.setLocation(55, button_3_y);
		loginPanel.add(login);
		
		cancel.setSize(80, 30);
		cancel.setLocation(165, button_3_y);
		loginPanel.add(cancel);
		
		loginPanel.setSize(300, 300);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		
		this.setContentPane(loginPanel);
		
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.addCancelListener();
	}

	public UserVO loginController(LoginUserVO user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addLoginListener(MouseListener loginListener){
		
	}
	
	private void addCancelListener(){
		cancel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}
