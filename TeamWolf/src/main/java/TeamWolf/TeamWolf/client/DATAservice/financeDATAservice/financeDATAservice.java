package TeamWolf.TeamWolf.client.DATAservice.financeDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.financeVO;


public interface financeDATAservice extends Remote{
	public financePO find(financePO po)throws RemoteException;
	public int add(financePO po)throws RemoteException;
	public int delete(financePO po)throws RemoteException;
	public int update(financePO po,financePO newpo)throws RemoteException;
	public ArrayList<financePO>checklist()throws RemoteException;
}
