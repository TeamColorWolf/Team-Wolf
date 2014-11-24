package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.*;
import TeamWolf.TeamWolf.client.po.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsTrade {

	String URL1,URL2,URL3;
	GoodsBLAssistant assistant;
	GoodsMonitor gmo;
	GoodsDataService dataService;
	ApproveDATAservice appRead;
	StockApplicationController appController;
	
	public GoodsTrade(String IP){
		assistant=new GoodsBLAssistant(URL1);
		gmo=new GoodsMonitor(IP);
		try {
			dataService=(GoodsDataService)Naming.lookup(URL1);
			appRead=(ApproveDATAservice)Naming.lookup(URL2);
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
	
	public int goodsExport(SaleListVO sl){
		
		ArrayList<GoodsVO> goodsSL=sl.getGoodsList();
		
		//逐个修改库存数量，最近售价
		try{
		for(GoodsVO g: goodsSL){
			GoodsPO toSale=dataService.finGood(g.getNumber());
			if(toSale.getAmount()>=g.getAmount()){
			    toSale.setAmount(toSale.getAmount()-g.getAmount());
			    toSale.setLatestExprice(g.getExprice());
			    dataService.updGood(toSale);
			}
			else{
				//返回错误类型:库存不足
			}
		}
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public int goodsExportReject(SaleRejectListVO srl){
		
		ArrayList<GoodsVO> goodsSRL=srl.getGoodsList();
		
		//逐个修改库存数量
		try{
		for(GoodsVO g: goodsSRL){
			GoodsPO toEReject=dataService.finGood(g.getNumber());
			toEReject.setAmount(toEReject.getAmount()+g.getAmount());
			dataService.updGood(toEReject);
		}			
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
		}
		
		return 0;
	}
	public int goodsImport(ImportListVO il){
		
		ArrayList<GoodsVO> goodsIL=il.getGoodsList();
		
		//逐个修改库存数量，最近进价
		try{
		for(GoodsVO g: goodsIL){
			GoodsPO toImport=dataService.finGood(g.getNumber());
			toImport.setAmount(toImport.getAmount()+g.getAmount());
			toImport.setLatestImprice(g.getImprice());
			dataService.updGood(toImport);
		}
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public int goodsImportReject(ImportRejectListVO irl){
		
		ArrayList<GoodsVO> goodsIRL=irl.getGoodsList();
		
		//逐个修改库存数量
		try{
		for(GoodsVO g: goodsIRL){
		    GoodsPO toIReject=dataService.finGood(g.getNumber());
		    if(toIReject.getAmount()>=g.getAmount()){
		    	toIReject.setAmount(toIReject.getAmount()-g.getAmount());
		    	dataService.updGood(toIReject);
		    }
		    else{
		    	//错误类型：库存已不足，无法退货
		    }
		}			
		}catch(RemoteException e){
			e.printStackTrace();
			//返回通信错误
		}
		
		
		return 0;
	}
	
	public int presentList(ArrayList<GoodsVO> presentList, String operator, CustomerVO customer){
		
		int r=0;
		PresentListVO pl=new PresentListVO();
		pl.setOperator(operator);
		pl.setCustomer(customer);
		for(GoodsVO g:presentList){
			try{
			if((r=assistant.canSent(g))==0){
				pl.addPresent(g);
			}
			else{ //返回具体错误类型：该商品无法赠送（不存在或者库存不足）
				return r; 
			}
			}catch(RemoteException e){
				e.printStackTrace();
				//返回通信错误
			}
		}
			    
		//检查完毕后生成赠送单，提交审批，调用ApplicationBL接口
 		appController.submitPresentList(pl);
		//操作成功为返回0
		return 0;
	}
	
	public int handlePresentList(PresentListVO p){
		
		ArrayList<GoodsVO> pl=p.getPList();
		for(GoodsVO g:pl){
			int r=0;
			if((r=gmo.decreaseGoods(g))!=0){
				return r;  //若操作失败返回错误类型
			}; //逐个将被赠送商品库存数量减少
		}
		
		return 0;
	}
		
	public PresentListVO checkPL(int number) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public ArrayList<PresentListVO> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
