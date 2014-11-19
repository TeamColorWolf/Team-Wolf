package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.UserLogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserType;
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
		if(poList == null){
			return 30000;
		}
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user)){
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
				return 30000;
			}
		}
		return 30002;//该客户名不存在
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		if(poList == null){
			return 30000;
		}
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user.userName)){
				try {
					adm = (UserDATAservice)Naming.lookup(URL);
					return adm.update(new UserPO(user));
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
		}
		return 30002;//该客户名不存在
	}

	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		return this.getAllUserList();
	}
	
	public String creatWorkNumber(UserType type){
		int num = 1;
		String power = new String();
		if(poList != null){
			for(int i = 0; i < poList.size(); i++){
				if(poList.get(i).power == type){
					num++;
				}
			}
		}
		if(type == UserType.库存管理员){
			power = "stock";
		}
		else if(type == UserType.总经理){
			power = "manage";
		}
		else if(type == UserType.系统管理员){
			power = "admin";
		}
		else if(type == UserType.财务人员){
			power = "finance";
		}
		else if(type == UserType.销售人员 || type == UserType.销售经理){
			power = "sale";
		}
		return power + "_" + num;
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
