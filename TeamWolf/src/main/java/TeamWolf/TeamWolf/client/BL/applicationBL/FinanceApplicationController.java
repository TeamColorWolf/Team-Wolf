package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class FinanceApplicationController extends MutiRoleController implements FinanceApplicationService{
	
	public int submitRecieptApplication(RecieptApplicationVO vo){
		return new FinanceSubmit(IP).submitRecieptApplication(vo);
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		return new FinanceSubmit(IP).submitPaymentApplication(vo);
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		return new FinanceSubmit(IP).submitCashApplication(vo);
	}
}
