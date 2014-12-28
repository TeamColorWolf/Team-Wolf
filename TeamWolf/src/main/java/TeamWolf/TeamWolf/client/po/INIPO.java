package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.INIVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class INIPO implements Serializable{
	private int number;
	private ArrayList<financeVO> accArray;
	private GoodsStockListVO gslArray;
	private ArrayList<CustomerVO> cusArray;
	public INIPO(int number,ArrayList<financeVO> accArray,GoodsStockListVO gslArray,
			ArrayList<CustomerVO> cusArray){
		this.setNumber(number);
		this.setAccArray(accArray);
		this.setGslArray(gslArray);
		this.setCusArray(cusArray);
	}
	public INIPO(INIVO vo){
		this.number = vo.getNumber();
		this.accArray = vo .getAccArray();
		this.gslArray = vo .getGslArray();
		this.cusArray = vo .getCusArray();
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
