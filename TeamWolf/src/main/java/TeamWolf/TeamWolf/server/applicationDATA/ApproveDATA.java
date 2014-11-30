package TeamWolf.TeamWolf.server.applicationDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;

public class ApproveDATA extends UnicastRemoteObject implements ApproveDATAservice{

	protected ApproveDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ApplicationPO> getUnsetApplicationList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ApplicationPO> getApprovalApplicationList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationPO findApplication(String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getResult(String workNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int approveOver(ArrayList<ApplicationPO> list) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
