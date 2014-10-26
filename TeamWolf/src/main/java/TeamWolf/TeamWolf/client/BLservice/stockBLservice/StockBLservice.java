
package TeamWolf.TeamWolf.client.BLservice.stockBLservice;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

public interface StockBLservice {

	/**
	 * ���ӷ���
	 * @param t
	 * @return
	 */
	public int addType(TypeVO t);
	/**
	 * ɾ�����
	 * @param t
	 * @return
	 */
	public int delType(TypeVO t);
	/**
	 * ���·���
	 * @param t
	 * @return
	 */
	public int updType(TypeVO t);
	/**
	 * ��ʾ���з���
	 * @return
	 */
	public TypeList shoAllType();
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
	/**
	 * �����Ʒ��
	 * @param present
	 * @return
	 */
	public int presentList( GoodsVO present);
    /**
     * �鿴�ض���Ʒ������ϸ��Ϣ
     * @param number
     * @return
     */
	public PresentList checkPL(int number);
	/**
	 * �鿴������Ʒ���Ĵ�����Ϣ
	 * @return
	 */
	public ArrayList<PresentList> shoSimplifiedPL();
	/**
	 * ��Ʒ����
	 * @param toIncrease
	 * @return
	 */
	public int increaseToMatch( GoodsVO toIncrease);
	/**
	 * ��Ʒ����
	 * @param toDecrease
	 * @return
	 */
	public int decreaseToMatch( GoodsVO toDecrease);
	/**
	 * ������Ʒ����ֵ
	 * @param goodWL
	 * @return
	 */
	public int setWaringLine(GoodsVO goodWL );
	
}
