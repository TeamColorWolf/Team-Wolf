package TeamWolf.TeamWolf.client.BL.stockBL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLAssistant_stub {

    StockDataService reader;
	
	StockBLAssistant_stub(String IP){
		//实例化reader
	}

	public String getPresentTime(){
		//获得当前时间
		Calendar c=Calendar.getInstance();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=s.format(c.getTime());
		return time;
	}
	public boolean canAdd(TypeVO t){
		//检查此商品分类是否能加入系统的逻辑判断
		if(t.getName().equals("照明灯类"))
		    return true;
		else
			return false;
	}
	public int canDel(TypeVO t){
		//检查是否能将此分类从系统中删除的逻辑判断
		if(t.getName().equals("照明灯类"))
		    return 0;
		else
			return 1;
	}
	public boolean canUpd(TypeVO t){
		//检查是否能修改系统中此商品分类的逻辑判断
		if(t.getName().equals("照明灯类"))
		    return true;
		else
			return false;
	}
	
	
	//逻辑判断中需要用到的私有方法
	private boolean isExisted(TypeVO t){
		return false;
	}
	private boolean haveChild(TypeVO t){
		return false;
	}
	
	/*public static void main(String[] args){
		StockBLAssistant s=new StockBLAssistant();
		System.out.println(s.getPresentTime());
	}*/
}
