package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.GoodsListVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
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
			System.out.println("添加商品！");
			
		}
		else{
			//返回错误：商品已存在于系统中
		}
		return 0;
	}
	public int delGoods(GoodsVO g){
		if(assistant.canDel(g)==0){
			//删除商品
			System.out.println("删除商品！");
			
		}
		else{
			//返回错误：商品不存在于系统中
		}
		return 0;
	}
	public int updGoods(GoodsVO g){
		if(assistant.canUpd(g)){
			//更新商品
			System.out.println("更新商品！");
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
			GoodsVO gv=new GoodsVO(null, null, null, null, null, null, null, null, null, null);
			g=gv;
			System.out.println("商品是：");
		}
		else{
			//返回错误：商品不存在于系统中
		}
		return g;
	}
	public GoodsListVO shoGoods(){
		GoodsListVO gl=new GoodsListVO();
		System.out.println("商品列表：");
		return gl;
	}
	public GoodsStockListVO shoStockList(int beginDate, int endDate){
		GoodsStockListVO gsl=new GoodsStockListVO();
		System.out.println("库存信息");
		return gsl;
	}
	public GoodsStockListVO shoStockDaily(){
		GoodsStockListVO gsl=new GoodsStockListVO();
		System.out.println("库存快照！");
		return gsl;
	}
}
