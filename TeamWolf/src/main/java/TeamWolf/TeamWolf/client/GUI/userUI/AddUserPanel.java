package TeamWolf.TeamWolf.client.GUI.userUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class AddUserPanel extends JPanel{
	AdminBLservice service = AdminFrame.service;
	
	public JTextField userID;
	public JPasswordField UserPas;
	public JPasswordField ensurePas;
	public JComboBox<UserType> power;
	public JLabel workID;
	
	public JButton add;
	public JButton cancel;
	
	private JLabel ID = new JLabel("用户名");
	private JLabel pas = new JLabel("密码");
	private JLabel ensure = new JLabel("重复密码");
	private JLabel Power = new JLabel("用户类型");
	private JLabel work = new JLabel("业务编号");
	
	private JLabel isSame = new JLabel();
	
	private final int LW = 80;
	private final int LH = 25;
	private final int TW = 150;
	
	private final int spaH = 100;
	private final int LeX = 180;
	private final int RiX = 550;
	
	private final String falsePas = "ensure your password!";
	private final String rightPas = null;
	
	public AddUserPanel(){
		super();
		userID = new JTextField();
		UserPas = new JPasswordField();
		ensurePas = new JPasswordField();
		power = new JComboBox<UserType>();
		SetComboBoxUser.set(power);
		workID = new JLabel();
		workID.setBackground(Color.white);
		workID.setForeground(Color.BLUE);
		
		isSame.setText(falsePas);
		isSame.setForeground(Color.red);
		
		ID.setSize(LW, LH);
		pas.setSize(LW, LH);
		ensure.setSize(LW, LH);
		Power.setSize(LW, LH);
		work.setSize(LW, LH);
		
		userID.setSize(TW, LH);
		UserPas.setSize(TW, LH);
		ensurePas.setSize(TW, LH);
		isSame.setSize(TW, LH);
		power.setSize(TW, LH);
		workID.setSize(TW, LH);
		
		ID.setLocation(LeX, spaH);
		pas.setLocation(LeX, 2*spaH);
		ensure.setLocation(LeX, 3*spaH);
		Power.setLocation(RiX, spaH);
		work.setLocation(RiX, 2*spaH);
		
		userID.setLocation(LeX+LW, spaH);
		UserPas.setLocation(LeX+LW, 2*spaH);
		ensurePas.setLocation(LeX+LW, 3*spaH);
		isSame.setLocation(LeX+TW+LW, 3*spaH);
		power.setLocation(RiX+LW, spaH);
		workID.setLocation(RiX+LW, 2*spaH);
		
		this.add(ID);
		this.add(userID);
		
		this.add(pas);
		this.add(UserPas);
		
		this.add(ensure);
		this.add(ensurePas);
		this.add(isSame);
		
		this.add(Power);
		this.add(power);
		
		this.add(work);
		this.add(workID);
		
		add = new JButton("添加");
		cancel = new JButton("取消");
		add.setSize(LW, 30);
		cancel.setSize(LW, 30);
		add.setLocation(580, 350);
		cancel.setLocation(730, 350);
		
		this.add(add);
		this.add(cancel);
		this.cancelMouseListener();
		
		this.setLayout(null);
		this.setSize(AdminFrame.width, AdminFrame.height-AdminFrame.sho);
		this.setVisible(true);
		this.setLocation(0, AdminFrame.sho);
		
		add.addMouseListener(new AddUserListener());
		power.addActionListener(new PowerListener());
		UserPas.addCaretListener(new PasListener());
		ensurePas.addCaretListener(new EnsureListener());
		add.setEnabled(false);
	}
	
	private void cancelMouseListener(){
		cancel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				userID.setText(null);
				UserPas.setText(null);
				ensurePas.setText(null);
				workID.setText(null);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
	
	class AddUserListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			String name = userID.getText();
			String password = UserPas.getText();
			String ensure = ensurePas.getText();
			UserType POWER = (UserType)power.getSelectedItem();
			String work = workID.getText();
			if(name == null || name.length() == 0 || password == null || password.length() == 0 || work == null || work.length() == 0){
				new MessageFrame(ErrorTW.userMessageLack);
			}
			if(name.length()>0 && password.length()>0 && work.length()>0 && password.equals(ensure)){
				UserVO vo = new UserVO(name, password, work, POWER);
				int success = service.addUser(vo);
				if(success == 0){
					AdminFrame adf = (AdminFrame)RoleSelecter.frame;
					adf.checkUser.flashPanel();
					System.out.println("add successfully");
				}
				new MessageFrame(success);
			}
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	class PowerListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			UserType POWER = (UserType)power.getSelectedItem();
			String work = service.creatWorkID(POWER);
			workID.setText(work);
			workID.updateUI();
		}
		
	}
	
	class PasListener implements CaretListener{
		
		public void caretUpdate(CaretEvent arg0) {
			String userPas = UserPas.getText();
			String ensure = ensurePas.getText();
			if(userPas.length()>0 && userPas.equals(ensure)){
				add.setEnabled(true);
				isSame.setText(rightPas);
			}
			else{
				add.setEnabled(false);
				isSame.setText(falsePas);
			}
		}
		
	}
	
	class EnsureListener implements CaretListener{
		
		public void caretUpdate(CaretEvent e) {
			String userPas = UserPas.getText();
			String ensure = ensurePas.getText();
			if(userPas.length()>0 && userPas.equals(ensure)){
				add.setEnabled(true);
				isSame.setText(rightPas);
			}
			else{
				add.setEnabled(false);
				isSame.setText(falsePas);
			}
		}
		
	}
}
