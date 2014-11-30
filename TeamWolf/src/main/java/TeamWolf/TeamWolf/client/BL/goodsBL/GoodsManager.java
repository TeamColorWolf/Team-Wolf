package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsManager {

	String URL1, URL2;
	GoodsBLAssistant assistant;
	GoodsDataService GdataService;
	StockDataService SdataService;
	
	public GoodsManager(String IP){
		
		URL1="rmi://"+IP+"/goodsDATAservice";
		URL2="rmi://"+IP+"/stockDATAservice";
		
		assistant=new GoodsBLAssistant(URL1);
		try {
			
			GdataService=(GoodsDataService)Naming.lookup(URL1);
			SdataService=(StockDataService)Naming.lookup(URL2);
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
	
	public int addGoods(GoodsVO g){
		
		try {
		if(assistant.canAdd(g)){
		
			GoodsPO toAdd=new GoodsPO(g);
			TypePO parent=SdataService.finType(g.getParentNum());
			if(parent.getC()==1){
				return 2001;//返回错误类型：父分类下有子分类，不可添加商品
			}
			else{
				parent.addLeaveNode(toAdd);
				SdataService.updType(parent);
				GdataService.addGood(toAdd);
			}			
		}
		else{   return 2002;//返回错误类型：商品已经存在与系统中
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public int delGoods(GoodsVO g){
		
		try {
		int result=assistant.canDel(g);
		if(result==0){
				
			    TypePO parent=SdataService.finType(g.getParentNum());
			    if(parent.delLeaveNode(g.getNumber())){
			    	GdataService.delGood(g.getNumber());
			    	SdataService.updType(parent);
			    }else{
			    	 return 2003;//错误类型:删除的商品与父分类不匹配
			    }
						
		}
		else{   //返回错误类型：商品不存在于系统中或者商品有过交易记录
			
			return result; 
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		
		return 0;
	}
	public int updGoods(GoodsVO g){
		
		try {
		if(assistant.canUpd(g)){
			
				GoodsPO toUpd=GdataService.finGood(g.getNumber());
				TypePO parent=SdataService.finType(g.getParentNum());
				/*对PO进行修改*/
				if(g.getName()!=null)
					toUpd.setName(g.getName());
				if(g.getModel()!=null)
					toUpd.setModel(g.getModel());
				if(g.getExprice()!=0){
					toUpd.setExprice(g.getExprice());
					//System.out.println(g.getExprice());
				}
				if(g.getImprice()!=0){
					toUpd.setImprice(g.getImprice());
					//System.out.println(g.getImprice());
				}
				
				//System.out.println(toUpd.getName()+" "+toUpd.getImprice()+" "+toUpd.getExprice());
				parent.updLeaveNode(toUpd);
				SdataService.updType(parent);
				GdataService.updGood(toUpd);			
			
		}
		else{  return 2004;//返回错误类型：商品不存在于系统中
		
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return 0;
	}
	public GoodsVO finGoods(GoodsVO g) {
		
		try {

		GoodsPO found=GdataService.finGood(g.getNumber());
		//对g进行修改			
        if(found!=null){
            g.setName(found.getName());
            g.setModel(found.getModel());
        	g.setAmount(found.getAmount());
        	g.setExprice(found.getExprice());
        	g.setImprice(found.getImprice());
        	g.setLatestExprice(found.getLatestExprice());
        	g.setLatestImprice(found.getLatestImprice());
        	g.setModel(found.getModel());
        	g.setParent(found.getParent().getName());
        	g.setParentNum(found.getParent().getNumber());
        }
		else{ return null;//返回错误类型：商品不存在于系统中
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
			
		}
		return g;
	}
	
	public ArrayList<GoodsVO> dimFinGoods(GoodsVO g){
	   
		ArrayList<GoodsVO> result=new ArrayList<GoodsVO>();
		try {
			ArrayList<GoodsPO> agl=GdataService.getGoodList();
			for(GoodsPO gg: agl){
				
				if((g.getName()!=null&&gg.getName().equals(g.getName()))||(g.getModel()!=null&&gg.getModel().equals(g.getModel()))){
					result.add(new GoodsVO(gg));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return result;
	}
	public GoodsListVO shoGoods(){
		
		GoodsListVO gl=new GoodsListVO();
		try {
			ArrayList<GoodsPO> agl=GdataService.getGoodList();
			for(GoodsPO g:agl){
				//逐个加入 gl中
				GoodsVO gg=new GoodsVO(g);
				gl.addGood(gg);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
       
		return gl;
	}
	public GoodsStockListVO shoStockList(int beginDate, int endDate){
		
		GoodsStockListVO gsl=new GoodsStockListVO();
		
		//根据时间查找每个库存商品的交易记录，计算并生成对应的GoodsStockVO
		//需要知道交易单据存储位置
		
		return gsl;
	}
	public GoodsStockListVO shoStockDaily(){
		
		GoodsStockListVO gsl=new GoodsStockListVO();
		//查找当天的交易记录，计算并生成对应的GoodsStockVO
		//需要知道交易单据存储位置
		
		return gsl;
	}
	
}
