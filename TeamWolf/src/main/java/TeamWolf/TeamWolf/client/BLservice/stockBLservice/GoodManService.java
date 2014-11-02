package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import TeamWolf.TeamWolf.client.vo.*;

public interface GoodManService {
    
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int addGoods(GoodsVO g);
	/**
	 * ɾ����Ʒ
	 * @param g
	 * @return
	 */
	public int delGoods(GoodsVO g);
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int updGoods(GoodsVO g);
	/**
	 * ������Ʒ
	 * @param g
	 * @return
	 */
	public int finGoods(GoodsVO g);
	/**
	 * ��ʾ������Ʒ
	 * @return
	 */
	public GoodList shoGoods();
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
