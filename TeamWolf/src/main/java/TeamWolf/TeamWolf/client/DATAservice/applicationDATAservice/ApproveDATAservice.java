package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
/**
 * 
 * @author WHJ
 *
 */
public interface ApproveDATAservice extends Remote {
	public ArrayList<ApplicationPO> getUnsetApplicationList() throws RemoteException;
	
	public ArrayList<ApplicationPO> getApprovalApplicationList() throws RemoteException;
	
	public ApplicationPO findApplication(String number) throws RemoteException;
	
	public ArrayList<String> getResult(String workNumber) throws RemoteException;
	
}
