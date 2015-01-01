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
	}

	public ArrayList<ApplicationPO> getUnsetApplicationList() throws RemoteException {
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
		ArrayList<ApplicationPO> templist = this.allApplication();
		for(int i = 0; i < templist.size(); i++){
			if(templist.get(i).number.equals(number)){
				return templist.get(i);
			}
		}
		return null;
	}

	public ArrayList<String> getResult(String workNumber) throws RemoteException {//TODO 待实现
		return null;
	}
	
	private ArrayList<ApplicationPO> allApplication(){
		ArrayList<ApplicationPO> list = new ArrayList<ApplicationPO>();
		ArrayList<ApplicationPO> tempList;
		tempList = this.getAllApplicationFromFile(FileName.importListFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.importRejectListFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.saleListFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.saleRejectListFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.increaseToMatchFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.decreaseToMatchFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.recieptFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.paymentFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.cashFile);
		arrayListCat(list, tempList);
		tempList = this.getAllApplicationFromFile(FileName.presnetListFile);
		arrayListCat(list, tempList);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<ApplicationPO> getAllApplicationFromFile(String fileName){
		ArrayList<ApplicationPO> list = null;
		try {
			list = (ArrayList<ApplicationPO>)FileOpr.readFile(fileName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
