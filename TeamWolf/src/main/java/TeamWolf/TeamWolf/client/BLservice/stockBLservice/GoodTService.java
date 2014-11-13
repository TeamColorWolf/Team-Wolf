package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

public interface GoodTService {

	/**
	 * �����Ʒ��
	 * @param present
	 * @return
	 */
	public int presentList(ArrayList<GoodsVO> present, String operator, CustomerVO customer);
    /**
     * �鿴�ض���Ʒ������ϸ��Ϣ
     * @param number
     * @return
     */
	public PresentListVO checkPL(int number);
	/**
	 * �鿴������Ʒ���Ĵ�����Ϣ
	 * @return
	 */
	public ArrayList<PresentListVO> shoSimplifiedPL();
	
}
