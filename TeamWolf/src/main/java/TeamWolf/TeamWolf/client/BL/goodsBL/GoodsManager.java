package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataWrite;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsManager {

	GoodsBLAssistant assistant;
	GoodsDataRead reader;
	GoodsDataWrite writer;
	
	public GoodsManager(){
		assistant=new GoodsBLAssistant();
		//实例化reader和writer
	}
	
	public int addGoods(GoodsVO g){
		
		if(assistant.canAdd(g)){
		
			GoodsPO toAdd=new GoodsPO(g);
			try {
				writer.addGood(toAdd);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//返回通信错误
			}
		}
		else{ //返回错误类型：商品已经存在与系统中
			
		}
		return 0;
	}
	public int delGoods(GoodsVO g){
		
		int result=assistant.canDel(g);
		if(result==0){
			
			try {
				writer.delGood(g.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//返回通信错误
			}
		}
		else{ //返回错误类型：商品不存在于系统中或者商品有过交易记录
			
			return result; 
		}
		
		return 0;
	}
	public int updGoods(GoodsVO g){
		
		if(assistant.canUpd(g)){
			
			try {
				GoodsPO toUpd=reader.finGood(g.getNumber());
				/*对PO进行修改*/
				
				writer.updGood(toUpd);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//返回通信错误
			}
			
		}
		else{ //返回错误类型：商品不存在于系统中
		
		}
		return 0;
	}
	public GoodsVO finGoods(GoodsVO g) {
		
		if(assistant.canFin(g)){
			
			try {
				GoodsPO found=reader.finGood(g.getNumber());
				//对g进行修改
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{ //返回错误类型：商品不存在于系统中
			
		}
		return g;
	}
	public GoodsList shoGoods(){
		GoodsList gl=new GoodsList();
		
		try {
			ArrayList<GoodsPO> agl=reader.getGoodList();
			for(GoodsPO g:agl){
				//逐个加入 gl中
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		return gl;
	}
	public GoodsStockList shoStockList(int beginDate, int endDate){
		
		GoodsStockList gsl=new GoodsStockList();
		
		//根据时间查找每个库存商品的交易记录，计算并生成对应的GoodsStockVO
		//调用销售业务的接口
		
		return gsl;
	}
	public GoodsStockList shoStockDaily(){
		
		GoodsStockList gsl=new GoodsStockList();
		//查找当天的交易记录，计算并生成对应的GoodsStockVO
		//调用销售业务的接口
		
		return gsl;
	}
	
}
