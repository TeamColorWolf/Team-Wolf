package TeamWolf.TeamWolf.client.BL.saleBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
import TeamWolf.TeamWolf.server.applicationDATA.SaleApplicationDATA;

/**
 * 
 * @author WKS
 *
 */
public class SaleBL{

	private SaleBLAssistant saleAssist;
	private String presentDate;
	private CustomerController cusCtrl;
	private SaleBLController saleCtrtl;
	private SaleApplicationDATAservice saleAppServ;
	private String URL;
	
	public SaleBL(String IP){
		saleAssist = new SaleBLAssistant();
		presentDate = saleAssist.getDate();
//		try {
//			saleAppServ = new SaleApplicationDATA();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		cusCtrl = new CustomerController(IP);
		URL = "rmi://" + IP + "/saleDATAservice";
	}
		
	public int addCustomer(CustomerVO cvo) {
		int judge = saleAssist.canAddCustomer(cvo);
		return cusCtrl.addCustomer(cvo);
	}

	public int delCustomer(String number, String name) {
		CustomerVO cvo = new CustomerVO(number, "", "", name, "", "", "", "", "", "", "", "");
		return cusCtrl.removeCustomer(cvo);
	}

	public int modCustomer(CustomerVO cvo) {
		CustomerVO newCVO = new CustomerVO("", "", "", "", "", "", "", "", "", "", "", "");
		return cusCtrl.update(cvo, newCVO);
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, String number) {		
		return cusCtrl.checkCustomerVO(keyWord, number);
	}

	
	 /**
	  * 创建进货单
	  * @param ivo
	  * @return
	  */
	public int createImport(ImportListVO ivo) {
		//TODO:
		int judge = 0;
		judge = saleAssist.canAddImport(ivo);
		if(judge != 0){
			return judge;
		}
		ImportListPO ipo = new ImportListPO(ivo);
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleAppServ.submitImportList(ipo);
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

	/**
	 * 创建进货退货单
	 * @param irvo
	 * @return
	 */
	public int createImportReject(ImportRejectListVO irvo) {
		int judge = 0;
		judge = saleAssist.canAddImportReject(irvo);
		if(judge != 0){
			return judge;
		}
		ImportRejectListPO irpo = new ImportRejectListPO(irvo);
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			System.out.println("add importRejectList successfully");
			return saleAppServ.submitImportRejectList(irpo);
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

	/**
	 * 创建销售单
	 * @param svo
	 * @return
	 */
	public int createSale(SaleListVO svo) {
		int judge = saleAssist.canAddSale(svo);
		if(judge != 0){
			System.out.println(judge);
			return judge;
		}
		SaleListPO spo = new SaleListPO(svo);
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleAppServ.submitExportList(spo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return 999999;
	}

	/**
	 * 创建销售退货单
	 * @param srvo
	 * @return
	 */
	public int createSaleReject(SaleRejectListVO srvo) {
		int judge = saleAssist.canAddSaleReject(srvo);
		if(judge != 0){
			System.out.println(judge);
			return judge;
		}
		SaleRejectListPO srpo = new SaleRejectListPO(srvo);
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			return saleAppServ.submitExportRejectList(srpo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<String> getStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ApplicationVO> show(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public int submit(ApplicationVO avo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getPresentDate() {
		String date = saleAssist.getDate();
		return date;
	}
	
	public ArrayList<ImportListVO> getImportList() {
		ArrayList<ImportListVO> importList = new ArrayList<ImportListVO>();
		ArrayList<ImportListPO> importListPO = new ArrayList<ImportListPO>();
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			importListPO = saleAppServ.getImportList();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < importListPO.size(); i++) {
			ImportListVO ivo = new ImportListVO(importListPO.get(i));
			importList.add(ivo);
		}
		return importList;
	}

	public ArrayList<ImportRejectListVO> getImportRejectList() {
		ArrayList<ImportRejectListVO> importRejectList = new ArrayList<ImportRejectListVO>();
		ArrayList<ImportRejectListPO> importRejectListPO = new ArrayList<ImportRejectListPO>();
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			importRejectListPO = saleAppServ.getImportRejectList();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < importRejectListPO.size(); i++) {
			ImportRejectListVO irvo = new ImportRejectListVO(importRejectListPO.get(i));
			importRejectList.add(irvo);
		}
		return importRejectList;
	}

	
	public ArrayList<SaleListVO> getSaleList() {
		ArrayList<SaleListVO> saleList = new ArrayList<SaleListVO>();
		ArrayList<SaleListPO> saleListPO = new ArrayList<SaleListPO>();
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			saleListPO = saleAppServ.getSaleList();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < saleListPO.size(); i++) {
			SaleListVO svo = new SaleListVO(saleListPO.get(i));
			saleList.add(svo);
		}
		return saleList;
	}


	public ArrayList<SaleRejectListVO> getSaleRejectList() {
		ArrayList<SaleRejectListVO> saleRejectList = new ArrayList<SaleRejectListVO>();
		ArrayList<SaleRejectListPO> saleRejectListPO = new ArrayList<SaleRejectListPO>();
		try {
			saleAppServ = (SaleApplicationDATAservice) Naming.lookup(URL);
			saleRejectListPO = saleAppServ.getSaleRejectList();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < saleRejectListPO.size(); i++) {
			SaleRejectListVO srvo = new SaleRejectListVO(saleRejectListPO.get(i));
			saleRejectList.add(srvo);
		}
		return saleRejectList;
	}
	
}
