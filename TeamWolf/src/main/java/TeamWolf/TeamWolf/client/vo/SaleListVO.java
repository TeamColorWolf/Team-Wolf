package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;

/**
 * 
 * @author HalaWKS
 *
 */
public class SaleListVO extends ApplicationVO{
	
	/**
	 * 客户
	 */
	CustomerVO customer;
	
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
	ArrayList<GoodsVO> GoodsList; 
	
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

	public SaleListVO(String number, CustomerVO customer, String salesman, String operator,
			String storage, ArrayList<GoodsVO> goodsList, String discount, String coupon,
			String remark, String total, String totalAfterDiscount) {
		this.number = number;
		this.customer = customer;
		this.salesman = salesman;
		this.operator = operator;
		this.storage = storage;
		this.GoodsList = goodsList;
		this.remark = remark;
		
		try {
			this.total = Double.parseDouble(total);
			this.discount = Double.parseDouble(discount);
			this.coupon = Double.parseDouble(coupon);
			this.totalAfterDiscount = Double.parseDouble(totalAfterDiscount);
		} catch (Exception e) {
			// TODO: 数据类型转换异常
		}
		
	}
	
	public SaleListVO(SaleListPO spo) {
		this.number = spo.number;
		this.customer = new CustomerVO(spo.getCustomer());
		this.salesman = spo.getSalesman();
		this.operator = spo.getOperator();
		this.storage = spo.getStorage();
		this.total = spo.getTotal();
		this.totalAfterDiscount = spo.getTotalAfterDiscount();
		this.remark = spo.getRemark();
		this.discount = spo.getDiscount();
		this.coupon = spo.getCoupon();
		toGoodsVO(spo.getGoodsList());
	}
	
	private void toGoodsVO(ArrayList<GoodsPO> gpo) {
		GoodsList = new ArrayList<GoodsVO>();
		for (int i = 0; i < gpo.size(); i++) {
			GoodsVO gvo = new GoodsVO(gpo.get(i));
			GoodsList.add(gvo);
		}
	}
	
	
	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
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

	public ArrayList<GoodsVO> getGoodsList() {
		return GoodsList;
	}

	public void setGoodsList(ArrayList<GoodsVO> goodsList) {
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
