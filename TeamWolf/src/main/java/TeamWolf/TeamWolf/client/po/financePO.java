package TeamWolf.TeamWolf.client.po;

public class financePO {
	private String name;
    private double account;
    
    public financePO(String name){
       this.name = name;
       this.account =0d;
    }
    
    public financePO(String name , double account){
    	  this.name = name;
          this.account =account;
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
