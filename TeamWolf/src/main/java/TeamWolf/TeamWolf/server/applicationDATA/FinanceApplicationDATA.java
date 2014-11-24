package TeamWolf.TeamWolf.server.applicationDATA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;

public class FinanceApplicationDATA extends UnicastRemoteObject implements FinanceApplicationDATAservice{

	protected FinanceApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int submitRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int submitCashApplication(CashApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalCashApplication(CashApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectCashApplication(CashApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changePaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeCashApplication(CashApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
