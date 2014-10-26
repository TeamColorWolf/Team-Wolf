package TeamWolf.TeamWolf.client.DATAservice.financeDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.FinancePO;


public interface financeDATAservice extends Remote{
	public FinancePO find(String name)throws RemoteException;
	public int insert(ArrayList<FinancePO> po)throws RemoteException;
	public int delete(FinancePO po)throws RemoteException;
	public int update(FinancePO prepo,FinancePO newpo)throws RemoteException;
	
}
