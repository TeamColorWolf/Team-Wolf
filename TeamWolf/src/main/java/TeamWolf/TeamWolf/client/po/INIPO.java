package TeamWolf.TeamWolf.client.po;

public class INIPO {
	private String commodityType;
	private String commodity;
	private String Type;	
	private String number;
	private String customerType;
	private String customer;	
	private String customerConnect;
	public INIPO(String commodityType, String commodity, String Type,
			String number, String customerType, String customer,
			String customerConnect){
		this.commodityType = commodityType;
		this.commodity = commodity;
		this.Type = Type;
		this.number = number;
		this.customerType = customerType;
		this.customer = customer;
		this.customerConnect = customerConnect;
	}
	
	public String getCommodityType() {
		return commodityType;
	}
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerConnect() {
		return customerConnect;
	}
	public void setCustomerConnect(String customerConnect) {
		this.customerConnect = customerConnect;
	}
}
