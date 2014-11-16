package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class FinanceApplicationController extends MutiRoleController implements FinanceApplicationService{
	FinanceSubmit submit;
	
	public FinanceApplicationController(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	public int submitRecieptApplication(RecieptApplicationVO vo){
		return submit.submitRecieptApplication(vo);
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		return submit.submitPaymentApplication(vo);
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		return submit.submitCashApplication(vo);
	}
}
