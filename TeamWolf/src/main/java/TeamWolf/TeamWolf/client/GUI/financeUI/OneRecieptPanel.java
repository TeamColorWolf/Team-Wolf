package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class OneRecieptPanel extends JPanel{
	
	//AccountBlservice service = ReceiptPanel.service;
	
	AccountBlservice service = null;
	String IP;
	int MoneyNum = 0;
	
	JScrollPane scroll;
	JPanel panel;
	
	Dimension panelD;
	
	ArrayList<JComboBox<String>> AccountList;
	ArrayList<JTextField> moneyList;
	ArrayList<JLabel> labelList;

	ArrayList<JButton> deleteList;
	ArrayList<financeVO> financeList;
	
	JButton add = new JButton("增加");
	JButton delete = new JButton("移除");
	
	JComboBox<String> AccountString = new JComboBox<String>();
	JTextField MoneyString = new JTextField();
	JLabel newLabel = new JLabel("条目1");
	
	private JLabel goodsTypeLabel = new JLabel("转账账户");
	private JLabel goodsNum = new JLabel("转账金额");
	
	private final static int LH = 25;
	private final static int Hgap = 70;
	private final static int LW = 150;
	private final static int Lgap = 80;
	private final static int left = 130;
	
	public OneRecieptPanel(String IP){
		panel = new JPanel();
		
		
		this.IP = IP;
		//financeList = service.checkVO();
		
		if(financeList == null){
			financeList = new ArrayList<financeVO>();
		}
		AccountList = new ArrayList<JComboBox<String>>();
		moneyList = new ArrayList<JTextField>();
		labelList = new ArrayList<JLabel>();
		
		goodsTypeLabel.setSize(LW, LH);
		goodsNum.setSize(LW, LH);
		
		goodsTypeLabel.setLocation(left, Hgap/2);
		goodsNum.setLocation(left+2*LW+2*Lgap-LW-50, Hgap/2);
		
		panel.add(goodsTypeLabel);
		panel.add(goodsNum);
		
		AccountString.setEnabled(false);
		MoneyString.setEnabled(false);
		
		AccountString.setSize(LW, LH);
		MoneyString.setSize(LW, LH);
		newLabel.setSize(Lgap, LH);
		add.setSize(Lgap, LH);
		delete.setSize(Lgap, LH);
		
		AccountString.setLocation(left, Hgap);
		MoneyString.setLocation(left+2*LW+2*Lgap-LW-50, Hgap);
		newLabel.setLocation(left-Lgap, Hgap);
		add.setLocation(left+3*LW+3*Lgap, Hgap);
		
		AccountString.setBackground(Color.white);
		
		panel.add(AccountString);
		panel.add(MoneyString);
		panel.add(newLabel);
		panel.add(add);
		
		AccountList.add(AccountString);
		moneyList.add(MoneyString);
		labelList.add(newLabel);
		
		panelD = new Dimension(FinanceFrame.width-20, 260);
		
		panel.setLayout(null);
		panel.setPreferredSize(panelD);
		scroll = new JScrollPane(panel);
		scroll.setSize(FinanceFrame.width, 260);
		
		this.add(scroll);
		
		this.setLayout(null);
		this.setSize(FinanceFrame.width, 260);
		this.setLocation(-10, 70);
		this.setVisible(true);
		
		add.addActionListener(new AddButtonListener());
		delete.addActionListener(new DeleteButtonListener());
		delete.setForeground(Color.red);
	}
	

	protected void removeAllAccounts(){
		while(MoneyNum != 0){
			this.removeLast();
			MoneyNum--;
		}
		panel.remove(delete);
		panel.updateUI();
	}
	
	private void setNext(){
		
		AccountString = new JComboBox<String>();
		MoneyString = new JTextField();
		newLabel = new JLabel("条目 "+(MoneyNum+1));
		 
		AccountString.setBackground(Color.white);
		
		AccountString.setEnabled(false);
		MoneyString.setEnabled(false);
		
		AccountString.setSize(LW, LH);
		MoneyString.setSize(LW, LH);
		newLabel.setSize(Lgap, LH);
		
		AccountString.setLocation(left, (MoneyNum+1)*Hgap);
		MoneyString.setLocation(left+2*LW+2*Lgap-LW-50, (MoneyNum+1)*Hgap);
		newLabel.setLocation(left-Lgap, (MoneyNum+1)*Hgap);
		add.setLocation(left+3*LW+3*Lgap, (MoneyNum+1)*Hgap);
		
		delete.setLocation(left+3*LW+3*Lgap, MoneyNum*Hgap);
		
		AccountList.add(AccountString);
		moneyList.add(MoneyString);
		labelList.add(newLabel);
		
		panel.add(AccountString);
		panel.add(MoneyString);
		panel.add(newLabel);
		panel.add(delete);
		
		if((MoneyNum+2)*Hgap>panelD.height){
			panelD.setSize(FinanceFrame.width-20, (MoneyNum+4)*Hgap);
		}
	}
	
	private void removeLast(){
		AccountList.remove(MoneyNum);
		moneyList.remove(MoneyNum);
		labelList.remove(MoneyNum);
		
		panel.remove(AccountString);
		panel.remove(MoneyString);
		panel.remove(newLabel);
		
		AccountString = AccountList.get(MoneyNum-1);
		MoneyString = moneyList.get(MoneyNum-1);
		newLabel = labelList.get(MoneyNum-1);
		
		AccountString.removeAllItems();
		MoneyString.setText(null);
		
		AccountString.setEnabled(false);
		MoneyString.setEnabled(false);
		
		delete.setLocation(left+3*LW+3*Lgap, (MoneyNum-1)*Hgap);
		
		add.setLocation(left+3*LW+3*Lgap, MoneyNum*Hgap);
		
		if((MoneyNum+4)*Hgap<panelD.height){
			panelD.setSize(FinanceFrame.width-20, (MoneyNum+1)*Hgap);
		}
		
	}
	
	
	/*class AccountBoxListener implements ActionListener{
		int index = -1;
		public AccountBoxListener(int i){
			super();
			index = i;
		}

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//setAccountsBox(AccountList.get(index));
		}

		
	}*/
	private void setAccountsBox(JComboBox<String> accounts) {
		accounts.removeAllItems();
		for(int i=0;i<financeList.size();i++){
			accounts.addItem(financeList.get(i).getName());
		}
	}
	
	public ArrayList<String> getTheAccount(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<MoneyNum;i++){
			list.add((String)AccountList.get(i).getSelectedItem());
		}
		return list;
	}
	
	protected ArrayList<String> getTheMoney(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < MoneyNum; i++){
			list.add(moneyList.get(i).getText());
		}
		return list;
	}
	
	
	public void flashPanel(){
		panel.updateUI();
	}
	
	
	class AddButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			service = new financeController(IP);
			financeList = service.checkVO();
			for(int i=0;i<financeList.size();i++){
				System.out.println(financeList.get(i).getName());
			}
			setAccountsBox(AccountString);
			//AccountString.addActionListener(new AccountBoxListener(MoneyNum));
			MoneyNum++;
			
			AccountString.setEnabled(true);
			MoneyString.setEnabled(true);
			
			setNext();
			
			panel.updateUI();
		}
		
	}
	
	class DeleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(MoneyNum > 0){
				removeLast();
				MoneyNum--;
				if(MoneyNum == 0){
					panel.remove(delete);
				}
				
				panel.updateUI();
			}
		}
		
	}
	
}
