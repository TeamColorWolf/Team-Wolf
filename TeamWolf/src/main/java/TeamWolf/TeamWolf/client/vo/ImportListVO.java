package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportListVO extends ApplicationVO{
	
	
	/**
	 * 供应商
	 */
	CustomerVO customer;
	
	/**
	 * 仓库
	 */
	String storage;
	
	/**
	 * 入库商品列表
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

	public ImportListVO(String number, CustomerVO customer, String storage, String operator,
			ArrayList<GoodsVO> goodsList, String remark, String total) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.customer = customer;
		this.storage = storage;
		this.operator = operator;
		this.GoodsList = goodsList;
		this.remark = remark;
		this.total = Double.parseDouble(total);
	}
	
	public ImportListVO(ImportListPO ipo){
		this.condition = ipo.condition;
		this.number = ipo.number;
		this.customer = new CustomerVO(ipo.getCustomer());
		this.storage = ipo.getStorage();
		this.operator = ipo.operator;
		this.GoodsList = tranToGoodsListVO(ipo.getGoodsList());
		this.remark = ipo.getRemark();
		this.total = ipo.getTotal();
	}
	
	
	private ArrayList<GoodsVO> tranToGoodsListVO(ArrayList<GoodsPO> goodsListPO){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		for (int i = 0; i < goodsListPO.size(); i++) {
			GoodsVO gvo = new GoodsVO(goodsListPO.get(i));
			goodsList.add(gvo);
		}
		return goodsList;
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
