package TeamWolf.TeamWolf.server.applicationDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class StockApplicationDATA extends UnicastRemoteObject implements StockApplicationDATAservice{

	
	ArrayList<IncreaseToMatchPO> ITMList;
	ArrayList<DecreaseToMatchPO> DTMList;
	
	
	public StockApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		initial();
		
		if(ITMList==null)
			ITMList=new ArrayList<IncreaseToMatchPO>();
		if(DTMList==null)
			DTMList=new ArrayList<DecreaseToMatchPO>();
	}

	public int submitIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		ITMList.add(po);
		try {
			FileOpr.writeFile(FileName.increaseToMatchFile, ITMList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int submitDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		DTMList.add(po);
		try {
			FileOpr.writeFile(FileName.decreaseToMatchFile, DTMList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public ArrayList<IncreaseToMatchPO> shoITM() throws RemoteException {
		// TODO Auto-generated method stub
		
		return ITMList;
	}

	public ArrayList<DecreaseToMatchPO> shoDTM() throws RemoteException {
		// TODO Auto-generated method stub
		return DTMList;
	}
	
	private void initial(){
		try {
			ITMList=(ArrayList<IncreaseToMatchPO>)FileOpr.readFile(FileName.increaseToMatchFile);
			DTMList=(ArrayList<DecreaseToMatchPO>)FileOpr.readFile(FileName.decreaseToMatchFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
