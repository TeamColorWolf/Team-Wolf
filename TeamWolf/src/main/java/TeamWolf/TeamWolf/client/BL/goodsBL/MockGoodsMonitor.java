package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.po.GoodsAlarmPO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 
 * @author XYJ
 *
 */
public class MockGoodsMonitor {

    GoodsBLAssistant_stub assistant ;
	
	
	public MockGoodsMonitor(String iP) {
		// TODO Auto-generated constructor stub
		assistant=new GoodsBLAssistant_stub(iP);
	}
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		if(assistant.isExisted(goodWL)){
			//为该商品设置警戒线
			System.out.println("商品警戒线是：");
		}
		else{
			//返回错误类型
			System.out.println("失败了T T");
			return 1112;
		}
		return 0;
	}
	public int MonitoringWL(GoodsVO g){
		//检查某个商品数量是否低于警戒线
		return 0;
	}
	public GoodsAlarmPO warning(GoodsVO g){
		GoodsAlarmPO ga=new GoodsAlarmPO("20141111", g.getNumber()+"-"+g.getName()+"-"+g.getModel(), "库存数量已低于警戒线！");
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
			System.out.println("失败了T T");
			return 1112;
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
			System.out.println("失败了T T");
			return 1112;
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
