package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

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
	public GoodsVO finGoods(GoodsVO g);
	/**
	 * ��ʾ������Ʒ
	 * @return
	 */
	public GoodsListVO shoGoods();
	/**
	 * �鿴���
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public GoodsStockListVO shoStockList( int beginDate, int endDate);
	/**
	 * ����̵�
	 * @return
	 */
	public GoodsStockListVO shoStockDaily();
	
	public ArrayList<GoodsVO> dimFinGoods(GoodsVO g);
	
}
