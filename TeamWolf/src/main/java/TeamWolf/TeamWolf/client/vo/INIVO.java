package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.INIPO;
//期初建账
public class INIVO implements Serializable{
	private int number;//编号
	private ArrayList<financeVO> accArray;//账户信息
	private GoodsStockListVO gslArray;//商品信息
	private ArrayList<CustomerVO> cusArray;//客户信息
	public INIVO(int number,ArrayList<financeVO> accArray,GoodsStockListVO gslArray,
			ArrayList<CustomerVO> cusArray){
		this.setNumber(number);
		this.setAccArray(accArray);
		this.setGslArray(gslArray);
		this.setCusArray(cusArray);
	}
	public INIVO(INIPO po) {
		this.number = po.getNumber();
		this.accArray = po .getAccArray();
		this.gslArray = po .getGslArray();
		this.cusArray = po .getCusArray();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ArrayList<financeVO> getAccArray() {
		return accArray;
	}
	public void setAccArray(ArrayList<financeVO> accArray) {
		this.accArray = accArray;
	}
	public GoodsStockListVO getGslArray() {
		return gslArray;
	}
	public void setGslArray(GoodsStockListVO gslArray) {
		this.gslArray = gslArray;
	}
	public ArrayList<CustomerVO> getCusArray() {
		return cusArray;
	}
	public void setCusArray(ArrayList<CustomerVO> cusArray) {
		this.cusArray = cusArray;
	}
}
