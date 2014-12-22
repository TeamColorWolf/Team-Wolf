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
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;

public class SaleList extends Application {
	
	SaleListVO svo;
	CustomerInfoBLservice custInfoServ;
	SaleApplicationDATAservice saleDataServ;
	GoodTService goodServ;
	String URL;
	
	public SaleList(SaleListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		custInfoServ = new CustomerInfo(IP);
		goodServ = new GoodsBLController(IP);
		
		this.svo = vo;
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
		SaleListPO spo = new SaleListPO(svo);
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

	@Override
	public int approve() {
		svo.condition = 1;
		custInfoServ.SaleListMod(svo);
		goodServ.goodsExport(svo);
		SaleListPO spo = new SaleListPO(svo);

		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.approvalExportList(spo);
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
		svo.condition = -1;
		
		SaleListPO spo = new SaleListPO(svo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.rejectExportList(spo);
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
