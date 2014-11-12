package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleApplicationController  extends MutiRoleController implements SaleApplicationService{
	
	public int submitImportList(ImportListVO vo){
		return new SaleSubmit(IP).submitImportList(vo);
	}
	public int submitImportRejectList(ImportRejectListVO vo){
		return new SaleSubmit(IP).submitImportRejectList(vo);
	}
	public int submitSaleList(SaleListVO vo){
		return new SaleSubmit(IP).submitSaleList(vo);
	}
	public int submitSaleRejectList(SaleRejectListVO vo){
		return new SaleSubmit(IP).submitSaleRejectList(vo);
	}
}
