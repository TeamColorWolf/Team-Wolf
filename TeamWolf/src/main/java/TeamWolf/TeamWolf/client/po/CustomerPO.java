package TeamWolf.TeamWolf.client.po;

public class CustomerPO {
	
	/**
	 * 编号
	 */
	private int num;
	
	/**
	 * 客户种类（进货商、销售商）
	 */
	private String kind;
	
	/**
	 * 客户等级
	 */
	private int level;
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 客户电话
	 */
	private String tel;
	
	/**
	 * 客户地址
	 */
	private String address;
	
	/**
	 * 客户邮编
	 */
	private String zipCode;
	
	/**
	 * 客户邮箱
	 */
	private String email;
	
	/**
	 * 应收额度
	 */
	private double topLimit;
	
	/**
	 * 应收
	 */
	private double receive;
	
	/**
	 * 应付
	 */
	private double pay;
	
	/**
	 * 默认业务员
	 */
	private String businessMan;
	
	/**
	 * 
	 * @param num 编号
	 * @param kind 客户种类（进货商、销售商）
	 * @param level 等级
	 * @param name 姓名
	 * @param tel 电话
	 * @param address 地址
	 * @param zipCode 邮编
	 * @param email 电子邮箱
	 * @param topLimit 应收额度
	 * @param receive 应收
	 * @param pay 应付
	 * @param businessMan 默认业务员
	 */
	public CustomerPO(int num, String kind, int level, String name, String tel, 
			String address, String zipCode, String email, int topLimit,
			double receive, double pay, String businessMan) {
		this.num = num;
		this.kind = kind;
		this.level = level;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.zipCode = zipCode;
		this.email = email;
		this.topLimit = topLimit;
		this.receive = receive;
		this.pay = pay;
		this.businessMan = businessMan;
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

	public void setTopLimit(int topLimit) {
		this.topLimit = topLimit;
	}
	
}
