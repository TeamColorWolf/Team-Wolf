package TeamWolf.TeamWolf.client.DATAservice.stockDATAservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;
public interface StockDataRead {

	public TypePO finType(String number) throws RemoteException;
	
	public ArrayList<TypePO> shoTypeList() throws RemoteException;
}
