package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public interface FinanceApplicationService extends MutiRoleService{
	public int submitRecieptApplication(RecieptApplicationVO vo);
	public int submitPaymentApplication(PaymentApplicationVO vo);
	public int submitCashApplication(CashApplicationVO vo);
}
