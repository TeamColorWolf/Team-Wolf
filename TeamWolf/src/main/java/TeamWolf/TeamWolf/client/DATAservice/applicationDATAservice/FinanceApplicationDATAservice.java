package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;

public interface FinanceApplicationDATAservice {
	public int submitRecieptApplication(RecieptApplicationPO po);
	
	public int submitPaymentApplication(PaymentApplicationPO po);
	
	public int submitCashApplication(CashApplicationPO po);
	
	public int approvalRecieptApplication(RecieptApplicationPO po);
	
	public int approvalPaymentApplication(PaymentApplicationPO po);
	
	public int approvalCashApplication(CashApplicationPO po);
}
