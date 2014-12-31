package TeamWolf.TeamWolf;

import java.rmi.Remote;

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

public class RMIName {
	public final static String financeDATA = "financeDATAservice";
	public final static String customerDATA = "CustomerDATAservice";
	public final static String loginDATA = "loginDATAservice";
	public final static String userDATA = "userDATAservice";
	public final static String saleDATA = "saleDATAservice";
	public final static String stockDATA = "stockDATAservice";
	public final static String goodsDATA = "goodsDATAservice";
	public final static String promotionDATA = "promotionDATAservice";
	public final static String initialDATA = "iniDATAservice";
	public final static String approveDATA = "approveDATAservice";
	public final static String logDATA = "logDATAservice";
	public final static String stockApplication = "stockApplicationDATAservice";
	public final static String saleApplication = "saleApplicationDATAservice";
	public final static String financeApplication = "financeApplicationDATAservice";
	
	public static String createURL(String IP, Remote rmi){
		String url = "rmi://" + IP + "/";
		if(rmi instanceof ApproveDATAservice){
			url += approveDATA;
		}
		else if(rmi instanceof FinanceApplicationDATAservice){
			url += financeApplication;
		}
		else if(rmi instanceof SaleApplicationDATAservice){
			url += saleApplication;
		}
		else if(rmi instanceof StockApplicationDATAservice){
			url += stockApplication;
		}
		else if(rmi instanceof CustomerDATAservice){
			url += customerDATA;
		}
		else if(rmi instanceof financeDATAservice){
			url += financeDATA;
		}
		else if(rmi instanceof INIDATAservice){
			url += initialDATA;
		}
		else if(rmi instanceof GoodsDataService){
			url += goodsDATA;
		}
		else if(rmi instanceof LogDATAservice){
			url += logDATA;
		}
		else if(rmi instanceof PromotionDATAservice){
			url += promotionDATA;
		}
		else if(rmi instanceof StockDataService){
			url += stockDATA;
		}
		else if(rmi instanceof LoginDATAservice){
			url += loginDATA;
		}
		else if(rmi instanceof UserDATAservice){
			url += userDATA;
		}
		return url;
	}
	
	public static String name(Remote rmi){
		String name = new String();
		if(rmi instanceof ApproveDATAservice){
			name += approveDATA;
		}
		else if(rmi instanceof FinanceApplicationDATAservice){
			name += financeApplication;
		}
		else if(rmi instanceof SaleApplicationDATAservice){
			name += saleApplication;
		}
		else if(rmi instanceof StockApplicationDATAservice){
			name += stockApplication;
		}
		else if(rmi instanceof CustomerDATAservice){
			name += customerDATA;
		}
		else if(rmi instanceof financeDATAservice){
			name += financeDATA;
		}
		else if(rmi instanceof INIDATAservice){
			name += initialDATA;
		}
		else if(rmi instanceof GoodsDataService){
			name += goodsDATA;
		}
		else if(rmi instanceof LogDATAservice){
			name += logDATA;
		}
		else if(rmi instanceof PromotionDATAservice){
			name += promotionDATA;
		}
		else if(rmi instanceof StockDataService){
			name += stockDATA;
		}
		else if(rmi instanceof LoginDATAservice){
			name += loginDATA;
		}
		else if(rmi instanceof UserDATAservice){
			name += userDATA;
		}
		return name;
	}
}
