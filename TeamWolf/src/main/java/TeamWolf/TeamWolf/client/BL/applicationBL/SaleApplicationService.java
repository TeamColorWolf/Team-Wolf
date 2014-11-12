package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public interface SaleApplicationService extends MutiRoleService{
	public int submitImportList(ImportListVO vo);
	public int submitImportRejectList(ImportRejectListVO vo);
	public int submitSaleList(SaleListVO vo);
	public int submitSaleRejectList(SaleRejectListVO vo);
}