package TeamWolf.TeamWolf.client.vo;

public class SaleDetialVO {
	public String number;
	public String customer;
	public String operator;
	public String storage;
	public String goodsName;
	public int goodsAmo;
	public double price;
	
	public SaleDetialVO(String number, String customer, String operator, String storage, String goodsName, int goodsAmo, double price){
		this.number = number;
		this.customer = customer;
		this.operator = operator;
		this.storage = storage;
		this.goodsName = goodsName;
		this.goodsAmo = goodsAmo;
		this.price = price;
	}
}
