package TeamWolf.TeamWolf.client.DATAservice.saleDATAservice;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;

public interface SaleDATAservice {

	public void addImport (ImportListPO ipo) throws RemoteException;
	
	public void addImportReject (ImportRejectListPO irpo) throws RemoteException;
	
	public void addSale (SaleListPO spo) throws RemoteException;
	
	public void addSaleReject (SaleRejectListPO srpo) throws RemoteException;
	
}
