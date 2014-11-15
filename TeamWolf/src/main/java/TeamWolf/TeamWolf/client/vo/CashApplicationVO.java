package TeamWolf.TeamWolf.client.vo;

public class CashApplicationVO extends ApplicationVO{

    private String number;

    public CashApplicationVO(String number){
    	this.number = number;
    }
    
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
