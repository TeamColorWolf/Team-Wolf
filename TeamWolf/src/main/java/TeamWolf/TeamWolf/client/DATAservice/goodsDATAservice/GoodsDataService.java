package TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;

/**
 * 
 * @author XYJ
 *
 */
public interface GoodsDataService extends Remote {

	public int addGood(GoodsPO g) throws RemoteException;
	
	public int delGood(String number) throws RemoteException;
	
	/**
	 * �κ��漰���޸���Ʒ��ݵ���Ϊ�����ô˷������б���
	 * @param g
	 * @return
	 */
	public int updGood(GoodsPO g) throws RemoteException;
	
	public GoodsPO finGood(String number) throws RemoteException;
	
	public ArrayList<GoodsPO> getGoodList() throws RemoteException;
	
	public int addGoodsAlarm(GoodsAlarmPO ga) throws RemoteException;
	
	public ArrayList<GoodsAlarmPO> getAlarmList() throws RemoteException;
}
