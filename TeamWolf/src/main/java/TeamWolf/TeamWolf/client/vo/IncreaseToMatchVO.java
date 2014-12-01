package TeamWolf.TeamWolf.client.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IncreaseToMatchVO extends ApplicationVO {

	 GoodsVO toIncrease;
	 String time;
		
     public IncreaseToMatchVO(GoodsVO toIncrease){
   	      this.toIncrease=toIncrease; 
   	      this.time=this.getPresentTime();
     }
     
     public String getInfo(){
   	  return time+" "+toIncrease.getNumber()+" "+toIncrease.getName()+" "+toIncrease.getModel()+" 报溢数量"+toIncrease.getAmount();
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
     
     private String getPresentTime(){
 		//获得当前时间
 		Calendar c=Calendar.getInstance();
 		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		//SimpleDateFormat s=new SimpleDateFormat("MM-dd HH:mm:ss");
 		String time=s.format(c.getTime());
 		return time;
 	}
     
}
