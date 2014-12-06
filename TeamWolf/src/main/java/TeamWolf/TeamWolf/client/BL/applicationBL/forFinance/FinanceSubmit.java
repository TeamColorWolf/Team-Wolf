package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class FinanceSubmit extends ApplicationBL{
	
	public String URL;
	FinanceApplicationDATAservice fads;
	ArrayList<RecieptApplicationPO> rapoList;
	ArrayList<RecieptApplicationVO> ravoList;
	ArrayList<PaymentApplicationPO> papoList;
	ArrayList<PaymentApplicationVO> pavoList;
	ArrayList<CashApplicationPO> capoList;
	ArrayList<CashApplicationVO> cavoList;
	
	public FinanceSubmit(String IP) {
		super(IP);
		URL = "rmi://" + IP + "/financeApplicationDATAservice";
		rapoList = new ArrayList<RecieptApplicationPO>();
		ravoList = new ArrayList<RecieptApplicationVO>();
		pavoList = new ArrayList<PaymentApplicationVO>();
		papoList = new ArrayList<PaymentApplicationPO>();
		capoList = new ArrayList<CashApplicationPO>();
		cavoList = new ArrayList<CashApplicationVO>();
		// TODO Auto-generated constructor stub
	}
	
	public int submitRecieptApplication(RecieptApplicationVO vo){
		try {
			fads = (FinanceApplicationDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		RecieptApplicationPO po = new RecieptApplicationPO(vo);
		try {
			rapoList.add(po);
			ravoList.add(vo);
			return fads.submitRecieptApplication(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 30001;
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		try {
			fads = (FinanceApplicationDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		PaymentApplicationPO po = new PaymentApplicationPO(vo);
		try {
			papoList.add(po);
			pavoList.add(vo);
			return fads.submitPaymentApplication(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 30001;
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		try {
			fads = (FinanceApplicationDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		CashApplicationPO po = new CashApplicationPO(vo);
		try {
			capoList.add(po);
			cavoList.add(vo);
			return fads.submitCashApplication(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 30001;
	}

}
