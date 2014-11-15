package TeamWolf.TeamWolf.client.vo;

public class financeVO {
	private String name;
    private double account;
    
    public financeVO(){
    	
    }
    
    public financeVO(String name,double account){
    	this.name = name;
    	this.account = account;
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
