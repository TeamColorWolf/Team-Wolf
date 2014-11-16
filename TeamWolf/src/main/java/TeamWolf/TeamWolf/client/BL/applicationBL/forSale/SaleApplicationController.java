package TeamWolf.TeamWolf.client.BL.applicationBL.forSale;

import TeamWolf.TeamWolf.client.BL.applicationBL.SaleApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleApplicationController  extends MutiRoleController implements SaleApplicationService{
	SaleSubmit submit;
	
	public SaleApplicationController(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	public int submitImportList(ImportListVO vo){
		return submit.submitImportList(vo);
	}
	public int submitImportRejectList(ImportRejectListVO vo){
		return submit.submitImportRejectList(vo);
	}
	public int submitSaleList(SaleListVO vo){
		return submit.submitSaleList(vo);
	}
	public int submitSaleRejectList(SaleRejectListVO vo){
		return submit.submitSaleRejectList(vo);
	}
}
