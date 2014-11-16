package TeamWolf.TeamWolf.client.BL.saleBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

/**
 * 
 * @author WKS
 *
 */
public class SaleBL{

	private SaleBLAssistant saleAssist;
	private String presentDate;
	private CustomerController cusCtrl;
	
	public SaleBL(String IP){
		saleAssist = new SaleBLAssistant();
		presentDate = saleAssist.getDate();
		cusCtrl = new CustomerController(IP);
	}
		
	public int addCustomer(CustomerVO cvo) {
		int judge = saleAssist.canAddCustomer(cvo);
		return cusCtrl.addCustomer(cvo);
	}

	public int delCustomer(String number, String name) {	
		return cusCtrl.removeCustomer(number, name);
	}

	public int modCustomer(CustomerVO cvo) {
		
		return cusCtrl.update(cvo);
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, int number) {		
		return cusCtrl.checkCustomerVO(keyWord, number);
	}

	public int createImport(ImportListVO ivo) {
		int judge = saleAssist.canAddImport(ivo);
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
