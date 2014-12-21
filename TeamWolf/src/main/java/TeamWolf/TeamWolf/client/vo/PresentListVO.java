package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PresentListPO;
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
	
	public PresentListVO(){
		
	}
	
	public PresentListVO(PresentListPO po){
		
		customer=new CustomerVO(null, null, null, po.getCustomer(),	 null, null, null, null, null, null, null, null);
		operator=po.getOperator();
		this.number=po.number;
		this.condition=po.condition;
		ArrayList<String> pInfo=po.getPlInfo();
		for(String s: pInfo){
			String[] pI=s.split(" ");
			GoodsVO present=new GoodsVO(null, null, pI[0], pI[1], null, pI[2], pI[3], null, null, null, null);
			pl.add(present);
		}
	}
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
