package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;

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
	ArrayList<GoodsPO> goodsList = new ArrayList<GoodsPO>();
	
	/**
	 * 单据备注
	 */
	String remark;
	
	/**
	 * 总额
	 */
	double total;

	
	public ImportListPO(ImportListVO ivo) {
		// TODO Auto-generated constructor stub
		this.number = ivo.number;
		this.customer = new CustomerPO(ivo.getCustomer());
		this.storage = ivo.getStorage();
		this.operator = ivo.operator;
		this.remark = ivo.getRemark();
		this.total = ivo.getTotal();
		toGoodsPO(ivo.getGoodsList());
	}
	
	private void toGoodsPO(ArrayList<GoodsVO> gvo) {
		for (int i = 0; i < gvo.size(); i++) {
			GoodsPO gpo = new GoodsPO(gvo.get(i));
			goodsList.add(gpo);
		}
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
		return goodsList;
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
