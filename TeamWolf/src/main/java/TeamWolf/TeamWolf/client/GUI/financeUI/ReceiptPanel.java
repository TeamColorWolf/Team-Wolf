package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class ReceiptPanel extends JPanel{

	public static int ApplicationNumber ;
	private final static int LW = 150;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int BH = 30;
	public static final int width = 960;
	public static final int height = 540;
	public static AccountBlservice service = null;
	public static CustomerOprBLservice cusservice =null;
	public OneRecieptPanel orp;
	
	FinanceApplicationService faservice = ApplicationPanel.faservice;
	
	JComboBox<String> CustomerBox = new JComboBox<String>();
	JLabel CustomerLabel = new JLabel("客户");
	JLabel NoteLabel = new JLabel("备注");
	JLabel AddLabel = new JLabel("总额");
	JTextField NoteText = new JTextField();
	JTextField AddText = new JTextField();
	
	JButton ensure = new JButton("确认");
	JButton cancel = new JButton("取消");
	
	ArrayList<String> CustomerList;
	ArrayList<CustomerVO> CustomerVOList;
	ArrayList<String> CustomerTopList;
	ArrayList<RecieptApplicationVO> RecieptList;
	
	public ReceiptPanel(String IP){
		service = new financeController(IP);
		cusservice = new CustomerOpr(IP);
		RecieptList= faservice.getRecieptVO();
		
		if(RecieptList==null){
			RecieptList =new ArrayList<RecieptApplicationVO>();
		}
		
		ApplicationNumber =RecieptList.size();
		
		CustomerVOList = cusservice.getAllCustomerList();
		if(CustomerVOList == null){
			CustomerVOList = new ArrayList<CustomerVO>();
		}
		if(CustomerList == null){
			CustomerList = new ArrayList<String>();
		}
		if(CustomerTopList == null){
			CustomerTopList = new ArrayList<String>();
		}
		getCustomerList();
		getCustomerTopList();
		
		orp = new OneRecieptPanel();
		
		setCustomerBox(CustomerList);
		
		CustomerBox.setSize(LW,LH);
		CustomerBox.setLocation(120, 20);
		CustomerBox.setVisible(true);
		
		AddText.setSize(LW, LH);
		AddText.setLocation(120, 400);
		AddText.setVisible(true);
		AddText.setEditable(false);
		
		NoteLabel.setSize(BW,LH);
		NoteLabel.setLocation(380,20);
		NoteLabel.setVisible(true);
		
		CustomerLabel.setSize(BW,LH);
		CustomerLabel.setLocation(45, 20);
		CustomerLabel.setVisible(true);
		
		AddLabel.setSize(BW,BH);
		AddLabel.setLocation(45,400);
		AddLabel.setVisible(true);
		
		NoteText.setSize(LW*3,LH);
		NoteText.setLocation(380+50,20);
		NoteText.setVisible(true);
		
		ensure.setSize(BW, BH);
		ensure.setLocation(680, 400);
		ensure.addActionListener(new EnsureListener());
		
		cancel.setSize(BW, BH);
		cancel.setLocation(820, 400);
		cancel.addActionListener(new CancelListener());
		
		this.add(orp);
		this.add(ensure);
		this.add(cancel);
		this.add(AddText);
		this.add(CustomerBox);
		this.add(AddLabel);
		this.add(CustomerLabel);
		this.add(NoteLabel);
		this.add(NoteText);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void getCustomerList(){
		for(int i=0;i<CustomerVOList.size();i++){
			CustomerList.add(CustomerVOList.get(i).getName());
		}
	}
	public void getCustomerTopList(){
		for(int i=0;i<CustomerVOList.size();i++){
			CustomerTopList.add(""+CustomerVOList.get(i).getTopLimit());
		}
	}
	public void setCustomerBox(ArrayList<String> CustomerList){
		for(int i=0;i<CustomerList.size();i++){
			CustomerBox.addItem(CustomerList.get(i));
		}
	}
	
	public String getDate (){
		String date = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		date = sdf.format(dt);
		return date;
	}
	
	public String getNumber(){
		String num = "SKD-";
		String date = getDate();
		String number = String.format("%05d", ApplicationNumber);
		num = num + date + "-" + number;
		return num;
		
	}
	
	public void getAllApplication(){
		
	}
	
	class CancelListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddText.setText("0.00");
			orp.removeAllAccounts();
			NoteText.setText("");
		}
		
	}
	
	class EnsureListener implements ActionListener{

 
		public void actionPerformed(ActionEvent arg0) {
		    ArrayList<String> accountNameList = orp.getTheAccount();
		    //System.out.println(accountNameList);
		    ArrayList<financeVO> accountList = new ArrayList<financeVO>();
		    ArrayList<String> moneyList = orp.getTheMoney();
		    accountList = this.getfinanceList(accountNameList);
		    String number = getNumber();
		    String operator = FinanceFrame.user.userName;
		    String note = NoteText.getText();
		    String customerName = CustomerBox.getItemAt(CustomerBox.getSelectedIndex());
		    CustomerVO customer = cusservice.findCustomer(customerName); 
				
			RecieptApplicationVO submitRav = new RecieptApplicationVO(accountList, moneyList,number, operator, note, customer);
			
			
			/*System.out.println(accountList);
			System.out.println(moneyList);*/

			System.out.println(number);/*
			System.out.println(operator);
			System.out.println(note);
			System.out.println(customerName);
			System.out.println(submitRav);
			System.out.println(faservice);
			System.out.println(submitRav.getAddup());*/
            faservice.submitRecieptApplication(submitRav);
		}
	    
	    public ArrayList<financeVO> getfinanceList(ArrayList<String> accountNameList){
	    	ArrayList<financeVO> accountList = new ArrayList<financeVO>();
	        for(int index=0 ; index<accountNameList.size();index++){
	        	accountList.add(service.find(new financeVO(accountNameList.get(index))));
	        }
	        return accountList;
	    }
		
	}
}
