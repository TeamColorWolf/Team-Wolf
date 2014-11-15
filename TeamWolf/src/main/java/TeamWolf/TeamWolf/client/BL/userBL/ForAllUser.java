package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserVO;
/**
 * 
 * @author WHJ
 *
 */
public class ForAllUser {
	String URL;
	UserDATAservice service;
	ArrayList<UserPO> poList;
	ArrayList<UserVO> voList;
	ArrayList<String> strList;
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
		return strList;
	}
	
	public ArrayList<UserVO> getAllUserList(){
		try {
			service = (UserDATAservice) Naming.lookup(URL);
			poList = service.checkPO();
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
		return voList;
	}
	
}
