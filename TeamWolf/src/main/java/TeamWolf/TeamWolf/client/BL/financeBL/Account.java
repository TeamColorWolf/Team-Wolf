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
	ArrayList<financeVO> volist;
	ArrayList<financePO> polist;
	
	
	public Account(String IP){
		
	}
	
	public int add(financeVO vo) {
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
			if(fba.canAdd(vo)){
		    financePO po =new financePO(vo);
			return fds.add(po);
			}else{
				return 00521;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 99911;
	}

	public int delete(financeVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int update(financeVO vo,financeVO newvo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public financeVO find(financeVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<financeVO> checkVO() {
		if(volist == null){
			try {
				fds = (financeDATAservice) Naming.lookup(URL);
				polist = fds.checklist();
				volist = new ArrayList<financeVO>();
				for(int i = 0; i < polist.size(); i++){
					financeVO vo = new financeVO(polist.get(i));
					volist.add(vo);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return volist;
	}

}
