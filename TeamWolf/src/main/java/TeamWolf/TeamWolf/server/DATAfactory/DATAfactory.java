package TeamWolf.TeamWolf.server.DATAfactory;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.RMIName;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.INIDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.LogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.LoginDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.server.applicationDATA.ApproveDATA;
import TeamWolf.TeamWolf.server.applicationDATA.FinanceApplicationDATA;
import TeamWolf.TeamWolf.server.applicationDATA.SaleApplicationDATA;
import TeamWolf.TeamWolf.server.applicationDATA.StockApplicationDATA;
import TeamWolf.TeamWolf.server.financeDATA.INIDATA;
import TeamWolf.TeamWolf.server.financeDATA.financeDATA;
import TeamWolf.TeamWolf.server.goodsDATA.GoodsData;
import TeamWolf.TeamWolf.server.logDATA.LogDATA;
import TeamWolf.TeamWolf.server.promotionDATA.PromotionDATA;
import TeamWolf.TeamWolf.server.saleDATA.CustomerDATA;
import TeamWolf.TeamWolf.server.stockDATA.StockData;
import TeamWolf.TeamWolf.server.userDATA.LoginDATA;
import TeamWolf.TeamWolf.server.userDATA.UserDATA;


public class DATAfactory {
	UserDATAservice user;
	LoginDATAservice login;
	SaleApplicationDATAservice saleApp;
	StockDataService stock;
	GoodsDataService goods;
	PromotionDATAservice promotion;
	financeDATAservice finance;
	CustomerDATAservice customer;
	ApproveDATAservice approve;
	StockApplicationDATAservice stockApplication;
	FinanceApplicationDATAservice financeApplication;
	SaleApplicationDATAservice saleApplication;
	INIDATAservice ini;
	LogDATAservice log;
	
	public DATAfactory(){
		
		int success = 0;
		
		success = createRMIregistry();
		if(success == ErrorTW.rmiError){
			System.out.println("服务器启动失败");
		}
		createService();
		
		bindService(user);
		bindService(login);
		bindService(saleApp);
		bindService(stock);
		bindService(goods);
		bindService(promotion);
		bindService(finance);
		bindService(customer);
		bindService(approve);
		bindService(stockApplication);
		bindService(financeApplication);
		bindService(saleApplication);
		bindService(ini);
		bindService(log);
	}
	
	private int createRMIregistry(){
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			return 0;
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return ErrorTW.rmiError;
		}
	}
	
	private int bindService(Remote rem){
		try {
			Naming.rebind(RMIName.name(rem), rem);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;
		}
		return 0;
	}
	
	private int createService(){
		int success = 0;
		try {
			finance = new financeDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			login = new LoginDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			user = new UserDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			saleApp = new SaleApplicationDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			stock = new StockData();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			goods = new GoodsData();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			promotion = new PromotionDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			stockApplication = new StockApplicationDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			customer = new CustomerDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			approve = new ApproveDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			financeApplication = new FinanceApplicationDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			saleApplication = new SaleApplicationDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			ini = new INIDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		try {
			log = new LogDATA();
		} catch (RemoteException e) {
			e.printStackTrace();
			success = ErrorTW.rmiError;
		}
		return success;
	}
	
	public static void main(String[] args) throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//获得本机IP
		System.out.println("My IP : " + ip);
		DATAfactory fac = new DATAfactory();
	}
}
