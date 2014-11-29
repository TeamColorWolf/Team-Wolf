package TeamWolf.TeamWolf.client.vo;

import TeamWolf.TeamWolf.client.po.financePO;

public class financeVO {
	private String name;
    private double account;
	public int error;
	public boolean iserror;
    
    public financeVO(){
    	error=0;
    }
	public financeVO(boolean isError){
		error = 1;
	}
    
    
    public financeVO(String name){
        this.name = name;
        this.account =0d;
     	error=0;
     }
     
     public financeVO(String name , double account){
     	  this.name = name;
          this.account =account;
       	error=0;
     }
     
     public financeVO(financePO po){
    	 this.name = po.getName();
    	 this.account = po.getAccount();
    	 	error=0;
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
