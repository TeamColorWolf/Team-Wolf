package TeamWolf.TeamWolf.server.goodsDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataWrite;
import TeamWolf.TeamWolf.client.po.GoodsPO;

public class GoodsWrite extends UnicastRemoteObject implements GoodsDataWrite {

	protected GoodsWrite() throws RemoteException {
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

}
