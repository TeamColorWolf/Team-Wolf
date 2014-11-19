 package TeamWolf.TeamWolf.server.userDATA;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.LoginDATAservice;
import TeamWolf.TeamWolf.client.po.LoginUserPO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class LoginDATA extends UnicastRemoteObject implements LoginDATAservice{

	public LoginDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public UserPO loginController(LoginUserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ArrayList<UserPO> list = (ArrayList<UserPO>)FileOpr.readFile(FileName.userFile);
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).userName.equals(user.userName) && list.get(i).password.equals(user.password)){
					return list.get(i);
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
