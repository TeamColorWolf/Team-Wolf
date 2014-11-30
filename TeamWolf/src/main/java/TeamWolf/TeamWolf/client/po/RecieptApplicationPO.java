package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class RecieptApplicationPO extends ApplicationPO{
	    private String note;
	    private String addup;
	    private CustomerPO customer;
	    private ArrayList<financeVO> accountList;
	    private ArrayList<String> moneyList;
	    
		public RecieptApplicationPO(ArrayList<financeVO> accountList,ArrayList<String> moneyList,
	        		String number,String operator,String note,CustomerPO customer) {
				this.note = note;
				this.customer = customer;
				
				this.setAccountList(accountList);
				this.moneyList = moneyList;
				
				this.number = number;
				this.operator = operator;
				
				this.setAddup(calcuAdd(moneyList));
				
			}
		public RecieptApplicationPO(RecieptApplicationVO vo) {
			this.note = vo.getNote();
			this.addup = vo.getAddup();
			this.customer = new CustomerPO(vo.getCustomer());
			this.moneyList = vo.getMoneyList();
			this.accountList =vo.getAccountList();
			
		}
		public String calcuAdd(ArrayList<String> moneyList){
			double AllAdd=0d;
			for(String S: moneyList){
				AllAdd += Double.parseDouble(S);
						}
			return String.valueOf(AllAdd);			
		}
		
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public ArrayList<String> getMoneyList() {
			return moneyList;
		}
		public void setMoneyList(ArrayList<String> moneyList) {
			this.moneyList = moneyList;
		}
		public String getAddup() {
			return addup;
		}
		public void setAddup(String addup) {
			this.addup = addup;
		}
		public CustomerPO getCustomer() {
			return customer;
		}
		public void setCustomer(CustomerPO customer) {
			this.customer = customer;
		}
		public ArrayList<financeVO> getAccountList() {
			return accountList;
		}
		public void setAccountList(ArrayList<financeVO> accountList) {
			this.accountList = accountList;
		}	
}
