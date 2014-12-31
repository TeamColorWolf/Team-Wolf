package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

//用于处理各类单据中对账户的修改
public class AccountInfo implements AccountInfoBLservice{
	
	public String URL = "";
	public static financeDATAservice fds;

	public AccountInfo(String IP){
		URL = "rmi://" + IP + "/financeDATAservice";
	}
	
	//处理收款单对账户的修改
	public int RecieptMod(RecieptApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		try {
			fds = (financeDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		}
		for(int i=0;i<volist.size();i++){
		    financeVO oldf = volist.get(i);
		    try {
		    	financePO getPO = fds.find(new financePO(oldf));
				
		         financeVO newf = new financeVO(getPO.getName()
		    		,getPO.getAccount()+Double.parseDouble(moneylist.get(i)));
		        financePO oldpo = getPO;
		        financePO newpo = new financePO(newf);
		        fds.update(oldpo, newpo);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return ErrorTW.webError;
			}
		}
		
		return 0;
	}
    //处理付款单对账户的修改
	public int PaymentMod(PaymentApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		try {
			fds = (financeDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		}
		for(int i=0;i<volist.size();i++){
		    financeVO oldf = volist.get(i);
		    try {
		    	financePO getPO = fds.find(new financePO(oldf));
				
		         financeVO newf = new financeVO(getPO.getName()
		    		,getPO.getAccount()-Double.parseDouble(moneylist.get(i)));
		        financePO oldpo = getPO;
		        financePO newpo = new financePO(newf);
		        fds.update(oldpo, newpo);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return ErrorTW.webError;
			}
		}
		
		return 0;
	}

	//处理现金费用单对账户的修改
	public int CashMod(CashApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		try {
			fds = (financeDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ErrorTW.webError;
		}
		for(int i=0;i<volist.size();i++){
			financeVO oldf = volist.get(i);
			try {
				financePO getPO = fds.find(new financePO(oldf));
			
		         financeVO newf = new financeVO(getPO.getName()
		    		,getPO.getAccount()-Double.parseDouble(moneylist.get(i)));
		        financePO oldpo = getPO;
		        financePO newpo = new financePO(newf);
		        fds.update(oldpo, newpo);
			} catch (RemoteException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				return ErrorTW.webError;
			}
		}
		return 0;
	}




}
