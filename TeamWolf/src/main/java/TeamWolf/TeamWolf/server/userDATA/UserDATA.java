package TeamWolf.TeamWolf.server.userDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 30001;
		}
		return 0;
	}

	public int removeUser(String user) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).userName.equals(user)){
				list.remove(i);
				try {
					FileOpr.writeFile(FileName.userFile, list);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 30002;
				}
			}
		}
		return 0;
	}

	public int update(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UserPO> checkPO() throws RemoteException {
		// TODO Auto-generated method stub
		return list;
	}

	public UserPO find(String user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getUserList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
