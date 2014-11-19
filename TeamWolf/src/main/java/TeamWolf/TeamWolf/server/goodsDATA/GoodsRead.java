package TeamWolf.TeamWolf.server.goodsDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.po.GoodsPO;

public class GoodsRead extends UnicastRemoteObject implements GoodsDataRead {

	protected GoodsRead() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsPO finGood(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GoodsPO> getGoodList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
