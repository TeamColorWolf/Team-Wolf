package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class PresentListVO extends ApplicationVO{
    
	
	public CustomerVO customer;
	public String operator;
	
	private ArrayList<GoodsVO> pl=new ArrayList<GoodsVO>();
	private String presentListInfo;
	
	public void setCustomer(CustomerVO customer){
		this.customer=customer;
	}
	public void setOperator(String operator){
		this.operator=operator;
	}
	public void addPresent(GoodsVO p){
		pl.add(p);
	}
	public ArrayList<GoodsVO> getPList(){
		return pl;
	}
	public String getPresentListInfo(){
		return presentListInfo;
	}
}
