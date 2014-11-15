package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
/**
 * Author WHJ
 */
public class FinanceSubmit extends ApplicationBL{
	
	public FinanceSubmit(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}
	
	public int submitRecieptApplication(RecieptApplicationVO vo){
		return 0;
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		return 0;
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		return 0;
	}
}
