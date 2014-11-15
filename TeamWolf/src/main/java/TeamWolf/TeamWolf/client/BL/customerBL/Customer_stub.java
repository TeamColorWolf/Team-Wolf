package TeamWolf.TeamWolf.client.BL.customerBL;
	
//stub of customer
//Actually I think is means nothing.......FTW
public class Customer_stub{
	
	private int num;
	private String kind;
	private int level;
	private String name;
	private String tel;
	private String address;
	private String zipCode;
	private String email;
	private double topLimit;
	private double receive;
	private double pay;
	private String businessMan;
	
	
	public Customer_stub(String num, String kind, String level, String name, String tel, 
			String address, String zipCode, String email, String topLimit,
			String receive, String pay, String businessMan) {		
		this.kind = kind;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.zipCode = zipCode;
		this.email = email;
		this.businessMan = businessMan;
		
		try {
			this.num = Integer.parseInt(num);
			this.level =Integer.parseInt(level);
			this.topLimit = Integer.parseInt(topLimit);
			this.receive = Double.parseDouble(receive);
			this.pay = Double.parseDouble(pay);
		} catch (Exception e) {
			// TODO: String转换成int/double时出错
		}
	}

	
	
	public int getNum() {
		return num;
	}

	public String getKind() {
		return kind;
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getEmail() {
		return email;
	}

	public double getTopLimit() {
		return topLimit;
	}
	
	public double getReceive() {
		return receive;
	}
	
	public double getPay() {
		return pay;
	}

	public String getBusinessMan() {
		return businessMan;
	}

	public void setTopLimit(double topLimit) {
		this.topLimit = topLimit;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setReceive(double receive) {
		this.receive = receive;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public void setBusinessMan(String businessMan) {
		this.businessMan = businessMan;
	}

	public void setTopLimit(int topLimit) {
		this.topLimit = topLimit;
	}
	
}