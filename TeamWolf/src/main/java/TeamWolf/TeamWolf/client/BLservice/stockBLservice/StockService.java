package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import TeamWolf.TeamWolf.client.vo.*;
public interface StockService {

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

	
}
