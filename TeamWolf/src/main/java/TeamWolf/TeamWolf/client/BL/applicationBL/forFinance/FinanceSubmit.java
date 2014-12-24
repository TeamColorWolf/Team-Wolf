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
//该类用于处理账户类单据的提交
//该类同时用于获取账户类单据
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
		this.getCashVO();
		this.getPaymentVO();
		this.getRecieptVO();
		if(rapoList==null){
			rapoList = new ArrayList<RecieptApplicationPO>();
		}
		if(ravoList==null){
			ravoList = new ArrayList<RecieptApplicationVO>();
		}
		if(capoList==null){
			capoList = new ArrayList<CashApplicationPO>();
		}
		if(cavoList==null){
			cavoList = new ArrayList<CashApplicationVO>();
		}
		if(papoList==null){
			papoList = new ArrayList<PaymentApplicationPO>();
		}
		if(pavoList==null){
			pavoList = new ArrayList<PaymentApplicationVO>();
		}
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

	public ArrayList<RecieptApplicationVO> getRecieptVO() {
		ArrayList<RecieptApplicationVO> volist  = new ArrayList<RecieptApplicationVO>();
		ArrayList<RecieptApplicationPO> polist  = new ArrayList<RecieptApplicationPO>();
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
		try {
			polist = fads.getAllRecieptList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++){
		    volist.add(new RecieptApplicationVO(polist.get(i)));
		    }		
		return volist;
	}

	public ArrayList<CashApplicationVO> getCashVO() {
		ArrayList<CashApplicationVO> volist  = new ArrayList<CashApplicationVO>();
		ArrayList<CashApplicationPO> polist  = new ArrayList<CashApplicationPO>();
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
		try {
			polist = fads.getAllCashList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++){
		    volist.add(new CashApplicationVO(polist.get(i)));	
		}		
		return volist;
	}

	public ArrayList<PaymentApplicationVO> getPaymentVO() {
		ArrayList<PaymentApplicationVO> volist  = new ArrayList<PaymentApplicationVO>();
		ArrayList<PaymentApplicationPO> polist  = new ArrayList<PaymentApplicationPO>();
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
		try {
			polist = fads.getAllPaymentList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++){
		    volist.add(new PaymentApplicationVO(polist.get(i)));	
		}		
		return volist;
	}
	
	
	                  

}
