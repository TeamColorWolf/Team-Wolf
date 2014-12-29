package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class AccountInfo implements AccountInfoBLservice{
	
	public String URL = "";
	public static financeDATAservice fds;

	public AccountInfo(String IP){
		URL = "rmi://" + IP + "/financeDATAservice";
	}
	
	public int RecieptMod(RecieptApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		for(int i=0;i<volist.size();i++){
			try {
				fds = (financeDATAservice) Naming.lookup(URL);
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
			}
		}
		
		return 9;
	}

	public int PaymentMod(PaymentApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		for(int i=0;i<volist.size();i++){
			try {
				fds = (financeDATAservice) Naming.lookup(URL);
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
			}
		}
		
		return 9;
	}

	public int CashMod(CashApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		ArrayList<String> moneylist = vo.getMoneyList();
		for(int i=0;i<volist.size();i++){
			try {
				fds = (financeDATAservice) Naming.lookup(URL);
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
			}
		}
		return 0;
	}




}
