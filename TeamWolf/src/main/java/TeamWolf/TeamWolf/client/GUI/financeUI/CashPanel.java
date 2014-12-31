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

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
//现金费用单界面
public class CashPanel extends JPanel{

	public static int ApplicationNumber;
	private final static int LW = 150;
	private final static int LH = 25;
	private final static int BW = 80;
	private final static int BH = 30;
	public static final int width = 960;
	public static final int height = 540;
	public static AccountBlservice service = null;
	public static CustomerOprBLservice cusservice =null;
	public OneCashPanel ocp;
	
	JComboBox<String> CustomerBox = new JComboBox<String>();
	JLabel CustomerLabel = new JLabel("客户");
	JLabel NoteLabel = new JLabel("备注");
	JLabel AddLabel = new JLabel("总额");
	JTextField NoteText = new JTextField();
	JTextField AddText = new JTextField();
	
	FinanceApplicationService faservice = ApplicationPanel.faservice;
	
	JButton ensure = new JButton("确认");
	JButton cancel = new JButton("取消");
	
	ArrayList<String> CustomerList;
	ArrayList<CustomerVO> CustomerVOList;
	ArrayList<String> CustomerTopList;
	ArrayList<CashApplicationVO> aca;
	
	public CashPanel(String IP){
		service = new financeController(IP);
		cusservice = new CustomerOpr(IP);
		
		aca = faservice.getCashVO();
		
		ApplicationNumber = aca.size(); 
		
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
		
		ocp = new OneCashPanel(IP);
		
		setCustomerBox(CustomerList);
		
		CustomerBox.setSize(LW,LH);
		CustomerBox.setLocation(120, 20);
		CustomerBox.setVisible(false);
		
		AddText.setSize(LW, LH);
		AddText.setLocation(120, 400);
		AddText.setVisible(true);
		AddText.setEditable(false);
		
		NoteLabel.setSize(BW,LH);
		NoteLabel.setLocation(45,20);
		NoteLabel.setVisible(true);
		
		CustomerLabel.setSize(BW,LH);
		CustomerLabel.setLocation(45, 20);
		CustomerLabel.setVisible(false);
		
		AddLabel.setSize(BW,BH);
		AddLabel.setLocation(45,400);
		AddLabel.setVisible(true);
		
		NoteText.setSize(LW*3,LH);
		NoteText.setLocation(120,20);
		NoteText.setVisible(true);
		
		ensure.setSize(BW, BH);
		ensure.setLocation(680, 400);
		ensure.addActionListener(new EnsureListener());
		
		cancel.setSize(BW, BH);
		cancel.setLocation(820, 400);
		cancel.addActionListener(new CancelListener());
		
		this.add(ocp);
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
	//获取
	public void getCustomerList(){//获取客户信息
		for(int i=0;i<CustomerVOList.size();i++){
			CustomerList.add(CustomerVOList.get(i).getName());
		}
	}
	public void getCustomerTopList(){
		for(int i=0;i<CustomerVOList.size();i++){
			CustomerTopList.add(""+CustomerVOList.get(i).getTopLimit());
		}
	}
	public void setCustomerBox(ArrayList<String> CustomerList){//设置客户信息
		for(int i=0;i<CustomerList.size();i++){
			CustomerBox.addItem(CustomerList.get(i));
		}
	}
	//获取日期
	public String getDate (){
		String date = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		date = sdf.format(dt);
		return date;
	}
	//获取编号
	public String getNumber(){
		String num = "XJFYD-";
		String date = getDate();
		String number = String.format("%05d", ApplicationNumber++);
		num = num + date + "-" + number;
		return num;
		
	}
	//“取消”监听
	class CancelListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddText.setText("0.00");
			ocp.removeAllAccounts();
		}
		
	}
	//提交“监听”
	class EnsureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		    ArrayList<String> accountNameList = ocp.getTheAccount();
		    System.out.println(accountNameList);
		    ArrayList<financeVO> accountList = new ArrayList<financeVO>();
		    ArrayList<String> moneyList = ocp.getTheMoney();
		    ArrayList<String> noteList = ocp.getTheName();
		    accountList = this.getfinanceList(accountNameList);
		    String number = getNumber();
		    String operator = FinanceFrame.user.workID;
		    String note = NoteText.getText();
				
		    if(moneyList.size()==0){
				MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
	    		return;
			}
		    for(int i=0;i<moneyList.size();i++){
		    	if((!moneyList.get(i).contains("0"))&&(!moneyList.get(i).contains("1"))
		    	&&(!moneyList.get(i).contains("2"))&&(!moneyList.get(i).contains("3"))
		        &&(!moneyList.get(i).contains("4"))&&(!moneyList.get(i).contains("5"))
		    	&&(!moneyList.get(i).contains("6"))&&(!moneyList.get(i).contains("7"))
		    	&&(!moneyList.get(i).contains("8"))&&(!moneyList.get(i).contains("9"))){
		    		MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
		    		return;
		    	}
		    	if(moneyList.get(i).length()>6){
		    		MessageFrame mf = new MessageFrame(ErrorTW.InputNumberWrong);
		    		return;
		    	}
		    }			
		    CashApplicationVO submitCav = new CashApplicationVO(accountList, moneyList, noteList, number, operator, note);
			//付款单和现金费用单要查
		    double AddCheck = Double.parseDouble(submitCav.getAddup());
		    double AccountAdd = 0;
		    for(int i=0;i<accountList.size();i++){
		    	AccountAdd+=accountList.get(i).getAccount();
		    }
		    
		    if(AddCheck > AccountAdd){
		    	MessageFrame mf = new MessageFrame(ErrorTW.AccountLack);
		    	return;
		    }
			
		    System.out.println(number);
			/*System.out.println(accountList);
			System.out.println(moneyList);
			
			System.out.println(operator);
			System.out.println(note);
			System.out.println(customerName);
			System.out.println(submitRav);
			System.out.println(faservice);
			System.out.println(submitRav.getAddup());*/
			//AddText.setText(submitRav.getAddup());
            faservice.submitCashApplication(submitCav);
            MessageFrame mf = new MessageFrame(0);
		}
	    //获取账户列表
	    public ArrayList<financeVO> getfinanceList(ArrayList<String> accountNameList){
	    	ArrayList<financeVO> accountList = new ArrayList<financeVO>();
	        for(int index=0 ; index<accountNameList.size();index++){
	        	accountList.add(service.find(new financeVO(accountNameList.get(index))));
	        }
	        return accountList;
	    }
		
	}
}