package TeamWolf.TeamWolf.client.BL.goodsBL;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.vo.*;

public class GoodsManager implements GoodManService {

	GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	public int addGood(GoodsVO g){
		return 0;
	}
	public int delGood(GoodsVO g){
		return 0;
	}
	public int updGood(GoodsVO g){
		return 0;
	}
	public int finGood(GoodsVO g){
		return 0;
	}
	public GoodList shoGood(){
		return null;
	}
	public GoodsStockList shoStockList(int beginDate, int endDate){
		return null;
	}
	public GoodsStockList shoStockDaily(){
		return null;
	}
	
}
