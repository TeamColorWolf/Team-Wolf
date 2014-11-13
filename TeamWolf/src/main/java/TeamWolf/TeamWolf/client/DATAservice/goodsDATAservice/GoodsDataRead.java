package TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;

public interface GoodsDataRead extends Remote {

	public GoodsPO finGood(String number) throws RemoteException;
	public ArrayList<GoodsPO> getGoodList() throws RemoteException;
	
}
