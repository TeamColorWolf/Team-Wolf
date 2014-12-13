package TeamWolf.TeamWolf.server.userDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class UserDATA extends UnicastRemoteObject implements UserDATAservice{
	static ArrayList<UserPO> list = null;
	public UserDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.getList();
		if(list == null){
			list = new ArrayList<UserPO>();
		}
	}

	public int addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		list.add(user);
		try {
			FileOpr.writeFile(FileName.userFile, list);
			System.out.println("add " + user.userName + " password:" + user.password);
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.userServerError;
		}
	}

	public int removeUser(String user) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).userName.equals(user)){
				list.remove(i);
				try {
					FileOpr.writeFile(FileName.userFile, list);
					System.out.println("remove " + user);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ErrorTW.userServerError;
				}
			}
		}
		return ErrorTW.userNameNotExist;
	}

	public int update(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).userName.equals(user.userName)){
				list.get(i).password = user.password;
				list.get(i).workID = user.workID;
				list.get(i).power = user.power;
				try {
					FileOpr.writeFile(FileName.userFile, list);
					System.out.println("update " + user.userName + " password:" + user.password + " workID:" + user.workID + "power" + user.power);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ErrorTW.userServerError;
				}
			}
		}
		return ErrorTW.userNameNotExist;
	}

	public ArrayList<UserPO> checkPO() throws RemoteException {
		// TODO Auto-generated method stub
		return list;
	}

	public UserPO find(String user) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equals(user)){
				return list.get(i);
			}
		}
		return new UserPO(false);
	}

	public ArrayList<String> getUserList() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> workIDlist = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++){
			workIDlist.add(list.get(i).workID);
		}
		return workIDlist;
	}
	
	@SuppressWarnings("unchecked")
	private void getList(){
		try {
			list = (ArrayList<UserPO>) FileOpr.readFile(FileName.userFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
