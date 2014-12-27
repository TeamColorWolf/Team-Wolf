package TeamWolf.TeamWolf.client.BL.applicationBL.forSale;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerInfoBLservice;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
/**
 * Author WHJ
 */
public class SaleSubmit extends ApplicationBL{
	
	SaleApplicationDATAservice saleDataServ;
	String URL;
	
	public SaleSubmit(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		URL = "rmi://" + IP + "/saleApplicationDATAservice";
	}
	public int submitImportList(ImportListVO vo){
		ImportListPO ipo = new ImportListPO(vo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.submitImportList(ipo);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 999999;
	}
	
	public int submitImportRejectList(ImportRejectListVO vo){
		ImportRejectListPO irpo = new ImportRejectListPO(vo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.submitImportRejectList(irpo);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 999999;
	}
	public int submitSaleList(SaleListVO vo){
		SaleListPO spo = new SaleListPO(vo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.submitExportList(spo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return 999999;
	}
	public int submitSaleRejectList(SaleRejectListVO vo){
		SaleRejectListPO srpo = new SaleRejectListPO(vo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.submitExportRejectList(srpo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 999999;
	}
	
}
