package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;

public class ForAllUser {
	String URL;
	UserDATAservice service;
	public ForAllUser(String IP){
		
	}
	
	public ArrayList<String> getWorkNumberList() {
		try {
			service = (UserDATAservice) Naming.lookup(URL);
			return service.getUserList();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
