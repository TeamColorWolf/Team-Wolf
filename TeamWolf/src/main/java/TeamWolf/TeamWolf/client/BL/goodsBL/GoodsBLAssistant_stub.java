package TeamWolf.TeamWolf.client.BL.goodsBL;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class GoodsBLAssistant_stub {

GoodsDataRead reader;
	

	public GoodsBLAssistant_stub(String iP) {
		// TODO Auto-generated constructor stub
	}
	
	public String getPresentTime(){
		//获得当前时间
		Calendar c=Calendar.getInstance();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=s.format(c.getTime());
		return time;
	}
	
	public boolean canAdd(GoodsVO g){
		//判断商品能否被加入系统
		if(g.getName().equals("飞利浦日光灯"))
		   return true;
		else 
		   return false;
	}
	public int canDel(GoodsVO g){
		//判断商品能否从系统中删除
		if(g.getName().equals("飞利浦日光灯"))
		   return 0;
		else 
		   return 1;
	}
	public boolean canUpd(GoodsVO g){
		//判断商品能否在系统中被修改
		    if(g.getName().equals("飞利浦日光灯"))
			   return true;
			else 
			   return false;
	}
	public boolean canFin(GoodsVO g){
		//判断能否找到某商品
		if(g.getName().equals("飞利浦日光灯"))
			   return true;
	    else 
			   return false;
	}	
	public int canSent(GoodsVO present){
		return 0;
	}
	public boolean isExisted(GoodsVO g){
		if(g.getName().equals("飞利浦日光灯"))
			   return true;
		else 
			   return false;
    }
	public boolean beenTraded(GoodsVO g){
		return true;
	}
}
