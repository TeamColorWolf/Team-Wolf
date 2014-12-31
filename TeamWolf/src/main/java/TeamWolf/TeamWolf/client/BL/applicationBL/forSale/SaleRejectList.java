package TeamWolf.TeamWolf.client.BL.applicationBL.forSale;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerInfo;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerInfoBLservice;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleRejectList extends Application {

	SaleRejectListVO srvo;
	CustomerInfoBLservice custInfoServ;
	SaleApplicationDATAservice saleDataServ;
	GoodTService goodServ;
	String URL;
	
	public SaleRejectList(SaleRejectListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		custInfoServ = new CustomerInfo(IP);
		goodServ = new GoodsBLController(IP);
		
		this.srvo = vo;
		URL = "rmi://" + IP + "/saleApplicationDATAservice";
	}

	@Override
	public ApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return srvo;
	}

	@Override
	public ApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new SaleRejectListPO(srvo);
	}

	@Override
	public int submit() {
		SaleRejectListPO srpo = new SaleRejectListPO(srvo);
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
		return ErrorTW.webError;
	}

	@Override
	public int approve() {
		srvo.condition = 1;
		custInfoServ.SaleRejectListMod(srvo);
		goodServ.goodsExportReject(srvo);
		SaleRejectListPO srpo = new SaleRejectListPO(srvo);

		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.approvalExportRejectList(srpo);
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

		return ErrorTW.webError;
	}

	@Override
	public int reject() {
		srvo.condition = -1;
		
		SaleRejectListPO srpo = new SaleRejectListPO(srvo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.rejectExportRejectList(srpo);
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
		return ErrorTW.webError;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
