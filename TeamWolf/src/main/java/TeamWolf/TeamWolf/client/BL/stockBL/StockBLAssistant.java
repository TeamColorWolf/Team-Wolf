package TeamWolf.TeamWolf.client.BL.stockBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLAssistant {
	
    StockDataService reader;
	
	public StockBLAssistant(String URL){
		try {
			reader=(StockDataService)Naming.lookup(URL);
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
	public boolean canAdd(TypeVO t) throws RemoteException{
		//检查此商品分类是否能加入系统的逻辑判断
		if(isExisted(t))
		     return false;
		else
			 return true;
	}
	public boolean canDel(TypeVO t) throws RemoteException{
		//检查是否能将此分类从系统中删除的逻辑判断
		if(isExisted(t))
			return true;
		else
			return false;
	}
	public boolean canUpd(TypeVO t) throws RemoteException{
		//检查是否能修改系统中此商品分类的逻辑判断
		if(isExisted(t))
			return true;
		else
			return false;
	}
	
	
	//逻辑判断中需要用到的私有方法
	private boolean isExisted(TypeVO t) throws RemoteException{	
		if(reader.finType(t.getNumber())==null)
		    return false;
		else
			return true;
	}

	
	/*public static void main(String[] args){
		StockBLAssistant s=new StockBLAssistant();
		System.out.println(s.getPresentTime());
	}*/
}
