package TeamWolf.TeamWolf.client.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;



public class DecreaseToMatchVO extends ApplicationVO{

      GoodsVO toDecrease;
      String time;
	
      public DecreaseToMatchVO(GoodsVO toDecrease, String number){
    	  this.toDecrease=toDecrease; 
    	  this.time=this.getPresentTime();
    	  this.number="KCBSD-"+time+"-"+number;
      }
      
      public DecreaseToMatchVO(DecreaseToMatchPO po){
    	  
    	  String[] info=po.toDecreaseInfo;
          this.number=po.number;
          toDecrease=new GoodsVO(null, null, info[0], info[1], info[2], info[3], null, null, null, null, null);
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
  		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
  		//SimpleDateFormat s=new SimpleDateFormat("MM-dd HH:mm:ss");
  		String time=s.format(c.getTime());
  		return time;
  	}
	
}
