package TeamWolf.TeamWolf.server.userDATA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.LoginDATAservice;
import TeamWolf.TeamWolf.client.po.LoginUserPO;
import TeamWolf.TeamWolf.client.po.UserPO;

public class LoginDATA extends UnicastRemoteObject implements LoginDATAservice{

	public LoginDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPO loginController(LoginUserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			FileInputStream userFile = new FileInputStream("user.tw");
			ObjectInputStream ois = new ObjectInputStream(userFile);
			UserPO po;
			while((po = (UserPO)ois.readObject())!=null){
				if(po.userName.equals(user.userName) && po.password.equals(user.password)){
					return po;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File user.tw not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		}
		return new UserPO(false);
	}
}
