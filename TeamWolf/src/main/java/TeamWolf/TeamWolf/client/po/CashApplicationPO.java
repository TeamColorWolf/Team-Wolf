package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

public class CashApplicationPO extends ApplicationPO{
    private String note;
    private String addup;
    private CustomerPO customer;
    private ArrayList<String> nameList;
    private ArrayList<financePO> accountList;
    private ArrayList<String> moneyList;
    
	public CashApplicationPO(ArrayList<financePO> accountList,ArrayList<String> moneyList,ArrayList<String> nameList,
        		String number,String operator,String note,CustomerPO customer) {
			this.note = note;
			this.customer = customer;
			
			this.setNameList(nameList);
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
	public ArrayList<financePO> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<financePO> accountList) {
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
	public CustomerPO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
	}
	public ArrayList<String> getNameList() {
		return nameList;
	}
	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}
}
