package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
/**
 * Author WHJ
 */
public interface FinanceApplicationDATAservice {
	public int submitRecieptApplication(RecieptApplicationPO po) throws RemoteException;
	
	public int submitPaymentApplication(PaymentApplicationPO po) throws RemoteException;
	
	public int submitCashApplication(CashApplicationPO po) throws RemoteException;
	
	public int approvalRecieptApplication(RecieptApplicationPO po) throws RemoteException;
	
	public int approvalPaymentApplication(PaymentApplicationPO po) throws RemoteException;
	
	public int approvalCashApplication(CashApplicationPO po) throws RemoteException;
	
	public int rejectRecieptApplication(RecieptApplicationPO po) throws RemoteException;
	
	public int rejectPaymentApplication(PaymentApplicationPO po) throws RemoteException;
	
	public int rejectCashApplication(CashApplicationPO po) throws RemoteException;
	
	public int changeRecieptApplication(RecieptApplicationPO po) throws RemoteException;
	
	public int changePaymentApplication(PaymentApplicationPO po) throws RemoteException;
	
	public int changeCashApplication(CashApplicationPO po) throws RemoteException;
}
