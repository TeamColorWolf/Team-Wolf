package TeamWolf.TeamWolf.client.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;

public class IncreaseToMatchVO extends ApplicationVO {

	 GoodsVO toIncrease;
	 String time;
		
     public IncreaseToMatchVO(GoodsVO toIncrease, String number, String operator){
   	      this.toIncrease=toIncrease; 
   	      this.time=this.getPresentTime();
   	      this.number="KCBYD-"+time+"-"+number;
   	      this.operator=operator;
     }
     
     public IncreaseToMatchVO(IncreaseToMatchPO po){
    	 
    	 String[] info=po.toIncreaseInfo;
         this.number=po.number;
         toIncrease=new GoodsVO(null, null, info[0], info[1], info[2], info[3], info[4], null, null, null, null);
         this.operator=po.operator;
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
     
     public String getImprice(){
    	 return ""+toIncrease.getImprice();
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
