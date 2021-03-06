package TeamWolf.TeamWolf.client.DATAservice.stockDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;

/**
 * 
 * @author XYJ
 *
 */
public interface StockDataService extends Remote{

	public int addType(TypePO t) throws RemoteException;
	
	public int delType(String number) throws RemoteException;
	
	/**
	 * �޸�����Ϣ�Ĳ��������ô˷������б���
	 * @param t
	 * @return
	 */
	public int updType(TypePO t) throws RemoteException;
	
	public TypePO finType(String number) throws RemoteException;
	
	public ArrayList<TypePO> shoTypeList() throws RemoteException;
}
