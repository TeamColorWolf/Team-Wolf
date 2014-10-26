package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import TeamWolf.TeamWolf.client.vo.*;

public interface GoodManService {
    
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int addGood(GoodsVO g);
	/**
	 * ɾ����Ʒ
	 * @param g
	 * @return
	 */
	public int delGood(GoodsVO g);
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int updGood(GoodsVO g);
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int finGood(GoodsVO g);
	/**
	 * ��ʾ������Ʒ
	 * @return
	 */
	public GoodList shoGood();
	/**
	 * �鿴���
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public GoodsStockList shoStockList( int beginDate, int endDate);
	/**
	 * ����̵�
	 * @return
	 */
	public GoodsStockList shoStockDaily();
	
}
