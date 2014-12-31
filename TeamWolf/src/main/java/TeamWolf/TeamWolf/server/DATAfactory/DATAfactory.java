package TeamWolf.TeamWolf.server.DATAfactory;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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

		try {
			Registry registry = LocateRegistry.createRegistry(1099);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		try {
			finance = new financeDATA();
			
			login = new LoginDATA();
			user = new UserDATA();
			saleApp = new SaleApplicationDATA();
			stock = new StockData();
			goods = new GoodsData();
			promotion = new PromotionDATA();
			stockApplication = new StockApplicationDATA();
			customer = new CustomerDATA();
			approve = new ApproveDATA();
			financeApplication = new FinanceApplicationDATA();
			saleApplication = new SaleApplicationDATA();
			ini = new INIDATA();
			log = new LogDATA();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Naming.rebind("financeDATAservice", finance);
			Naming.rebind("CustomerDATAservice", customer);
			Naming.rebind("loginDATAservice", login);
			Naming.rebind("userDATAservice", user);
			Naming.rebind("saleDATAservice", saleApp);
			Naming.rebind("stockDATAservice", stock);
			Naming.rebind("goodsDATAservice", goods);
			Naming.rebind("promotionDATAservice", promotion);
			Naming.rebind("stockApplicationDATAservice", stockApplication);
			Naming.rebind("approveDATAservice", approve);
			Naming.rebind("financeApplicationDATAservice", financeApplication);
			Naming.rebind("saleApplicationDATAservice", saleApplication);
			Naming.rebind("iniDATAservice", ini);
			Naming.rebind("logDATAservice", log);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//获得本机IP
		System.out.println("My IP : " + ip);
		DATAfactory fac = new DATAfactory();
	}
}
