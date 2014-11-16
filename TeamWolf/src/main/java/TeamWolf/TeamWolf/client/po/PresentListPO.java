package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class PresentListPO extends ApplicationPO implements Serializable{
	
	ArrayList<String> plInfo;
	String operator;
	String customer;
	
	public PresentListPO(ArrayList<GoodsVO> pl, String operator, String customer){
		
	}

	public ArrayList<String> getPlInfo() {
		return plInfo;
	}

	public void setPlInfo(ArrayList<String> plInfo) {
		this.plInfo = plInfo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
   
	
}
