package TeamWolf.TeamWolf.client.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class DecreaseToMatchVO extends ApplicationVO{

      GoodsVO toDecrease;
      String time;
	
      public DecreaseToMatchVO(GoodsVO toDecrease){
    	  this.toDecrease=toDecrease; 
    	  this.time=this.getPresentTime();
      }
      
      public String getInfo(){
    	  return time+" "+toDecrease.getNumber()+" "+toDecrease.getName()+" "+toDecrease.getModel()+" 报损数量"+toDecrease.getAmount();
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
      
      private String getPresentTime(){
  		//获得当前时间
  		Calendar c=Calendar.getInstance();
  		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		//SimpleDateFormat s=new SimpleDateFormat("MM-dd HH:mm:ss");
  		String time=s.format(c.getTime());
  		return time;
  	}
	
}
