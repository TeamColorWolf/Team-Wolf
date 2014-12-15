package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.UserLogDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.userDATAservice.UserDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.UserVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Account implements AccountBlservice{

	public String URL;
	financeDATAservice fds;
	financeBLAssistant fba;
	ArrayList<financeVO> volist;
	ArrayList<financePO> polist;
	
	
	public Account(String IP){
		URL = "rmi://" + IP + "/financeDATAservice";
		fba = new financeBLAssistant(IP);
		this.getpoList();
		this.checkVO();
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
		          volist.add(vo);
		          polist.add(po);
			      return fds.add(po);
			}else{
				return ErrorTW.accountNameExist;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ErrorTW.webError;
	}

	public int delete(financeVO vo) {
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
		if(fba.canDel(vo)){
			int success = -1;
			financePO po = new financePO(vo);
			try {
				success = fds.delete(po);
			} catch (RemoteException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			if(success==0){
			   getpoList();
			   volist=null;
			   volist = this.checkVO();
			   return success;
			   }
		}else{
			return ErrorTW.notFound;
		}
		return 30001;
	}

	public int update(financeVO vo,financeVO newvo) {
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
		if(fba.canUpd(vo, newvo)){
			financePO po = new financePO(vo);
			financePO newpo = new financePO(newvo);
			try {
				int success = fds.update(po, newpo);
				if(success==0){
					this.getpoList();
					volist = null;
					volist = this.checkVO();
				}
				return success;
			} catch (RemoteException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}
		return ErrorTW.accountNameNotExist;
	}

	public financeVO find(financeVO vo) {
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
		financePO po = new financePO(vo);
		try {
			financePO getit = fds.find(po);
			if(getit!=null){
				return new financeVO(getit);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
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

	private void getpoList() {
			try {
				fds = (financeDATAservice) Naming.lookup(URL);
				polist = fds.checklist();
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
}
