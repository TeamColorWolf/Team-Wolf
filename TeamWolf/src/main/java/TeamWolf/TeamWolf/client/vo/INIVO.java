package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.INIPO;

public class INIVO {
	private int number;
	private ArrayList<financeVO> accArray;
	private GoodsStockListVO gslArray;
	private ArrayList<CustomerVO> cusArray;
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
