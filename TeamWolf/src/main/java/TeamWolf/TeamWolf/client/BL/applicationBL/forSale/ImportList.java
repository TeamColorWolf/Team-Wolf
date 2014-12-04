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
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.StockBLservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.server.applicationDATA.SaleApplicationDATA;

public class ImportList extends Application{

	ImportListVO ivo;
	CustomerInfoBLservice custInfoServ;
	SaleApplicationDATAservice saleDataServ;
	GoodTService goodServ;
	String URL;
	
	public ImportList(ImportListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		custInfoServ = new CustomerInfo(IP);
		goodServ = new GoodsBLController(IP);
		
		this.ivo = vo;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int approve() {
		ivo.condition = 1;
		custInfoServ.ImportListInfoMod(ivo);
		goodServ.goodsImport(ivo);
		ImportListPO ipo = new ImportListPO(ivo);

		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.approvalImportList(ipo);
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
		ivo.condition = -1;
		
		ImportListPO ipo = new ImportListPO(ivo);
		try {
			saleDataServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleDataServ.rejectImportList(ipo);
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
