package TeamWolf.TeamWolf.client.BL.goodsBL;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.vo.*;

public class GoodsManager implements GoodManService {

	GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	public int addGoods(GoodsVO g){
		return 0;
	}
	public int delGoods(GoodsVO g){
		return 0;
	}
	public int updGoods(GoodsVO g){
		return 0;
	}
	public int finGoods(GoodsVO g){
		return 0;
	}
	public GoodList shoGoods(){
		return null;
	}
	public GoodsStockList shoStockList(int beginDate, int endDate){
		return null;
	}
	public GoodsStockList shoStockDaily(){
		return null;
	}
	
}
