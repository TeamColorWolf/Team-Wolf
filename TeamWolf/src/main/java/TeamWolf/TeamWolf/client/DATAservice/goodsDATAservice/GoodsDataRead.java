package TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;

public interface GoodsDataRead {

	public GoodsPO finGood(String number) throws RemoteException;
	public ArrayList<GoodsPO> getGoodList() throws RemoteException;
	
}
