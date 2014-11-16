package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataWrite;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.*;
import TeamWolf.TeamWolf.client.po.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsTrade {

	GoodsBLAssistant assistant;
	GoodsMonitor gmo;
	GoodsDataRead reader;
	GoodsDataWrite writer;
	
	public GoodsTrade(String URL1, String URL2){
		assistant=new GoodsBLAssistant(URL1);
		gmo=new GoodsMonitor(URL1, URL2);
		try {
			reader=(GoodsDataRead)Naming.lookup(URL1);
			writer=(GoodsDataWrite)Naming.lookup(URL2);
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
		
		
		return 0;
	}
	public int goodsExportReject(SaleRejectListVO srl){
		
		ArrayList<GoodsVO> goodsSRL=srl.getGoodsList();
		
		//逐个修改库存数量
		
		return 0;
	}
	public int goodsImport(ImportListVO il){
		
		ArrayList<GoodsVO> goodsIL=il.getGoodsList();
		
		//逐个修改库存数量，最近进价
		
		return 0;
	}
	public int goodsImportReject(ImportRejectListVO irl){
		
		ArrayList<GoodsVO> goodsIRL=irl.getGoodsList();
		
		//逐个修改库存数量
		
		
		return 0;
	}
	
	public int presentList(ArrayList<GoodsVO> presentList, String operator, CustomerVO customer){
		
		int r=0;
		for(GoodsVO g:presentList){
			if((r=assistant.canSent(g))==0){
				
			}
			else{ //返回具体错误类型：该商品无法赠送
				return r; 
			}
		}
		
		//检查完毕后生成赠送单，提交审批，调用ApplicationBL接口
 		
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
