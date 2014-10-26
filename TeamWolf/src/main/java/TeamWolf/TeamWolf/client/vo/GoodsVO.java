package TeamWolf.TeamWolf.client.vo;

public class GoodsVO {

	private TypeVO parent;
	private String number;
	private String name;
	private String model;
	private int amount;
	private double imprice;
	private double exprice;
	private double latestImprice;
	private double latestExprice;
	
	private int packSuccess;
	
	GoodsVO(){
		
	}
	
	
	public TypeVO getParent() {
		return parent;
	}
	public void setParent(TypeVO parent) {
		this.parent = parent;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getImprice() {
		return imprice;
	}
	public void setImprice(double imprice) {
		this.imprice = imprice;
	}
	public double getExprice() {
		return exprice;
	}
	public void setExprice(double exprice) {
		this.exprice = exprice;
	}
	public double getLatestImprice() {
		return latestImprice;
	}
	public void setLatestImprice(double latestImprice) {
		this.latestImprice = latestImprice;
	}
	public double getLatestExprice() {
		return latestExprice;
	}
	public void setLatestExprice(double latestExprice) {
		this.latestExprice = latestExprice;
	}
	
	public String getInfo(){
		return null;
	}
	
	public int isPackSuccess(){
		return packSuccess;
	}
}