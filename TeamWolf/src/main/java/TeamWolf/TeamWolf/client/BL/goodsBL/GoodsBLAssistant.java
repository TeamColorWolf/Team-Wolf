package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 * 需要与持有交易单据的模块交互
 */

public class GoodsBLAssistant {

	GoodsDataService reader;
	
	public GoodsBLAssistant(String URL) {
		// TODO Auto-generated constructor stub
		try {
			reader=(GoodsDataService)Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPresentTime(){
		//获得当前时间
		Calendar c=Calendar.getInstance();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=s.format(c.getTime());
		return time;
	}
	
	public String getPresentDate(){
		
		//获得当前日期
		Calendar c=Calendar.getInstance();
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		String date=s.format(c.getTime());
		return date;
	}
	
	public boolean canAdd(GoodsVO g) throws RemoteException{
		//判断商品能否被加入系统
		if(isExisted(g)==false)
		   return true;
		else
		   return false;
	}
	public int canDel(GoodsVO g) throws RemoteException{
		//判断商品能否从系统中删除
		if((isExisted(g)==true)&&(beenTraded(g)==false))
			return 0;
		else if(isExisted(g)==false)
			return 2004; //商品不存在
		else if(beenTraded(g)==true)
			return 2005; //商品有过交易记录
		return 0;
	}
	public boolean canUpd(GoodsVO g) throws RemoteException{
		//判断商品能否在系统中被修改
		if(isExisted(g)==true)
			return true;
		else
			return false;
	}
    public int canSent(GoodsVO present) throws RemoteException{
		GoodsPO g=reader.finGood(present.getNumber());
    	if(g!=null){
			if(g.getAmount()>=present.getAmount()){
				return 0;
			}
			else
				return 2; //库存不足，无法赠送
		}
		else{
			//返回赠送商品不存在，无法进行赠送
			return 1;
		}
	}
	public boolean isExisted(GoodsVO g) throws RemoteException{
		if(reader.finGood(g.getNumber())==null)
    	    return false;
		else
			return true;
    }
	public boolean beenTraded(GoodsVO g){
		//需要知道交易单据存储在哪
		
		return false;
	}
    
}
