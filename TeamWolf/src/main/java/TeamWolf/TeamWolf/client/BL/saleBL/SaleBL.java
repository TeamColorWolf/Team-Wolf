package TeamWolf.TeamWolf.client.BL.saleBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.DATAservice.saleDATAservice.SaleDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
import TeamWolf.TeamWolf.server.saleDATA.SaleDATA;

/**
 * 
 * @author WKS
 *
 */
public class SaleBL{

	private SaleBLAssistant saleAssist;
	private String presentDate;
	private CustomerController cusCtrl;
	private SaleDATAservice sdservice;
	private String URL;
	
	public SaleBL(String IP){
		saleAssist = new SaleBLAssistant();
		presentDate = saleAssist.getDate();
		cusCtrl = new CustomerController(IP);
		URL = "rmi://" + IP + "/userDATAservice";
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

	public ArrayList<CustomerVO> findCustomer(String keyWord, int number) {		
		return cusCtrl.checkCustomerVO(keyWord, number);
	}

	public int createImport(ImportListVO ivo) {
		int judge = saleAssist.canAddImport(ivo);
		ImportListPO ipo = new ImportListPO(ivo);
		try {
			sdservice = (SaleDATAservice) Naming.lookup(URL);
			return sdservice.addImport(ipo);
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
		return 0;
	}

	public int createImportReject(ImportRejectListVO irvo) {
		int judge = saleAssist.canAddImportReject(irvo);
		// TODO Auto-generated method stub
		return 0;
	}

	public int createSale(SaleListVO svo) {
		int judge = saleAssist.canAddSale(svo);
		// TODO Auto-generated method stub
		return 0;
	}

	public int createSaleReject(SaleRejectListVO srvo) {
		int judge = saleAssist.canAddSaleReject(srvo);
		// TODO Auto-generated method stub
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

}
