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
			System.out.println("importList " + importList.size());
			System.out.println("importRejectList " + importRejectList.size());
			System.out.println("saleList " + saleList.size());
			System.out.println("importList " + importList.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int submitImportList(ImportListPO ipo) throws RemoteException {
		int judge = 0;
		importList.add(ipo);
		try {
			fo.writeFile(fileName.importListFile, importList);
		} catch (Exception e) {
			e.printStackTrace();
			judge = 9;
		}
		return judge;
	}

	public int submitImportRejectList(ImportRejectListPO irpo)
			throws RemoteException {
		int judge = 0;
		importRejectList.add(irpo);
		try {
			fo.writeFile(fileName.importRejectListFile, importRejectList);
		} catch (IOException e) {
			e.printStackTrace();
			judge = 9;
		}
		return judge;
	}

	public int submitExportList(SaleListPO spo) throws RemoteException {
		int judge = 0;
		saleList.add(spo);
		try {
			System.out.println("add saleList success");
			fo.writeFile(fileName.saleListFile, saleList);
		} catch (IOException e) {
			e.printStackTrace();
			judge = 9;
		}
		return judge;
	}

	public int submitExportRejectList(SaleRejectListPO srpo) throws RemoteException {
		int judge = 0;
		saleRejectList.add(srpo);
		try {
			System.out.println("add saleRejectList success");
			fo.writeFile(fileName.saleRejectListFile, saleRejectList);
		} catch (IOException e) {
			e.printStackTrace();
			judge = 9;
		}
		return judge;
	}

	public int approvalImportList(ImportListPO ipo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < importList.size(); i++) {
			if(ipo.number.equals(importList.get(i).number)){
				importList.remove(i);
				importList.add(ipo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.importListFile, importList);
			judge = 0;
			return judge;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int approvalImportRejectList(ImportRejectListPO irpo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < importRejectList.size(); i++) {
			if(irpo.number.equals(importRejectList.get(i).number)){
				importRejectList.remove(i);
				importRejectList.add(irpo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.importRejectListFile, importRejectList);
			judge = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int approvalExportList(SaleListPO spo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < saleList.size(); i++) {
			if(spo.number.equals(saleList.get(i).number)){
				saleList.remove(i);
				saleList.add(spo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.saleListFile, saleList);
			judge = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int approvalExportRejectList(SaleRejectListPO srpo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < saleRejectList.size(); i++) {
			if(srpo.number.equals(saleRejectList.get(i).number)){
				saleRejectList.remove(i);
				saleRejectList.add(srpo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.saleRejectListFile, saleRejectList);
			judge = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int rejectImportList(ImportListPO ipo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < importList.size(); i++) {
			if(ipo.number.equals(importList.get(i).number)){
				importList.remove(i);
				importList.add(ipo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.importListFile, importList);
			judge = 0;
			return judge;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
	}

	public int rejectImportRejectList(ImportRejectListPO irpo) throws RemoteException {
		int judge = 9;
		for (int i = 0; i < importRejectList.size(); i++) {
			if(irpo.number.equals(importRejectList.get(i).number)){
				importRejectList.remove(i);
				importRejectList.add(irpo);
				break;
			}
		}
		try {
			fo.writeFile(fileName.importRejectListFile, importRejectList);
			judge = 0;
			return judge;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return judge;
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

	public ArrayList<ImportListPO> getImportList() throws RemoteException {
		return importList;
	}

	public ArrayList<ImportRejectListPO> getImportRejectList() throws RemoteException {
		return importRejectList;
	}

	public ArrayList<SaleListPO> getSaleList() throws RemoteException {
		return saleList;
	}

	public ArrayList<SaleRejectListPO> getSaleRejectList() throws RemoteException {
		return saleRejectList;
	}

	
	
}
