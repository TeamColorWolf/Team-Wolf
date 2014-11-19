package TeamWolf.TeamWolf.server.goodsDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataRead;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataWrite;
import TeamWolf.TeamWolf.client.po.GoodsPO;

public class GoodsData extends UnicastRemoteObject implements GoodsDataWrite,GoodsDataRead {

	ArrayList<GoodsPO> goodsList;
	
	protected GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addGood(GoodsPO g) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delGood(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updGood(GoodsPO g) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
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
