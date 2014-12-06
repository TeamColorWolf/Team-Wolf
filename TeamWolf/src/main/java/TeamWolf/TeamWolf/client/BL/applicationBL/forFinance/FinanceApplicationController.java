package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class FinanceApplicationController extends MutiRoleController implements FinanceApplicationService{
	FinanceSubmit submit;
	
	public FinanceApplicationController(String IP) {
		super(IP);
		submit = new FinanceSubmit(IP);
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

	public ArrayList<RecieptApplicationPO> getRecieptPO() {
		return submit.getRecieptPO();
	}

	public ArrayList<RecieptApplicationVO> getRecieptVO() {
		return submit.getRecieptVO();
	}

	public ArrayList<CashApplicationPO> getCashPO() {
        return submit.getCashPO();		
	}

	public ArrayList<CashApplicationVO> getCashVO() {
		return  submit.getCashVO();
	}

	public ArrayList<PaymentApplicationPO> getPaymentPO() {
		return submit.getPaymentPO();
	}

	public ArrayList<PaymentApplicationVO> getPaymentVO() {
		return submit.getPaymentVO();
	}
}
