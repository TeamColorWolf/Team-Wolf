package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.po.financePO;

public class financeVO implements Serializable{
	private String name;
    private double account;
	public int error;
	public boolean iserror;
    
    public financeVO(){
    	this.error=0;
    }
	public financeVO(boolean isError){
		this.error = 1;
	}
    
    
    public financeVO(String name){
        this.name = name;
        this.account =0d;
     	this.error=0;
     }
     
     public financeVO(String name , double account){
     	  this.name = name;
          this.account =account;
       	error=0;
     }
     
     public financeVO(financePO po){
    	 this.name = po.getName();
    	 this.account = po.getAccount();
    	 this.	error=0;
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
