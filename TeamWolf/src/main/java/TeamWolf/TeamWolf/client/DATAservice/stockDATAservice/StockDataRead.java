package TeamWolf.TeamWolf.client.DATAservice.stockDATAservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;
public interface StockDataRead extends Remote {

	public TypePO finType(String name) throws RemoteException;
	
	public ArrayList<TypePO> shoTypeList() throws RemoteException;
}
