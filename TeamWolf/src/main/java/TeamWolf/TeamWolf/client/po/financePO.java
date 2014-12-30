package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.financeVO;
//账户
public class financePO implements Serializable{
	private String name;//账户名
    private double account;//余额
    
    public financePO(String name){
       this.name = name;
       this.account =0d;
    }
    
    public financePO(String name , double account){
    	  this.name = name;
          this.account =account;
    }
    
    public financePO(financeVO vo){
    	this.name = vo.getName();
    	this.account = vo.getAccount();
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
