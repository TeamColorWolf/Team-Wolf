package TeamWolf.TeamWolf.client.DATAservice.userDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.*;
/**
 * 
 * @author WHJ
 *
 */
public interface LoginDATAservice extends Remote{
	public UserPO loginController(LoginUserPO user) throws RemoteException;
}
