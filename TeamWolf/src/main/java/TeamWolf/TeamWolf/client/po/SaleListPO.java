package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;

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

	
	public SaleListPO(SaleListVO svo) {
		this.number = svo.number;
		this.customer = new CustomerPO(svo.getCustomer());
		this.salesman = svo.getSalesman();
		this.operator = svo.operator;
		this.storage = svo.getStorage();
		this.total = svo.getTotal();
		this.totalAfterDiscount = svo.getTotalAfterDiscount();
		this.remark = svo.getRemark();
		this.discount = svo.getDiscount();
		this.coupon = svo.getCoupon();
		toGoodsPO(svo.getGoodsList());
	}
	
	private void toGoodsPO(ArrayList<GoodsVO> gvo) {
		GoodsList = new ArrayList<GoodsPO>();
		for (int i = 0; i < gvo.size(); i++) {
			GoodsPO gpo = new GoodsPO(gvo.get(i));
			GoodsList.add(gpo);
		}
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
