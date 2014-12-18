package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.financePO;

public class CashApplicationVO extends ApplicationVO{
    private String note;
    private String addup;
    private ArrayList<String> nameList;
    private ArrayList<financeVO> accountList;
    private ArrayList<String> moneyList; 
    
	public CashApplicationVO(ArrayList<financeVO> accountList,ArrayList<String> moneyList,ArrayList<String> nameList,
        		String number,String operator,String note) {
			this.note = note;
			
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
	public CashApplicationVO(CashApplicationPO po) {
		this.note = po.getNote();
		//this.customer =new CustomerVO(po.getCustomer());
		
		this.accountList = new ArrayList<financeVO>();
		this.getAccountListVO(po);
		this.nameList = po.getNameList();
		this.moneyList = po.getMoneyList();
		
		this.number = po.number;
		this.operator = po.operator;
		this.condition = po.condition;
		
		this.setAddup(calcuAdd(moneyList));
	}
	public void getAccountListVO(CashApplicationPO po){
		for(financePO f: po.getAccountList()){
			this.accountList.add(new financeVO(f));
		}
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
//	public CustomerVO getCustomer() {
//		return customer;
//	}
//	public void setCustomer(CustomerVO customer) {
//		this.customer = customer;
//	}
	public ArrayList<String> getNameList() {
		return nameList;
	}
	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}
}