package TeamWolf.TeamWolf.client.BL.applicationBL.forSale;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerInfo;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerInfoBLservice;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;

public class ImportRejectList extends Application{

	ImportRejectListVO irvo;
	CustomerInfoBLservice custInfoServ;
	SaleApplicationDATAservice saleDataServ;
	GoodTService goodServ;
	String URL;
	
	public ImportRejectList(ImportRejectListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		custInfoServ = new CustomerInfo(IP);
		goodServ = new GoodsBLController(IP);
		
		this.irvo = vo;
		URL = "rmi://" + IP + "/saleApplicationDATAservice";
	}

	@Override
	public ApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int submit() {
		ImportRejectListPO irpo = new ImportRejectListPO(irvo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			System.out.println("add importRejectList successfully");
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

	@Override
	public int approve() {
		// TODO Auto-generated method stub
		irvo.condition = 1;
		custInfoServ.ImportRejectListMod(irvo);
		goodServ.goodsImportReject(irvo);
		ImportRejectListPO ipo = new ImportRejectListPO(irvo);

		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.approvalImportRejectList(ipo);
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
		
		return 9;
	}

	@Override
	public int reject() {
		irvo.condition = -1;
		
		ImportRejectListPO ipo = new ImportRejectListPO(irvo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.rejectImportRejectList(ipo);
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
		return 9;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
