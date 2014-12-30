package TeamWolf.TeamWolf.client.DATAservice.logDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogDATAservice extends Remote{
	public ArrayList<String> readLog() throws RemoteException;
}
