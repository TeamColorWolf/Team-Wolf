package TeamWolf.TeamWolf.client.vo;

import TeamWolf.TeamWolf.client.po.financePO;

public class financeVO {
	private String name;
    private double account;
    
    public financeVO(){
    	
    }
    
    public financeVO(String name){
        this.name = name;
        this.account =0d;
     }
     
     public financeVO(String name , double account){
     	  this.name = name;
          this.account =account;
     }
     
     public financeVO(financePO po){
    	 this.name = po.getName();
    	 this.account = po.getAccount();
     }
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}

}
