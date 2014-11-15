package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.UserLogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class Admin {
	public String URL = null;
	public UserVO nowUser = null;
	UserDATAservice adm;
	UserLogDATAservice log;
	
	public Admin(String IP){
		
	}
	
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		UserPO po = new UserPO(user);
		try {
			adm = (UserDATAservice)Naming.lookup(URL);
			log = (UserLogDATAservice)Naming.lookup(URL);
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
		try {
			log.addUserLog(po);
			return adm.addUser(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 30001;
	}

	public int removeUser(String user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String creatWorkNumber(String power){
		return null;
	}

}
