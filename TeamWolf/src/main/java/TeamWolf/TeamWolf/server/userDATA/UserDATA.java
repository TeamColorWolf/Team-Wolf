package TeamWolf.TeamWolf.server.userDATA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;

public class UserDATA extends UnicastRemoteObject implements UserDATAservice{

	public UserDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			FileOutputStream userFile = new FileOutputStream("user.tw");
			ObjectOutputStream oos = new ObjectOutputStream(userFile);
			oos.writeObject(user);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int removeUser(String user) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UserPO> checkPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO find(String user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getUserList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
