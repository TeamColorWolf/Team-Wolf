package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
/**
 * Author WHJ
 */
public interface StockApplicationDATAservice extends Remote {
	public int submitIncreaseToMatch(IncreaseToMatchPO po) throws RemoteException;
	
	public int submitDecreaseToMatch(DecreaseToMatchPO po) throws RemoteException;
	
	public int submitPresentList(PresentListPO po) throws RemoteException;
	
	public int approvalIncreaseToMatch(IncreaseToMatchPO po) throws RemoteException;
	
	public int approvalDecreaseToMatch(DecreaseToMatchPO po) throws RemoteException;
	
	public int approvalPresentList(PresentListPO po) throws RemoteException;
	
	public int rejectIncreaseToMatch(IncreaseToMatchPO po) throws RemoteException;
	
	public int rejectDecreaseToMatch(DecreaseToMatchPO po) throws RemoteException;
	
	public int rejectPresentList(PresentListPO po) throws RemoteException;
	
	public IncreaseToMatchPO finIncreaseToMatch(String number) throws RemoteException;
	
	public DecreaseToMatchPO finDecreaseToMatch(String number) throws RemoteException;
	
	public PresentListPO finPresentList(String number) throws RemoteException;
	
	public ArrayList<PresentListPO> shoPL() throws RemoteException;
}
