package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.*;
import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.UserLogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.AdminDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Admin implements AdminBLservice{
	public String URL = null;
	public UserVO nowUser = null;
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		AdminDATAservice add;
		UserLogDATAservice log;
		try {
			add = (AdminDATAservice)Naming.lookup(URL);
			log = (UserLogDATAservice)Naming.lookup(URL);
			try {
				add.addUser(userPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}

	public int removeUser(String user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UserVO> checkVO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String creatWorkNumber(){
		return null;
	}

}
