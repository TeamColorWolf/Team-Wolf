package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
/**
 * Author WHJ
 */
public class FinanceSubmit extends ApplicationBL{
	private FinanceApplicationDATAservice finance;
	
	public int submitRecieptApplication(RecieptApplicationVO vo){
		try {
			finance = (FinanceApplicationDATAservice)Naming.lookup(URL);
			RecieptApplicationPO po = null;
			return finance.submitRecieptApplication(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		try {
			finance = (FinanceApplicationDATAservice)Naming.lookup(URL);
			PaymentApplicationPO po = null;
			return finance.submitPaymentApplication(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		try {
			finance = (FinanceApplicationDATAservice)Naming.lookup(URL);
			CashApplicationPO po = null;
			return finance.submitCashApplication(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
