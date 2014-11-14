package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.vo.GoodsAlarmVO;
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
			System.out.println("商品警戒线是：");
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
	public GoodsAlarmVO warning(GoodsVO g){
		GoodsAlarmVO ga=new GoodsAlarmVO(g.getName(),"库存数量已低于警戒线！");
		System.out.println(ga.getWarningInfo());
		return ga;
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(toIncrease)){
			//商品报溢
			System.out.println("商品报溢！");
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
			System.out.println("商品报损！");
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
