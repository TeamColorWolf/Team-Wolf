package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.UserLogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Account implements AccountBlservice{

	public String URL = null;
	financeDATAservice fds;
	financeBLAssistant fba;
	
	public Account(String IP){
		
	}
	
	public int add(String name) {
		financePO po = new financePO(name);
		try {
			fds = (financeDATAservice)Naming.lookup(URL);
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
			if(fba.canAdd(po))
			return fds.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 99911;
	}

	public int delete(String name) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int update(String previousname, String newname) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public financeVO find(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

}
