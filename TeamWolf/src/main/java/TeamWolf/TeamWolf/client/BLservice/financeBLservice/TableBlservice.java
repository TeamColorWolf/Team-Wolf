package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

public interface TableBlservice {
	public int CreateReceipt(String customer,String account,double money,String log);
	public int CreatePayment(String customer,String account,double money,String log);
	public int CreateCash(String account,String name,double money,String log);
}
