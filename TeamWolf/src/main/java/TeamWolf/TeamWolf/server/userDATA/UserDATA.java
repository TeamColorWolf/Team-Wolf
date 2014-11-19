package TeamWolf.TeamWolf.server.userDATA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.server.FileName;

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
		int error = -1;
		list.add(user);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileName.userFile, true));
			oos.writeObject(user);
			oos.close();
			System.out.println("add " + user.userName);
			error = 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			error = 30001;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			error = 30001;
		}
		return error;
	}

	public int removeUser(String user) throws RemoteException {
		// TODO Auto-generated method stub
		int error = -1;
		ArrayList<UserPO> list = this.checkPO();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).userName.equals(user)){
				list.remove(i);
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileName.userFile));
					for(int j = 0; j < list.size(); j++){
						oos.writeObject(list.get(j));
					}
					oos.close();
					System.out.println("remove " + user);
					error = 0;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					error = 30002;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					error = 30002;
				}
			}
		}
		return error;
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
	
	private void getList(){
		try {
			list = new ArrayList<UserPO>();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FileName.userFile));
			UserPO po;
			while((po = (UserPO)ois.readObject())!=null){
				list.add(po);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
	}

}
