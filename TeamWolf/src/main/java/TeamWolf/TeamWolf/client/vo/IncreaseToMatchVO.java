package TeamWolf.TeamWolf.client.vo;

public class IncreaseToMatchVO extends ApplicationVO {

	 GoodsVO toIncrease;
		
     public IncreaseToMatchVO(GoodsVO toIncrease){
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
