package TeamWolf.TeamWolf.client.vo;

public class PaymentApplicationVO extends ApplicationVO{
    private String number;

    public PaymentApplicationVO(String number){
    	this.number = number;
    }
    
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
