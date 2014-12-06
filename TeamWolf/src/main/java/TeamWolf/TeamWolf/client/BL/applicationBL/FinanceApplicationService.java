package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public interface FinanceApplicationService extends MutiRoleService{
	public int submitRecieptApplication(RecieptApplicationVO vo);
	public int submitPaymentApplication(PaymentApplicationVO vo);
	public int submitCashApplication(CashApplicationVO vo);
	public ArrayList<RecieptApplicationPO> getRecieptPO();
	public ArrayList<RecieptApplicationVO> getRecieptVO();
	public ArrayList<CashApplicationPO> getCashPO();
	public ArrayList<CashApplicationVO> getCashVO();
	public ArrayList<PaymentApplicationPO> getPaymentPO();
	public ArrayList<PaymentApplicationVO> getPaymentVO();
}
