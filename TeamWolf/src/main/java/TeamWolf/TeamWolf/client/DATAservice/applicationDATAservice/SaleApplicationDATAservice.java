package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
/**
 * Author WHJ
 */
public interface SaleApplicationDATAservice extends Remote {
	public int submitImportList(ImportListPO po) throws RemoteException;
	
	public int submitImportRejectList(ImportRejectListPO po) throws RemoteException;
	
	public int submitExportList(SaleListPO po) throws RemoteException;
	
	public int submitExportRejectList(SaleRejectListPO po) throws RemoteException;
	
	public int approvalImportList(ImportListPO po) throws RemoteException;
	
	public int approvalImportRejectList(ImportRejectListPO po) throws RemoteException;
	
	public int approvalExportList(SaleListPO po) throws RemoteException;
	
	public int approvalExportRejectList(SaleRejectListPO po) throws RemoteException;
	
	public int rejectImportList(ImportListPO po) throws RemoteException;
	
	public int rejectImportRejectList(ImportRejectListPO po) throws RemoteException;
	
	public int rejectExportList(SaleListPO po) throws RemoteException;
	
	public int rejectExportRejectList(SaleRejectListPO po) throws RemoteException;
}
