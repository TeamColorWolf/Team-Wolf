package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

/***
 * 此接口包含商品管理（增、删、改、查、显示）功能
 * @author XYJ
 *
 */
public interface GoodManService {
    
	
	public int addGoods(GoodsVO g);
	
	public int delGoods(GoodsVO g);
	
	public int updGoods(GoodsVO g);
	
	public GoodsVO finGoods(GoodsVO g);
	
	public GoodsListVO shoGoods();

    //显示一段时间内的库存信息
	public GoodsStockListVO shoStockList( int beginDate, int endDate);
	
	//库存快照
	public GoodsStockListVO shoStockDaily();
	
	//模糊查找商品
	public ArrayList<GoodsVO> dimFinGoods(GoodsVO g);
	
}
