package TeamWolf.TeamWolf.client.vo;

public class RecieptApplicationVO extends ApplicationVO{
	private String number;
	public RecieptApplicationVO(String number){
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
