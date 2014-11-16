package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public interface CustomerInfoBLservice {
	public int ImportListInfoMod(ImportListVO vo);
	public int ImportRejectListMod(ImportRejectListVO vo);
	public int SaleListMod(SaleListVO vo);
	public int SaleRejectListMod(SaleRejectListVO vo);
	public int RecieptListMod(RecieptApplicationVO vo);
	public int PaymentListMod(PaymentApplicationVO vo);
	public int CashListMod(CashApplicationVO vo);
}
