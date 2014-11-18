package TeamWolf.TeamWolf.client.BL.userBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.LoginDATAservice;
import TeamWolf.TeamWolf.client.po.LoginUserPO;
import TeamWolf.TeamWolf.client.vo.*;
/**
 * 
 * @author WHJ
 *
 */
public class Login {
	LoginUserPO userPO;
	String URL;
	LoginDATAservice login;
	
	public Login(String IP){
		URL = "rmi://" + IP + "/loginDATAservice";
	}
	
	public UserVO login(LoginUserVO user) {
		// TODO Auto-generated method stub
		try {
			login = (LoginDATAservice) Naming.lookup(URL);
			return new UserVO(login.loginController(new LoginUserPO(user)));
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
		return new UserVO(false);
	}
	
}
