package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
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
		this.getAllUserList();
	}
	
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		if(poList == null)
			return ErrorTW.webError;//网络连接故障
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user.userName)){
				return ErrorTW.userNameExist;//该客户名已存在
			}
		}
		UserPO po = new UserPO(user);
		try {
			adm = (UserDATAservice)Naming.lookup(URL);
			int success = adm.addUser(po);
			if(success == 0){
				poList.add(po);
				voList.add(user);
			}
			return success;
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
		return ErrorTW.webError;
	}

	public int removeUser(String user) {
		// TODO Auto-generated method stub
		if(poList == null){
			return ErrorTW.webError;
		}
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user)){
				try {
					adm = (UserDATAservice)Naming.lookup(URL);
					int success = adm.removeUser(user);
					if(success == 0){
						getpoList();
						voList = null;
						voList = this.getAllUserList();
					}
					return success;
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
				return ErrorTW.webError;
			}
		}
		return ErrorTW.userNameNotExist;//该客户名不存在
	}

	public int update(UserVO user) {
		// TODO Auto-generated method stub
		if(poList == null){
			return ErrorTW.webError;
		}
		for(int i = 0; i < poList.size(); i++){
			if(poList.get(i).userName.equals(user.userName)){
				try {
					adm = (UserDATAservice)Naming.lookup(URL);
					int success = adm.update(new UserPO(user));
					if(success == 0){
						this.getpoList();
						voList = null;
						voList = this.getAllUserList();
					}
					return success;
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
				return ErrorTW.webError;
			}
		}
		return ErrorTW.userNameNotExist;//该客户名不存在
	}

	public ArrayList<UserVO> checkUserVO() {
		// TODO Auto-generated method stub
		return this.getAllUserList();
	}
	
	public String creatWorkNumber(UserType type){
		String power = new String();
		int max = 0;
		if(poList != null){
			for(int i = 0; i < poList.size(); i++){
				if(poList.get(i).power == type){
					int t = Integer.parseInt(poList.get(i).workID.split("_")[1]);
					if(t > max) max = t;
				}
			}
		}
		max++;
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
		else if(type == UserType.销售人员){
			power = "sale";
		}
		else if(type == UserType.销售经理){
			power = "saleManager";
		}
		return power + "_" + max;
	}
	
	public UserVO findUser(String user){
		if(voList == null){
			voList = this.getAllUserList();
		}
		for(int i = 0; i < voList.size(); i++){
			if(voList.get(i).userName.equals(user)){
				return voList.get(i);
			}
		}
		return new UserVO(false);
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
