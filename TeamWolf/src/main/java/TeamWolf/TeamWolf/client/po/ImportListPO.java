package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 
 * @author WKS
 *
 */
public class ImportListPO extends ApplicationPO{
	
	/**
	 * 供应商
	 */
	CustomerPO customer;
	
	/**
	 * 仓库
	 */
	String storage;
	
	/**
	 * 入库商品列表
	 */
	ArrayList<GoodsPO> GoodsList;
	
	/**
	 * 单据备注
	 */
	String remark;
	
	/**
	 * 总额
	 */
	double total;

	
	public ImportListPO(String number, CustomerPO customer, String storage, String operator,
			ArrayList<GoodsPO> goodsList, String remark) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.customer = customer;
		this.storage = storage;
		this.operator = operator;
		this.GoodsList = goodsList;
		this.remark = remark;
		this.total = calTotal(goodsList);
	}
	
	/**
	 * 计算总额
	 * @param goodsList
	 * @return
	 */
	private double calTotal(ArrayList<GoodsPO> goodsList){
		//TODO 计算总额的详细设计
		return 0;
	}
	

	public CustomerPO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
