package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.po.financePO;
//收款单
public class RecieptApplicationVO extends ApplicationVO{
	    private String note;//注释
	    private String addup;//合计
	    private CustomerVO customer;//客户
	    private ArrayList<financeVO> accountList;//账户list
	    private ArrayList<String> moneyList;//金额list
	    
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
		public RecieptApplicationVO(RecieptApplicationPO po) {
			this.note = po.getNote();
			this.customer =new CustomerVO(po.getCustomer());
			this.accountList = new ArrayList<financeVO>();
			this.getAccountListVO(po);
			this.moneyList = po.getMoneyList();
			
			this.number = po.number;
			this.operator = po.operator;
			this.condition = po.condition;
			
			this.setAddup(calcuAdd(moneyList));
		}
		public void getAccountListVO(RecieptApplicationPO po){
			for(int i=0;i<po.getAccountList().size();i++){
				this.accountList.add(new financeVO(po.getAccountList().get(i)));
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


