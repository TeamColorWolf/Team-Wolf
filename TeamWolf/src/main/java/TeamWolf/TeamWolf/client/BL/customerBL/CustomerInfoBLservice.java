package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.FinancePO;
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
	public int ImportListInfoMod(ImportListVO vo,CustomerVO cvo);
	public int ImportRejectListMod(ImportRejectListVO vo,CustomerVO cvo);
	public int SaleListMod(SaleListVO vo,CustomerVO cvo);
	public int SaleRejectListMod(SaleRejectListVO vo,CustomerVO cvo);
	public int RecieptListMod(RecieptApplicationVO vo,CustomerVO cvo);
	public int PaymentListMod(PaymentApplicationVO vo,CustomerVO cvo);
	public int CashListMod(CashApplicationVO vo,CustomerVO cvo);
	public CustomerPO getInfo();
}
