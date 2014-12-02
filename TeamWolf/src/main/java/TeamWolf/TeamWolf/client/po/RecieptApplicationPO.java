package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class RecieptApplicationPO extends ApplicationPO implements Serializable{
	    private String note;
	    private String addup;
	    private CustomerPO customer;
	    private ArrayList<financePO> accountList;
	    private ArrayList<String> moneyList;
	    
		public RecieptApplicationPO(ArrayList<financePO> accountList,ArrayList<String> moneyList,
	        		String number,String operator,String note,CustomerPO customer) {
				this.note = note;
				this.customer = customer;
				
				this.accountList = new ArrayList<financePO>();
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
			this.accountList = new ArrayList<financePO>();
			this.setAccountListPO(vo.getAccountList());
			this.operator =vo.operator;
			this.number = vo.number;
		}
		private void setAccountListPO(ArrayList<financeVO> accountList2) {
			for(int i=0;i<accountList2.size();i++){
				financePO fp = new financePO(accountList2.get(i));
				this.accountList.add(new financePO(accountList2.get(i)));
			}
			
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
		public ArrayList<financePO> getAccountList() {
			return accountList;
		}
		public void setAccountList(ArrayList<financePO> accountList) {
			this.accountList = accountList;
		}
}
