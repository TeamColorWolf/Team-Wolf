package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */

public class GoodsBLAssistant {

	GoodsDataRead reader;
	
	public GoodsBLAssistant(){
		//实例化reader
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
		return true;
	}
	public int canDel(GoodsVO g){
		//判断商品能否从系统中删除
		return 0;
	}
	public boolean canUpd(GoodsVO g){
		//判断商品能否在系统中被修改
		return true;
	}
	public boolean canFin(GoodsVO g){
		//判断能否找到某商品
		return true;
	}	
	public int canSent(GoodsVO present){
		return 0;
	}
	public boolean isExisted(GoodsVO g){
    	return true;
    }
	public boolean beenTraded(GoodsVO g){
		return true;
	}
    
}
