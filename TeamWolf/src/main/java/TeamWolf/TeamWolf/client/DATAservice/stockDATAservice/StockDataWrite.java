package TeamWolf.TeamWolf.client.DATAservice.stockDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.*;

public interface StockDataWrite extends Remote{

	public int addType(TypePO t) throws RemoteException;
	
	public int delType(String number) throws RemoteException;
	
	/**
	 * �޸�����Ϣ�Ĳ��������ô˷������б���
	 * @param t
	 * @return
	 */
	public int updType(TypePO t) throws RemoteException;
}
