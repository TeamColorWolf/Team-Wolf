package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodMonService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsMonitor{

	String URL1,URL2;
	GoodsBLAssistant assistant;
	GoodsDataService dataService;
	
	public GoodsMonitor(String IP){
		assistant=new GoodsBLAssistant(URL1);
		try {
			
			dataService=(GoodsDataService)Naming.lookup(URL2);
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
	
	public int setWaringLine(GoodsVO goodsWL) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(goodsWL)){
			//为该商品设置警戒线
			GoodsPO toSet;
			try {
				toSet = dataService.finGood(goodsWL.getNumber());
				toSet.setWarningLine(goodsWL.gerWarningLine());
				dataService.updGood(toSet);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                //返回通信错误
			}
			
		}
		else{
			//返回错误类型
		}
		return 0;
	}
	
	//此方法在赠送单或者销售单处理后被调用
	public int MonitoringWL(GoodsVO g){
		//检查某个商品数量是否低于警戒线
		try {
			if(dataService.finGood(g.getNumber()).checkWL()){
				//库存数量低于警戒线
				/*...进行警报处理...*/
				
			}else{
				//库存正常
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	
	public GoodsAlarmVO warning(GoodsVO g){
		GoodsAlarmVO ga=new GoodsAlarmVO(g.getName(),"库存数量已低于警戒线！");
		return ga;
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(toIncrease)){
			//商品报溢
			increaseGoods(toIncrease);
			//调用ApplicationBL接口生成报溢单
		}
		else{
			//返回错误类型
		}
		return 0;
	}
	public int decreaseToMatch(GoodsVO toDecrease) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(toDecrease)){
			//商品报损
			decreaseGoods(toDecrease);
			//调用ApplicationBL接口生成报损单
			
		}
		else{
			//返回错误类型
		}
		return 0;
	}

    public int increaseGoods(GoodsVO g){
		
    	try {
			GoodsPO toIncrease=dataService.finGood(g.getNumber());
			int amount=toIncrease.getAmount()+g.getAmount();
			toIncrease.setAmount(amount);
			dataService.updGood(toIncrease);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public int decreaseGoods(GoodsVO g){
		
		try {
			GoodsPO toDecrease=dataService.finGood(g.getNumber());
			int amount=toDecrease.getAmount()-g.getAmount();
			toDecrease.setAmount(amount);
			dataService.updGood(toDecrease);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	
}
