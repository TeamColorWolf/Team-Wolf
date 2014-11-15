package TeamWolf.TeamWolf.client.BL.customerBL;

public class CustomerBL implements CustomerBLservice{
	private String number;
	private String type;
	private String level;
	private String tel;
	private String address;
	private String postnumber;
	private String email;
	private double shouldpay;
	private double shouldcollect;
	private double couldcollect;
	private String defaultuser;

	public String getNumber() {
		// TODO 自动生成的方法存根
		return number;
	}

	public String getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	public String getLevel() {
		// TODO 自动生成的方法存根
		return level;
	}

	public String getTel() {
		// TODO 自动生成的方法存根
		return tel;
	}

	public String getAddress() {
		// TODO 自动生成的方法存根
		return address;
	}

	public String getPostnumber() {
		// TODO 自动生成的方法存根
		return postnumber;
	}

	public String getEmail() {
		// TODO 自动生成的方法存根
		return email;
	}

	public double getShouldpay() {
		// TODO 自动生成的方法存根
		return shouldpay;
	}

	public double getCouldCollect() {
		// TODO 自动生成的方法存根
		return couldcollect;
	}

	public double getShouldCollect() {
		// TODO 自动生成的方法存根
		return shouldcollect;
	}

	public String getDefaultUser() {
		// TODO 自动生成的方法存根
		return defaultuser;
	}

	public int setNumber(String number) {
		// TODO 自动生成的方法存根
		this.number = number;
		return 0;
	}

	public int setType(String type) {
		// TODO 自动生成的方法存根
		this.type = type;
		return 0;
	}

	public int setLevel(String level) {
		// TODO 自动生成的方法存根
		this.level = level;
		return 0;
	}

	public int setTel(String tel) {
		// TODO 自动生成的方法存根
		this.tel = tel;
		return 0;
	}

	public int setAddress(String address) {
		// TODO 自动生成的方法存根
		this.address = address;
		return 0;
	}

	public int setPostnumber(String postnumber) {
		// TODO 自动生成的方法存根
		this.postnumber = postnumber;
		return 0;
	}

	public int setEmail(String email) {
		// TODO 自动生成的方法存根
		this.email = email;
		return 0;
	}

	public int setShouldpay(double shouldpayUPANDDOWN) {
		// TODO 自动生成的方法存根
		this.shouldpay += shouldpayUPANDDOWN;
		return 0;
	}

	public int setCouldCollect(double couldcollect) {
		// TODO 自动生成的方法存根
		this.couldcollect = couldcollect;
		return 0;
	}

	public int setShouldCollect(double shouldcollectUPANDDOWN) {
		// TODO 自动生成的方法存根
		this.shouldcollect += shouldcollectUPANDDOWN;
		return 0;
	}

	public int setDefaultUser(String defaultUser) {
		// TODO 自动生成的方法存根
		this.defaultuser = defaultUser;
		return 0;
	}

}
