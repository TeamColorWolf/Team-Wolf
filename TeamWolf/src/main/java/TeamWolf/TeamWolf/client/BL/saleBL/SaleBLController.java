package TeamWolf.TeamWolf.client.BL.saleBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
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
public class SaleBLController implements SaleBLservice{

	SaleBL sale;
	
	public SaleBLController() {
		sale = new SaleBL();
	}
	
	public int addCustomer(CustomerVO cvo) {
		return sale.addCustomer(cvo);
	}

	public int delCustomer(String name, String num) {
		return sale.delCustomer(name, num);
	}

	public int modCustomer(CustomerVO cvo) {
		return sale.modCustomer(cvo);
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, String number) {
		return sale.findCustomer(keyWord, number);
	}

	public int createImport(ImportListVO ivo) {
		return sale.createImport(ivo);
	}

	public int createImportReject(ImportRejectListVO irvo) {
		return sale.createImportReject(irvo);
	}

	public int createSale(SaleListVO svo) {
		return sale.createSale(svo);
	}

	public int createSaleReject(SaleRejectListVO srvo) {
		return sale.createSaleReject(srvo);
	}

	public ArrayList<String> getStock() {
		return sale.getStock();
	}

	public ArrayList<ApplicationVO> show(String num) {
		return sale.show(num);
	}

	public int submit(ApplicationVO avo) {
		return sale.submit(avo);
	}
	
}
