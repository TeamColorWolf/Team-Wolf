package TeamWolf.TeamWolf.server.applicationDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;

public class StockApplicationDATA extends UnicastRemoteObject implements StockApplicationDATAservice{

	protected StockApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int submitIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changePresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PresentListPO> shoPL() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
