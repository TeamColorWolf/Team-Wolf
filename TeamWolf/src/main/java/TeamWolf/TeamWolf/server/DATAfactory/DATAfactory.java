package TeamWolf.TeamWolf.server.DATAfactory;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.DATAservice.saleDATAservice.SaleDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.LoginDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.server.goodsDATA.GoodsData;
import TeamWolf.TeamWolf.server.saleDATA.SaleDATA;
import TeamWolf.TeamWolf.server.stockDATA.StockData;
import TeamWolf.TeamWolf.server.userDATA.LoginDATA;
import TeamWolf.TeamWolf.server.userDATA.UserDATA;


public class DATAfactory {
	UserDATAservice user;
	LoginDATAservice login;
	SaleDATAservice sale;
	StockDataService stock;
	GoodsDataService goods;
	
	public DATAfactory(){
		try {
			login = new LoginDATA();
			user = new UserDATA();
			sale = new SaleDATA();
			stock=new StockData();
			goods=new GoodsData();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Naming.rebind("loginDATAservice", login);
			Naming.rebind("userDATAservice", user);
			Naming.rebind("saleDATAservice", sale);
			Naming.rebind("stockDATAservice", stock);
			Naming.rebind("goodsDATAservice", goods);
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
