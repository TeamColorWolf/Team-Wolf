package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
/**
 * 
 * @author WHJ
 *
 */
public interface FinanceApplicationDATAservice extends Remote {
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
	
	public ArrayList<RecieptApplicationPO> getAllRecieptList();
	
	public ArrayList<PaymentApplicationPO> getAllPaymentList();
	
	public ArrayList<CashApplicationPO> getAllCashList();
}
