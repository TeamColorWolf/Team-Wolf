package TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice;
import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.*;
public interface GoodsDataWrite extends Remote {

	public int addGood(GoodsPO g) throws RemoteException;
	
	public int delGood(String number) throws RemoteException;
	
	/**
	 * �κ��漰���޸���Ʒ��ݵ���Ϊ�����ô˷������б���
	 * @param g
	 * @return
	 */
	public int updGood(GoodsPO g) throws RemoteException;
	
	
}
