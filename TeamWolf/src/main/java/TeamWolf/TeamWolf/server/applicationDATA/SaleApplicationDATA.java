package TeamWolf.TeamWolf.server.applicationDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class SaleApplicationDATA extends UnicastRemoteObject implements SaleApplicationDATAservice{

	private FileName fileName;
	private FileOpr fo;
	private ArrayList<ImportListPO> importList = null;
	private ArrayList<ImportRejectListPO> importRejectList = null;
	private ArrayList<SaleListPO> saleList = null;
	private ArrayList<SaleRejectListPO> saleRejectList = null;
	
	public SaleApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		getAppList();
		if(importList == null){
			importList = new ArrayList<ImportListPO>();
		}
		if(importRejectList == null){
			importRejectList = new ArrayList<ImportRejectListPO>();
		}
		 if(saleList == null){
			 saleList = new ArrayList<SaleListPO>();
		 }
		 if(saleRejectList == null){
			 saleRejectList = new ArrayList<SaleRejectListPO>();
		 }
	}

	/**
	 * 从文件读取单据列表
	 * @param fName 文件名
	 */
	@SuppressWarnings("unchecked")
	private void getAppList(){
		try {
			importList = (ArrayList<ImportListPO>) fo.readFile(FileName.importListFile);
			importRejectList = (ArrayList<ImportRejectListPO>) fo.readFile(FileName.importRejectListFile);
			saleList = (ArrayList<SaleListPO>) fo.readFile(FileName.saleListFile);
			saleRejectList = (ArrayList<SaleRejectListPO>) fo.readFile(FileName.saleRejectListFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int submitImportList(ImportListPO ipo) throws RemoteException {
		//TODO
		int judge = 0;
		importList.add(ipo);
		try {
			fo.writeFile(fileName.importListFile, importList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			judge = 999999;
		}
		return judge;
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

	public ArrayList<ImportListPO> getImportList() {
		return importList;
	}

	public ArrayList<ImportRejectListPO> getImportRejectList() {
		return importRejectList;
	}

	public ArrayList<SaleListPO> getSaleList() {
		return saleList;
	}

	public ArrayList<SaleRejectListPO> getSaleRejectList() {
		return saleRejectList;
	}

	
	
}
