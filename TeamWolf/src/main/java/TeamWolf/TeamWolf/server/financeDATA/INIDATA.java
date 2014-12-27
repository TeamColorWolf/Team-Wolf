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
		int number = iList.size();
		po.setNumber(number);
		iList.add(po);
		try {
			FileOpr.writeFile(FileName.iniFile, iList);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	public INIPO find(int number) throws RemoteException {
		for(INIPO intr : iList){
			if(intr.getNumber()==number){
				return intr;
			}
		}
		return null;
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
