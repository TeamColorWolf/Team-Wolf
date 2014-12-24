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


//Controller，用于管理账户类单据的提交，驳回，通过

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

	public ArrayList<RecieptApplicationVO> getRecieptVO() {
		// TODO 自动生成的方法存根
		return submit.getRecieptVO();
	}

	public ArrayList<CashApplicationVO> getCashVO() {
		// TODO 自动生成的方法存根
		return submit.getCashVO();
	}

	public ArrayList<PaymentApplicationVO> getPaymentVO() {
		// TODO 自动生成的方法存根
		return submit.getPaymentVO();
	}


}
