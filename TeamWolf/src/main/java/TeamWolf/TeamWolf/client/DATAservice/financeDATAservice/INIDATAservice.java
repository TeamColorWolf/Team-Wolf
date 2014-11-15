package TeamWolf.TeamWolf.client.DATAservice.financeDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.INIPO;

public interface INIDATAservice extends Remote{
    public int insert(INIPO po)throws RemoteException;
    public int delete(INIPO po)throws RemoteException;
}
