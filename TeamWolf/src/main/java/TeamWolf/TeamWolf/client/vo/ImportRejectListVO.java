package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportRejectListVO extends ApplicationVO{
	
	
	/**
	 * 供应商
	 */
	CustomerVO customer;
	
	/**
	 * 仓库
	 */
	String storage;
	
	/**
	 * 出库商品列表
	 */
	ArrayList<GoodsVO> GoodsList;
	
	/**
	 * 单据备注
	 */
	String remark;
	
	/**
	 * 总额
	 */
	double total;

	public ImportRejectListVO(String number, String remark, ImportListVO ivo) {
		this.number = number;
		this.operator = ivo.operator;
		this.GoodsList = ivo.getGoodsList();
		this.customer = ivo.getCustomer();
		this.remark = remark;
		this.storage = ivo.getStorage();
		this.total = ivo.getTotal();
	}
	
	public ImportRejectListVO(String number, CustomerVO customer, String storage, String operator,
			ArrayList<GoodsVO> goodsList, String remark) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.customer = customer;
		this.storage = storage;
		this.operator = operator;
		this.GoodsList = goodsList;
		this.remark = remark;
		this.total = calTotal(goodsList);
	}
	
	public ImportRejectListVO(ImportRejectListPO irpo) {
		// TODO Auto-generated constructor stub
		this.condition = irpo.condition;
		this.number = irpo.number;
		this.customer = new CustomerVO(irpo.getCustomer());
		this.storage = irpo.getStorage();
		this.operator = irpo.operator;
		this.remark = irpo.getRemark();
		this.total = irpo.getTotal();
		toGoodsVO(irpo.getGoodsList());
	}
	
	private void toGoodsVO(ArrayList<GoodsPO> gpo) {
		GoodsList = new ArrayList<GoodsVO>();
		for (int i = 0; i < gpo.size(); i++) {
			GoodsVO gvo = new GoodsVO(gpo.get(i));
			GoodsList.add(gvo);
		}
	}
	
	/**
	 * 计算总额
	 * @param goodsList
	 * @return
	 */
	private double calTotal(ArrayList<GoodsVO> goodsList){
		//TODO 计算总额的详细设计
		return 0;
	}
	
	

	public CustomerVO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
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
