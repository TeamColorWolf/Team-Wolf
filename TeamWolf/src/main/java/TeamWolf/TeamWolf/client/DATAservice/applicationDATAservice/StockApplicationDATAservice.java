package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
/**
 * 
 * @author WHJ
 *
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
	
	public int changeIncreaseToMatch(IncreaseToMatchPO po) throws RemoteException;
	
	public int changeDecreaseToMatch(DecreaseToMatchPO po) throws RemoteException;
	
	public int changePresentList(PresentListPO po) throws RemoteException;
	
	public ArrayList<PresentListPO> shoPL() throws RemoteException;
}
