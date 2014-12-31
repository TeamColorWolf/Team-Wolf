package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.StockApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.StockApplicationController;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockController;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockService;
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
	StockApplicationService appController;
	PromotionForStockService promoteController;
	
	public GoodsTrade(String IP){
		
		URL1="rmi://"+IP+"/goodsDATAservice";
		
		assistant=new GoodsBLAssistant(URL1);
		gmo=new GoodsMonitor(IP);
		promoteController=new PromotionForStockController(IP);
		
		try {
			dataService=(GoodsDataService)Naming.lookup(URL1);
			//appRead=(ApproveDATAservice)Naming.lookup(URL2);
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
		boolean notEnough=false;
		//逐个修改库存数量，最近售价
		try{
		//先一次性检查销售中所有商品的库存是否足够，如有一个不足够则不执行整个销售单
		for(GoodsVO g: goodsSL){
			
			if(!g.getName().contains("specialGoods")){
			      GoodsPO toSale=dataService.finGood(g.getNumber());
			      if(toSale.getAmount()<g.getAmount()){			    	 
				        notEnough=true;//返回错误类型:库存不足
			      }
			}
			else{
				  ArrayList<SpecialGoodsPromotionVO> sgl=promoteController.specialGoodsPackage();
				  boolean existed=false;
				  int index=0;
				  for(SpecialGoodsPromotionVO sg: sgl){
					  if(g.getName().equals(sg.number)){
						  existed=true;
						  index=sgl.indexOf(sg);
						  break;
					  }
				  }
				  if(existed==true){
					  
					  SpecialGoodsPromotionVO sg=sgl.get(index);
					  ArrayList<GiftForPromotionVO> gl=sg.list;
					  for(GiftForPromotionVO gp: gl){
						  GoodsPO toSale=dataService.finGood(gp.GoodsName);
						  if(toSale.getAmount()<(gp.sendNumber*g.getAmount())){					    
						        notEnough=true;//返回错误类型:库存不足
					      }
					  }
				  }
				  else{					 
					   return 2007; //返回错误类型： 该特价包已经不在了
				  }
				  
			}
		}
		
		if(notEnough==true){
			return 2006;//返回库存不足
		}
		
		//所有商品库存都足够，逐个进行减库存处理
		else{
			for(GoodsVO g: goodsSL){
				
				if(!g.getName().contains("specialGoods")){
				      GoodsPO toSale=dataService.finGood(g.getNumber());
				      int amount=toSale.getAmount()-g.getAmount();
				      toSale.setAmount(amount);
				      toSale.setLatestExprice(g.getExprice());
				      dataService.updGood(toSale);
				}
				else{
					  ArrayList<SpecialGoodsPromotionVO> sgl=promoteController.specialGoodsPackage();
					  boolean existed=false;
					  int index=0;
					  for(SpecialGoodsPromotionVO sg: sgl){
						  if(g.getName().equals(sg.number)){
							  existed=true;
							  index=sgl.indexOf(sg);
							  break;
						  }
					  }
					  if(existed==true){
						  
						  SpecialGoodsPromotionVO sg=sgl.get(index);
						  ArrayList<GiftForPromotionVO> gl=sg.list;
						  for(GiftForPromotionVO gp: gl){
							  GoodsPO toSale=dataService.finGood(gp.GoodsName);							 
						      int amount=toSale.getAmount()-gp.sendNumber*g.getAmount();
						      toSale.setAmount(amount);					           
						      dataService.updGood(toSale);						      
						  }
					  }
					  else{					 
						  return 2007; //返回错误类型： 该特价包已经不在了
					  }
					  
				}
			}
		}
		}catch(RemoteException e){
			e.printStackTrace();
			return 30000;  //返回通信错误
		}
		return 0;
	}
	
	
	public int goodsExportReject(SaleRejectListVO srl){
		
		ArrayList<GoodsVO> goodsSRL=srl.getGoodsList();
		
		//逐个修改库存数量
		try{
		for(GoodsVO g: goodsSRL){
			GoodsPO toEReject=dataService.finGood(g.getNumber());
			if(toEReject!=null){
			    int amount=toEReject.getAmount()+g.getAmount();
			    toEReject.setAmount(amount);
			    dataService.updGood(toEReject);
			}
			else{
				return 2004;  //商品不存在于系统中
			}
		}			
		}catch(RemoteException e){
			e.printStackTrace();
			return 30000;  //返回通信错误
		}
		
		return 0;
	}
	
	
	public int goodsImport(ImportListVO il){
		
		ArrayList<GoodsVO> goodsIL=il.getGoodsList();
		
		//逐个修改库存数量，最近进价
		try{
		for(GoodsVO g: goodsIL){
			GoodsPO toImport=dataService.finGood(g.getNumber());
			if(toImport!=null){
			    int amount=toImport.getAmount()+g.getAmount();
			    toImport.setAmount(amount);
			    toImport.setLatestImprice(g.getImprice());
			    dataService.updGood(toImport);
			}
			else{
				return 2004; //商品不存在于系统中
			}
		}
		}catch(RemoteException e){
			e.printStackTrace();
			return 30000; //返回通信错误
		}
		return 0;
	}
	
	
	public int goodsImportReject(ImportRejectListVO irl){
		
		ArrayList<GoodsVO> goodsIRL=irl.getGoodsList();
		
		//逐个修改库存数量
		try{
		for(GoodsVO g: goodsIRL){
		    GoodsPO toIReject=dataService.finGood(g.getNumber());
		    if(toIReject!=null){
		        if(toIReject.getAmount()>=g.getAmount()){
		    	     int amount=toIReject.getAmount()-g.getAmount();
		    	     toIReject.setAmount(amount);
		    	     dataService.updGood(toIReject);
		        }
		        else{
		    	     return 2006; //错误类型：库存已不足，无法退货
		        }
		    }
		    else{
		    	return 2004; //商品不存在于系统中
		    }
		}			
		}catch(RemoteException e){
			e.printStackTrace();
			return 30000;   //返回通信错误
		}
		
		
		return 0;
	}
	
	
	
	public int handlePresentList(ArrayList<GiftForPromotionVO> gl, String customer){
		
		ArrayList<String> pll=new ArrayList<String>();
		
		for(GiftForPromotionVO g:gl){
			int r=0;
			GoodsVO gg=new GoodsVO("", "", g.GoodsName, "", "", ""+g.sendNumber, "", "", "", "", "");
			if((r=gmo.decreaseGoods(gg))!=0){
				return r;  //若操作失败返回错误类型
			}; //逐个将被赠送商品库存数量减少
			
			pll.add(g.GoodsName+" "+g.sendNumber);
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
