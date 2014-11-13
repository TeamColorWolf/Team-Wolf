package TeamWolf.TeamWolf.client.DATAservice.logDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.UserPO;

public interface UserLogDATAservice extends Remote{
	public void addUserLog(UserPO user) throws RemoteException;
	public void removeUserLog(String user) throws RemoteException;
	public void updateUserLog(UserPO user) throws RemoteException;
}
