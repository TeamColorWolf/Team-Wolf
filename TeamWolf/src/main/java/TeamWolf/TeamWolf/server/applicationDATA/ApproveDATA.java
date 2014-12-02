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
	public ApproveDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ApplicationPO> getUnsetApplicationList() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ApplicationPO> templist = this.allApplication();
		ArrayList<ApplicationPO> list = new ArrayList<ApplicationPO>();
		for(int i = 0; i < templist.size(); i++){
			if(templist.get(i).condition == 0){
				list.add(templist.get(i));
			}
		}
		return list;
	}

	public ArrayList<ApplicationPO> getApprovalApplicationList() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ApplicationPO> templist = this.allApplication();
		ArrayList<ApplicationPO> list = new ArrayList<ApplicationPO>();
		for(int i = 0; i < templist.size(); i++){
			if(templist.get(i).condition == 1){
				list.add(templist.get(i));
			}
		}
		return list;
	}

	public ApplicationPO findApplication(String number) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ApplicationPO> templist = this.allApplication();
		for(int i = 0; i < templist.size(); i++){
			if(templist.get(i).number.equals(number)){
				return templist.get(i);
			}
		}
		return null;
	}

	public ArrayList<String> getResult(String workNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ArrayList<ApplicationPO> allApplication(){
		ArrayList<ApplicationPO> list = new ArrayList<ApplicationPO>();
		ArrayList<ApplicationPO> tempList;
		tempList = this.getAllApplicationFromFile(FileName.importListFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.importRejectListFile);
		arrayListCat(list, tempList);
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
	
	private void arrayListCat(ArrayList<ApplicationPO> to, ArrayList<ApplicationPO> from){
		if(from != null){
			for(int i = 0; i < from.size(); i++){
				to.add(from.get(i));
			}
		}
	}

}
