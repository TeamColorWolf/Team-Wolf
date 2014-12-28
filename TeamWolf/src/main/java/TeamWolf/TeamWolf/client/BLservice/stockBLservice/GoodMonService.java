package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

public interface GoodMonService {

	/**
	 * ��Ʒ����
	 * @param toIncrease
	 * @return
	 */
	public int increaseToMatch( GoodsVO toIncrease, String operator);
	/**
	 * ��Ʒ����
	 * @param toDecrease
	 * @return
	 */
	public int decreaseToMatch( GoodsVO toDecrease, String operator);
	/**
	 * ������Ʒ����ֵ
	 * @param goodWL
	 * @return
	 */
	public int setWaringLine(GoodsVO goodWL);
	
	public ArrayList<GoodsAlarmVO> getGoodsAlarm();
}
