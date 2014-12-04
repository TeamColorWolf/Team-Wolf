package TeamWolf.TeamWolf.client.vo;

public class SaleDetialSelectFactVO {
	public String workID;
	public String customer;
	public String storage;
	public String goodsName;
	
	public SaleDetialSelectFactVO(String cus, String wor, String sto, String goo){
		workID = wor;
		customer = cus;
		storage = sto;
		goodsName = goo;
	}
}
