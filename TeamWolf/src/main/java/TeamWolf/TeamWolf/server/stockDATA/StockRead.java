package TeamWolf.TeamWolf.server.stockDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataRead;
import TeamWolf.TeamWolf.client.po.TypePO;

/**
 * 
 * @author XYJ
 *
 */
public class StockRead extends UnicastRemoteObject implements StockDataRead{

	protected StockRead() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypePO finType(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TypePO> shoTypeList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
