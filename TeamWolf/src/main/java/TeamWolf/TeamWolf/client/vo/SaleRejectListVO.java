package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;

/**
 * 
 * @author HalaWKS
 *
 */
public class SaleRejectListVO extends ApplicationVO{

	
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
	 * 退货商品清单
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
	
	public SaleRejectListVO(String number, String remark, SaleListVO svo) {
		this.number = number;
		this.operator = svo.operator;
		this.GoodsList = svo.getGoodsList();
		this.customer = svo.getCustomer();
		this.remark = remark;
		this.storage = svo.getStorage();
		this.total = svo.getTotal();
	}

	public SaleRejectListVO(String number, CustomerVO customer, String salesman, String operator,
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
			this.totalAfterDiscount = Double.parseDouble(totalAfterDiscount);
			this.discount = Double.parseDouble(discount);
			this.coupon = Double.parseDouble(coupon);
		} catch (Exception e) {
			// TODO: 数据类型转换异常
		}
	}

	public SaleRejectListVO(SaleRejectListPO srpo) {
		this.condition = srpo.condition;
		this.number = srpo.number;
		this.customer = new CustomerVO(srpo.getCustomer());
		this.salesman = srpo.getSalesman();
		this.operator = srpo.operator;
		this.storage = srpo.getStorage();
		this.total = srpo.getTotal();
		this.totalAfterDiscount = srpo.getTotalAfterDiscount();
		this.remark = srpo.getRemark();
		this.discount = srpo.getDiscount();
		this.coupon = srpo.getCoupon();
		toGoodsVO(srpo.getGoodsList());
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
