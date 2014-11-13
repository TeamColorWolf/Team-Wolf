package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportListVO extends ApplicationVO{
	
	
	/**
	 * 供应商
	 */
	String supplier;
	
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

	public ImportListVO(String number, String supplier, String storage, String operator,
			ArrayList<GoodsVO> goodsList, String remark) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.supplier = supplier;
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
	private double calTotal(ArrayList<GoodsVO> goodsList){
		//TODO 计算总额的详细设计
		return 0;
	}
	
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
