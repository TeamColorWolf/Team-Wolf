package TeamWolf.TeamWolf.server.financeDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.INIDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class INIDATA extends UnicastRemoteObject implements INIDATAservice{

	ArrayList<INIPO> iList;
	
	public INIDATA() throws RemoteException {
		super();
		this.initial();
		if(iList == null){
			iList = new ArrayList<INIPO>();
		}
	}

	public int insert(INIPO po) throws RemoteException {
		iList.add(po);
		return 0;
	}

	public int find(INIPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	private void initial(){
		try {
			iList = (ArrayList<INIPO>) FileOpr.readFile(FileName.iniFile);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
