package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;


/**
 * 销售退货单
 * @author HalaWKS
 *
 */
public class SaleRejectListPO extends ApplicationPO{
	
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
	 * 退货商品清单
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

	
	public SaleRejectListPO(SaleRejectListVO srvo) {
		this.condition = srvo.condition;
		this.number = srvo.number;
		this.customer = new CustomerPO(srvo.getCustomer());
		this.salesman = srvo.getSalesman();
		this.operator = srvo.getOperator();
		this.storage = srvo.getStorage();
		this.total = srvo.getTotal();
		this.totalAfterDiscount = srvo.getTotalAfterDiscount();
		this.remark = srvo.getRemark();
		this.discount = srvo.getDiscount();
		this.coupon = srvo.getCoupon();
		toGoodsPO(srvo.getGoodsList());
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
