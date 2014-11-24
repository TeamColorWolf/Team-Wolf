package TeamWolf.TeamWolf.server.financeDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class financeDATA extends UnicastRemoteObject implements financeDATAservice{
	
	ArrayList<financePO> AccountList;
	

	protected financeDATA() throws RemoteException {
		super();
		this.initial();
		if(AccountList.equals(null)){
			AccountList = new ArrayList<financePO>();
		}
	}

	public financePO find(financePO po) throws RemoteException {
		financePO tofind = null;
		for(financePO f : AccountList){
			if(f.getName().equals(po.getName())){
				tofind = f;
				break;
			}			
		}
		return tofind;
	}


	public int add(financePO po) throws RemoteException {
		AccountList.add(po);
		try {
			FileOpr.writeFile(FileName.accountFile,AccountList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(financePO po) throws RemoteException {
		financePO del = null;
		for(financePO f :AccountList){
			if(f.getName().equals(po.getName())){
				del=f;
				break;
			}
		}
		if(del!=null){
			AccountList.remove(del);
			try {
				FileOpr.writeFile(FileName.accountFile, AccountList);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int update(financePO po, financePO newpo) throws RemoteException {
		for(financePO intr : AccountList){
			if(intr.getName().equals(po.getName())){
				intr = newpo;
			}
		}
		try {
			FileOpr.writeFile(FileName.accountFile, AccountList);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	
	private void initial(){
		try {
			AccountList=(ArrayList<financePO>)FileOpr.readFile(FileName.goodsFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[]args){
		try {
			financeDATA fd = new financeDATA();
			financePO f1 = new financePO("DAB",1);
			fd.add(f1);
			financePO f2 = fd.find(f1);
			System.out.println(f1.getName());
			System.out.println(f2.getName());
			fd.delete(f1);
			financePO f3 = fd.find(f1);
			if(f3==null){
				System.out.println("del");				
			}	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}*/

}