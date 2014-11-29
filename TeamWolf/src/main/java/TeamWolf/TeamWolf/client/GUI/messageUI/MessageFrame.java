package TeamWolf.TeamWolf.client.GUI.messageUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessageFrame extends JFrame implements ActionListener{
	
	JButton button = new JButton("确定");
	JLabel label = new JLabel();
	JLabel done = new JLabel();
	JPanel panel = new JPanel();
	
	JPanel mPanel = new JPanel();
	
	private final static int width = 400;
	private final static int height = 280;
	
	public MessageFrame(int error){
		super();
		
		label.setSize(width-120, height-100);
		label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setText(GetMessage.getMessage(error));
		label.setLocation(150, 0);
		
		mPanel.setSize(width-120, 80);
		mPanel.setLocation(120, 60);
		mPanel.add(label);
		
		done.setIcon(GetMessage.getImageIcon(error));
		done.setSize(80, 80);
		done.setLocation(40, 40);
		
		button.setSize(80, 30);
		button.setLocation(width/2-40, height-80);
		
		panel.add(mPanel);
		panel.add(done);
		panel.add(button, 0);
		
		panel.setSize(width, height);
		
		this.setContentPane(panel);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	public static void main(String[] args){
		new MessageFrame(0);
	}
	
}
