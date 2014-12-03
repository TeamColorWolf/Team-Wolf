package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;

/**
 * 
 * @author HalaWKS
 * 进货退货单
 *
 */
public class ImportRejectListPO extends ApplicationPO{
	
	/**
	 * 供应商
	 */
	CustomerPO customer;
	
	/**
	 * 仓库
	 */
	String storage;
	
	/**
	 * 出库商品列表
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

	public ImportRejectListPO(String number, String remark, ImportListPO ipo) {
		this.number = number;
		this.operator = ipo.operator;
		this.GoodsList = ipo.getGoodsList();
		this.customer = ipo.getCustomer();
		this.remark = remark;
		this.storage = ipo.getStorage();
		this.total = ipo.getTotal();
	}
	
	public ImportRejectListPO(ImportRejectListVO irvo) {
		// TODO Auto-generated constructor stub
		this.condition = irvo.condition;
		this.number = irvo.number;
		this.customer = new CustomerPO(irvo.getCustomer());
		this.storage = irvo.getStorage();
		this.operator = irvo.operator;
		this.remark = irvo.getRemark();
		this.total = irvo.getTotal();
		toGoodsPO(irvo.getGoodsList());
	}
	
	private void toGoodsPO(ArrayList<GoodsVO> gvo) {
		GoodsList = new ArrayList<GoodsPO>();
		for (int i = 0; i < gvo.size(); i++) {
			GoodsPO gpo = new GoodsPO(gvo.get(i));
			GoodsList.add(gpo);
		}
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
