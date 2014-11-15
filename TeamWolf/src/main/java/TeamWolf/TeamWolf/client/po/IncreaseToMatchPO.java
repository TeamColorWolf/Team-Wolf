package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class IncreaseToMatchPO extends ApplicationPO implements Serializable {

	 GoodsPO toIncrease;
		
     public IncreaseToMatchPO(GoodsPO toIncrease){
   	  this.toIncrease=toIncrease; 
     }
     
     public String getInfo(){
   	  return toIncrease.getNumber()+" "+toIncrease.getName()+" "+toIncrease.getModel()+" "+toIncrease.getAmount();
     }
     
     public String getNumber(){
   	  return toIncrease.getNumber();
     }
     
     public String getName(){
   	  return toIncrease.getName();
     }
     
     public String getModel(){
   	  return toIncrease.getModel();
     }
     
     public String getAmount(){
   	  return ""+toIncrease.getAmount();
     }
}
