package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class DecreaseToMatchPO extends ApplicationPO implements Serializable{

	 GoodsPO toDecrease;
		
     public DecreaseToMatchPO(GoodsPO toDecrease){
   	  this.toDecrease=toDecrease; 
     }
     
     public String getInfo(){
   	  return toDecrease.getNumber()+" "+toDecrease.getName()+" "+toDecrease.getModel()+" "+toDecrease.getAmount();
     }
     
     public String getNumber(){
   	  return toDecrease.getNumber();
     }
     
     public String getName(){
   	  return toDecrease.getName();
     }
     
     public String getModel(){
   	  return toDecrease.getModel();
     }
     
     public String getAmount(){
   	  return ""+toDecrease.getAmount();
     }
}
