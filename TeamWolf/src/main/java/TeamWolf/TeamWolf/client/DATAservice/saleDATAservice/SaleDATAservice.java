package TeamWolf.TeamWolf.client.DATAservice.saleDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;

public interface SaleDATAservice extends Remote{

	public int addImport (ImportListPO ipo) throws RemoteException;
	
	public int addImportReject (ImportRejectListPO irpo) throws RemoteException;
	
	public int addSale (SaleListPO spo) throws RemoteException;
	
	public int addSaleReject (SaleRejectListPO srpo) throws RemoteException;
	
}
