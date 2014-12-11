package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;

public class IncreaseToMatch extends Application{
	
	String URL;
	StockApplicationDATAservice dataService;
	IncreaseToMatchPO application;
	
	public IncreaseToMatch(IncreaseToMatchVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		URL="rmi://"+IP+"/stockApplicationDATAservice";
		application=new IncreaseToMatchPO(vo);
		try {
			dataService=(StockApplicationDATAservice)Naming.lookup(URL);
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
	
	@Override
	public ApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int submit() {
		
		int result=0;
		
		try {
			result=dataService.submitIncreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
		}
		
		return result;
	}
	@Override
	public int approve(){
		//改变其状态并且进行后续操作
		int result=0;
		application.condition=1;
		try {
			result=dataService.approvalIncreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result=通信错误
		}
		return result;
	}
	@Override
	public int reject(){
		//改变其状态并且进行后续操作
		int result=0;
		application.condition=-1;
		try {
			result=dataService.rejectIncreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result=通信错误
		}
		return result;
	}
	@Override
	public int change(ApplicationVO vo){
		return 0;
	}

}
