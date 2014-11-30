package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.GUI.mainUI.RoleSelecter;
import TeamWolf.TeamWolf.client.vo.financeVO;
public class AccountnewPanel extends JPanel{
	AccountBlservice service = FinanceFrame.service;
	
	public JTextField userID;
	public JLabel workID;
	
	public JButton add;
	public JButton cancel;
	
	private JLabel ID = new JLabel("用户名");
	
	private final int LW = 80;
	private final int LH = 25;
	private final int TW = 150;
	
	private final int spaH = 100;
	private final int LeX = 180;
	private final int RiX = 550;
	
	public AccountnewPanel(){
		super();
		userID = new JTextField();
		workID = new JLabel();
		workID.setBackground(Color.white);
		workID.setForeground(Color.BLUE);
		
		ID.setSize(LW, LH);
		
		userID.setSize(TW, LH);
		workID.setSize(TW, LH);
		
		ID.setLocation(LeX, spaH);
		
		userID.setLocation(LeX+LW, spaH);
		workID.setLocation(RiX+LW, 2*spaH);
		
		this.add(ID);
		this.add(userID);
		
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
		this.setSize(FinanceFrame.width,FinanceFrame.height-FinanceFrame.sho);
		this.setVisible(true);
		this.setLocation(0, FinanceFrame.sho);
		
		add.addMouseListener(new AddUserListener());
	}
	
	private void cancelMouseListener(){
		cancel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				userID.setText(null);
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
	
	class AddUserListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String name = userID.getText();
				financeVO vo =new financeVO(name);
				int success = service.add(vo);
				if(success == 0){
					FinanceFrame adf = (FinanceFrame)RoleSelecter.frame;
					adf.accountpanel.aop.flashPanel();
					userID.setText("");
				}
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
}
