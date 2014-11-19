package TeamWolf.TeamWolf.server.saleDATA;


import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.saleDATAservice.SaleDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;


public class SaleDATA extends UnicastRemoteObject implements SaleDATAservice{

	private FileName fileName = new FileName();
	private FileOpr fo = new FileOpr();
	private ArrayList<ImportListPO> appList = null;
	
	public SaleDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		getAppList(fileName.importListFile);
		if(appList == null){
			appList = new ArrayList<ImportListPO>();
		}
	}

	/**
	 * 从文件读取单据列表
	 * @param fName 文件名
	 */
	@SuppressWarnings("unchecked")
	private void getAppList(String fName){
		try {
			appList = (ArrayList<ImportListPO>) fo.readFile(fName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加进货单
	 */
	public int addImport(ImportListPO ipo) throws RemoteException {
		//TODO
		int judge = 0;
//		getAppList(fileName.importListFile);
		appList.add(ipo);
		try {
			fo.writeFile(fileName.importListFile, appList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			judge = 999999;
		}
		return judge;
	}

	/**
	 * 添加进货退货单
	 */
	public int addImportReject(ImportRejectListPO irpo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 添加销售单
	 */
	public int addSale(SaleListPO spo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 添加销售退货单
	 */
	public int addSaleReject(SaleRejectListPO srpo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
