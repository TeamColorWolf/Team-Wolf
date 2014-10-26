package TeamWolf.TeamWolf.client.DATAservice.logDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserLogDATAservice extends Remote{
	public void addUserLog(String user) throws RemoteException;
	public void removeUserLog(String user) throws RemoteException;
	public void updateUserLog(String user) throws RemoteException;
}
