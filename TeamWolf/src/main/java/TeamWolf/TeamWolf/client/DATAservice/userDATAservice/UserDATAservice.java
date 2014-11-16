package TeamWolf.TeamWolf.client.DATAservice.userDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.*;
/**
 * 
 * @author WHJ
 *
 */
public interface UserDATAservice extends Remote{
	public int addUser(UserPO user) throws RemoteException;
	public int removeUser(String user) throws RemoteException;
	public int update(UserPO user) throws RemoteException;
	public ArrayList<UserPO> checkPO() throws RemoteException;
	public UserPO find(String user) throws RemoteException;
	public ArrayList<String> getUserList() throws RemoteException;
}
