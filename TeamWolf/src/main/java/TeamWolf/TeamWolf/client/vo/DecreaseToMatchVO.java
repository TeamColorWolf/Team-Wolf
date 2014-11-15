package TeamWolf.TeamWolf.client.vo;



public class DecreaseToMatchVO extends ApplicationVO{

      GoodsVO toDecrease;
	
      public DecreaseToMatchVO(GoodsVO toDecrease){
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
