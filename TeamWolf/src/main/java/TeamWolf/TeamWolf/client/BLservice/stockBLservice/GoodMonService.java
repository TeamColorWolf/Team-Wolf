package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;
/***
 * 此接口实现商品监控（报溢、报损、警报、设置警戒线）功能
 * @author XYJ
 *
 */
public interface GoodMonService {

	//报溢
	public int increaseToMatch( GoodsVO toIncrease, String operator);

    //报损
	public int decreaseToMatch( GoodsVO toDecrease, String operator);
	
	public int setWaringLine(GoodsVO goodWL);
	
	//获得警报
	public ArrayList<GoodsAlarmVO> getGoodsAlarm();
}
