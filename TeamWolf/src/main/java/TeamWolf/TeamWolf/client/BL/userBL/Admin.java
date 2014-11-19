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
	public String URL;
	UserDATAservice adm;
	UserLogDATAservice log;
	
	ArrayList<UserPO> poList;
	ArrayList<UserVO> voList;
	ArrayList<String> strList;
	
	public Admin(String IP){
		URL = "rmi://" + IP + "/userDATAservice";
		this.getpoList();
	}
	
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		if(poList == null)
			return 30000;//网络连接故障
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user.userName)){
				return 30001;//该客户名已存在
			}
		}
		UserPO po = new UserPO(user);
		try {
			adm = (UserDATAservice)Naming.lookup(URL);
			return adm.addUser(po);
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
		return 30000;
	}

	public int removeUser(String user) {
		// TODO Auto-generated method stub
		try {
			adm = (UserDATAservice)Naming.lookup(URL);
			return adm.removeUser(user);
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
		return 30002;
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		return this.getAllUserList();
	}
	
	public String creatWorkNumber(String power){
		return null;
	}
	
	public ArrayList<String> getWorkNumberList() {
		if(strList == null){
			try {
				adm = (UserDATAservice) Naming.lookup(URL);
				strList = adm.getUserList();
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
		}
		return strList;
	}
	
	public ArrayList<UserVO> getAllUserList(){
		if(voList == null){
			try {
				adm = (UserDATAservice) Naming.lookup(URL);
				poList = adm.checkPO();
				voList = new ArrayList<UserVO>();
				for(int i = 0; i < poList.size(); i++){
					UserVO vo = new UserVO(poList.get(i));
					voList.add(vo);
				}
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
		}
		return voList;
	}
	
	private void getpoList(){
		try {
			adm = (UserDATAservice) Naming.lookup(URL);
			poList = adm.checkPO();
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
	}

}
