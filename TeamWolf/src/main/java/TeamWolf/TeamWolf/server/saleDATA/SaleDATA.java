package TeamWolf.TeamWolf.server.saleDATA;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TeamWolf.TeamWolf.client.DATAservice.saleDATAservice.SaleDATAservice;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;


public class SaleDATA extends UnicastRemoteObject implements SaleDATAservice{

	protected SaleDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 添加进货单
	 */
	public void addImport(ImportListPO ipo) throws RemoteException {
		//TODO 

	}

	/**
	 * 添加进货退货单
	 */
	public void addImportReject(ImportRejectListPO irpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 添加销售单
	 */
	public void addSale(SaleListPO spo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 添加销售退货单
	 */
	public void addSaleReject(SaleRejectListPO srpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
