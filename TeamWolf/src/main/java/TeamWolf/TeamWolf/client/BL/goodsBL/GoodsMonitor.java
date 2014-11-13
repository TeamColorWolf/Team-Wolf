package TeamWolf.TeamWolf.client.BL.goodsBL;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodMonService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataWrite;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsMonitor{

	GoodsBLAssistant assistant;
	GoodsDataRead reader;
	GoodsDataWrite writer;
	
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(goodWL)){
			//为该商品设置警戒线
			GoodsPO toSet;
		}
		else{
			//返回错误类型
		}
		return 0;
	}
	public int MonitoringWL(GoodsVO g){
		//检查某个商品数量是否低于警戒线
		return 0;
	}
	public GoodsAlarm warning(GoodsVO g){
		GoodsAlarm ga=new GoodsAlarm(g.getName(),"库存数量已低于警戒线！");
		return ga;
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(toIncrease)){
			//商品报溢
		}
		else{
			//返回错误类型
		}
		return 0;
	}
	public int decreaseToMatch(GoodsVO toDecrease) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(toDecrease)){
			//商品报损
		}
		else{
			//返回错误类型
		}
		return 0;
	}

    public int increaseGood(GoodsVO g){
		
		return 0;
	}
	public int decreaseGood(GoodsVO g){
		
		return 0;
	}
	
}
