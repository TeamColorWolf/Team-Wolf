package TeamWolf.TeamWolf.client.BL.saleBL;

import java.util.Date;

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
public class SaleBLAssistant {
	
	public int canAddCustomer (CustomerVO cvo){
		return 0;
	}
	
	public boolean canDelCustomer (CustomerVO cvo){
		return true;
	}
	
	public int canAddImport (ImportListVO ivo){
		return 0;
	}
	
	public int canAddImportReject (ImportRejectListVO irvo){
		return 0;
	}
	
	public int canAddSale (SaleListVO svo){
		return 0;
	}
	
	public int canAddSaleReject (SaleRejectListVO srvo){
		return 0;
	}
	
	public Date getDate (){
		return null;
	}
	
}
