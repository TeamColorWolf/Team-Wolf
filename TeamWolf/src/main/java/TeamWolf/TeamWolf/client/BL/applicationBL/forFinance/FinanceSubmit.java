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
		this.capoList = this.getCashPO();
		if(capoList==null){			
			capoList = new ArrayList<CashApplicationPO>();
		}
		if(cavoList==null){	
			cavoList = new ArrayList<CashApplicationVO>();
		}
		this.getCashVO();
		this.papoList = this.getPaymentPO(); 
		if(pavoList==null){			
			pavoList = new ArrayList<PaymentApplicationVO>();
		}
		if(papoList==null){
			papoList = new ArrayList<PaymentApplicationPO>();
		}
		this.getPaymentVO();
		this.rapoList = this.getRecieptPO();
		if(rapoList==null){
			rapoList = new ArrayList<RecieptApplicationPO>();
			System.out.println("ss");;
		}
		System.out.println(this.rapoList.get(0).getAccountList().size());
		if(ravoList==null){
			ravoList = new ArrayList<RecieptApplicationVO>();
		}
		this.getRecieptVO();
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
	
	public ArrayList<RecieptApplicationPO> getRecieptPO(){
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
			return fads.getAllRecieptList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return null;
	}
	public ArrayList<RecieptApplicationVO> getRecieptVO(){
		for(int i=0;i<rapoList.size();i++){
			ravoList.add(new RecieptApplicationVO(rapoList.get(i)));
		}
		return ravoList;
	}
	public ArrayList<PaymentApplicationPO> getPaymentPO(){
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
			return fads.getAllPaymentList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<PaymentApplicationVO> getPaymentVO(){
		for(int i=0;i<papoList.size();i++){
			pavoList.add(new PaymentApplicationVO(papoList.get(i)));
		}
		return pavoList;
	}
	public ArrayList<CashApplicationPO> getCashPO(){
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
			return fads.getAllCashList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<CashApplicationVO> getCashVO(){
		for(int i=0;i<capoList.size();i++){
			cavoList.add(new CashApplicationVO(capoList.get(i)));
		}
		return cavoList;
	}
	
	                  

}
