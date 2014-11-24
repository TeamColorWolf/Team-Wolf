package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodMonService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsAlarmPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 * 此类需要与Application模块协作，以提交报溢报损单
 */
public class GoodsMonitor{

	String URL1;
	GoodsBLAssistant assistant;
	GoodsDataService dataService;
	StockApplicationController appController;
	
	public GoodsMonitor(String IP){
		assistant=new GoodsBLAssistant(URL1);
		appController=new StockApplicationController(IP);
		try {			
			dataService=(GoodsDataService)Naming.lookup(URL1);
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
		try {
		if(assistant.isExisted(goodsWL)){
			//为该商品设置警戒线
			GoodsPO toSet;
				toSet = dataService.finGood(goodsWL.getNumber());
				toSet.setWarningLine(goodsWL.gerWarningLine());
				dataService.updGood(toSet);		
		}
		else{
			//返回错误类型
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            //返回通信错误
		}
		return 0;
	}
	
	//此方法在赠送单或者销售单处理后被调用,每次商品库存被减少时使用
	public int MonitoringWL(GoodsVO g){
		//检查某个商品数量是否低于警戒线
		try {
			if(dataService.finGood(g.getNumber()).checkWL()){
				//库存数量低于警戒线
				/*...进行警报处理...*/
				if(warning(g)==0)
					; //报警成功
				else 
					; //报警出现通信错误，需要手动确认商品库存
				//返回警报类型
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
	
	public int warning(GoodsVO g){
		GoodsAlarmPO ga=new GoodsAlarmPO(assistant.getPresentTime(), g.getNumber()+"-"+g.getName()+"-"+g.getModel(),"库存数量已低于警戒线！");
		try {
			dataService.addGoodsAlarm(ga);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		try{
		if(assistant.isExisted(toIncrease)&&increaseGoods(toIncrease)==0){
			//商品报溢			
			//调用ApplicationBL接口生成报溢单
			    IncreaseToMatchVO itm=new IncreaseToMatchVO(toIncrease);
			    appController.submitIncreaseToMatch(itm);		
		}
		else{
			//返回错误类型
		}
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public int decreaseToMatch(GoodsVO toDecrease) {
		// TODO Auto-generated method stub
		try{
		if(assistant.isExisted(toDecrease)){
			//商品报损
			int result=decreaseGoods(toDecrease);
			//调用ApplicationBL接口生成报损单
			if(result==0){
			     DecreaseToMatchVO dtm=new DecreaseToMatchVO(toDecrease);
			     appController.submitDecreaseToMatch(dtm);
			}
			else{
				return result;  //减少数量不成功（通信错误或库存不足）
			}
		}
		else{
			//返回错误类型
		}
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
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
			if(amount>=0){
			   toDecrease.setAmount(amount);
			   dataService.updGood(toDecrease);	
			}
			else{
				//返回库存不足
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return this.MonitoringWL(g); //调用减少商品库存的方法即调用监测方法
	}
	
}
