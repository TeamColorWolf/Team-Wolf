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
		// TODO Auto-generated method stub
		return 0;
	}

	public int delCustomer(String name, String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modCustomer(CustomerVO cvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createImport(ImportListVO ivo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createImportReject(ImportRejectListVO irvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createSale(SaleListVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createSaleReject(SaleRejectListVO srvo) {
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
