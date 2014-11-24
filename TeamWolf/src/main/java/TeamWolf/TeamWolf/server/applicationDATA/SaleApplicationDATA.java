package TeamWolf.TeamWolf.server.applicationDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;

public class SaleApplicationDATA extends UnicastRemoteObject implements SaleApplicationDATAservice{

	protected SaleApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int submitImportList(ImportListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitImportRejectList(ImportRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitExportList(SaleListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitExportRejectList(SaleRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalImportList(ImportListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalImportRejectList(ImportRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalExportList(SaleListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalExportRejectList(SaleRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectImportList(ImportListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectImportRejectList(ImportRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectExportList(SaleListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectExportRejectList(SaleRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeImportList(ImportListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeImportRejectList(ImportRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeExportList(SaleListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeExportRejectList(SaleRejectListPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
