package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 销售单
 * @author HalaWKS
 *
 */
public class SaleListPO extends ApplicationPO{
	
	/**
	 * 客户
	 */
	CustomerPO customer;
	
	/**
	 * 业务员
	 */
	String salesman;
	
	/**
	 * 操作员
	 */
	String operator;
	
	/**
	 * 仓库
	 */
	String storage;
	
	/**
	 * 出货商品清单
	 */
	ArrayList<GoodsPO> GoodsList; 
	
	/**
	 * 折让前总额
	 */
	double total;
	
	/**
	 * 折让
	 */
	double discount;
	
	/**
	 * 使用代金券金额
	 */
	double coupon;
	
	/**
	 * 折让后总额
	 */
	double totalAfterDiscount;
	
	/**
	 * 单据备注
	 */
	String remark;

	
	public SaleListPO(String number, CustomerPO customer, String salesman, String operator,
			String storage, ArrayList<GoodsPO> goodsList, String discount, String coupon, String remark) {
		this.number = number;
		this.customer = customer;
		this.salesman = salesman;
		this.operator = operator;
		this.storage = storage;
		this.GoodsList = goodsList;
		this.total = calTotal(goodsList);
		this.totalAfterDiscount = calTotalAfterDiscount(total);
		this.remark = remark;
		
		try {
			this.discount = Double.parseDouble(discount);
			this.coupon = Double.parseDouble(coupon);
		} catch (Exception e) {
			// TODO: 数据类型转换异常
		}
	}
	
	
	
	/**
	 * 计算折让前总额
	 * @param goodsList
	 * @return
	 */
	private double calTotal(ArrayList<GoodsPO> goodsList){
		//TODO: 计算折让前总额的方法
		return 0;
	}
	
	/**
	 * 计算折让后总额
	 * @param total
	 * @return
	 */
	private double calTotalAfterDiscount(double total){
		//TODO 计算折让后总额的方法
		return 0;
	}

	public CustomerPO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	
	
	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}



	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public ArrayList<GoodsPO> getGoodsList() {
		return GoodsList;
	}

	public void setGoodsList(ArrayList<GoodsPO> goodsList) {
		GoodsList = goodsList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getCoupon() {
		return coupon;
	}

	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}

	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}

	public void setTotalAfterDiscount(double totalAfterDiscount) {
		this.totalAfterDiscount = totalAfterDiscount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
