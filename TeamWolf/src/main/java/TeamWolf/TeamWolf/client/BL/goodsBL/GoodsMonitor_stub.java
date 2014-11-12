package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.vo.GoodsAlarm;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsMonitor_stub {

    GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(goodWL)){
			//为该商品设置警戒线
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
		GoodsAlarm ga=new GoodsAlarm("警报","警报");
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
