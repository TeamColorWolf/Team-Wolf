package TeamWolf.TeamWolf.client.DATAservice.financeDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.INIPO;

public interface INIDATAservice extends Remote{
    public int insert(INIPO po)throws RemoteException;
    public INIPO find(int number)throws RemoteException;
    public ArrayList<INIPO> getINIList()throws RemoteException;
}
