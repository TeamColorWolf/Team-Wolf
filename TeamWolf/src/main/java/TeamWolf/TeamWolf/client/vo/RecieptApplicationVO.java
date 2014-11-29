package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class RecieptApplicationVO extends ApplicationVO{
	    private String note;
	    private String addup;
	    private CustomerVO customer;
	    private ArrayList<financeVO> accountList;
	    private ArrayList<String> moneyList;
	    
		public RecieptApplicationVO(ArrayList<financeVO> accountList,ArrayList<String> moneyList,
	        		String number,String operator,String note,CustomerVO customer) {
				this.note = note;
				this.customer = customer;
				
				this.accountList = accountList;
				this.moneyList = moneyList;
				
				this.number = number;
				this.operator = operator;
				
				this.setAddup(calcuAdd(moneyList));
				
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
		public ArrayList<financeVO> getAccountList() {
			return accountList;
		}
		public void setAccountList(ArrayList<financeVO> accountList) {
			this.accountList = accountList;
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
		public CustomerVO getCustomer() {
			return customer;
		}
		public void setCustomer(CustomerVO customer) {
			this.customer = customer;
		}	
}


