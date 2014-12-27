package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

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
