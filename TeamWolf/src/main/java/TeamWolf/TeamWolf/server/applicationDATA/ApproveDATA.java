package TeamWolf.TeamWolf.server.applicationDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

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
	
	private ArrayList<ApplicationPO> allApplication(){
		ArrayList<ApplicationPO> list = new ArrayList<ApplicationPO>();
		ArrayList<ApplicationPO> tempList;
		tempList = this.getAllApplicationFromFile(FileName.importListFile);
		for(int i = 0; i < tempList.size(); i++){
			list.add(tempList.get(i));
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<ApplicationPO> getAllApplicationFromFile(String fileName){
		ArrayList<ApplicationPO> list = null;
		try {
			list = (ArrayList<ApplicationPO>)FileOpr.readFile(fileName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list == null){
			list = new ArrayList<ApplicationPO>();
		}
		return list;
	}

}
