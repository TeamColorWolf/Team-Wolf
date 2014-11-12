package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.vo.GoodsList;
import TeamWolf.TeamWolf.client.vo.GoodsStockList;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsManager_stub {


	GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	public int addGoods(GoodsVO g){
		if(assistant.canAdd(g)){
			//加入商品
		}
		else{
			//返回错误：商品已存在于系统中
		}
		return 0;
	}
	public int delGoods(GoodsVO g){
		if(assistant.canDel(g)==0){
			//删除商品
		}
		else{
			//返回错误：商品不存在于系统中
		}
		return 0;
	}
	public int updGoods(GoodsVO g){
		if(assistant.canUpd(g)){
			//更新商品
		}
		else{
			//返回错误：商品不存在于系统中
		}
		return 0;
	}
	public GoodsVO finGoods(GoodsVO g){
		if(assistant.canFin(g)){
			//查找商品
			
			/*....*/
			GoodsVO gv=new GoodsVO(null, null, null, null, null, null, null, null, null);
			g=gv;
		}
		else{
			//返回错误：商品不存在于系统中
		}
		return g;
	}
	public GoodsList shoGoods(){
		GoodsList gl=new GoodsList();
		return gl;
	}
	public GoodsStockList shoStockList(int beginDate, int endDate){
		GoodsStockList gsl=new GoodsStockList();
		return gsl;
	}
	public GoodsStockList shoStockDaily(){
		GoodsStockList gsl=new GoodsStockList();
		return gsl;
	}
}
