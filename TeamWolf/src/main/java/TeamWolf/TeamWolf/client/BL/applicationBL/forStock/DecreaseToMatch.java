package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;

public class DecreaseToMatch extends Application{

	String URL;
	StockApplicationDATAservice dataService;
	DecreaseToMatchPO application;
	
	public DecreaseToMatch(DecreaseToMatchVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		URL="rmi://"+IP+"/stockApplicationDATAservice";
		application=new DecreaseToMatchPO(vo);
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
		// TODO Auto-generated method stub
		int result=0;
		try {
			dataService.submitDecreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
			result=30000;
		}
		return result;
	}

	@Override
	public int approve() {
		// TODO Auto-generated method stub
		int result=0;
		application.condition=1;
		try {
			result=dataService.approvalDecreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//result=通信错误
			result=30000;
		}
		return result;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
		int result=0;
		application.condition=-1;
		try {
			result=dataService.rejectDecreaseToMatch(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=30000;
		}
		return result;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
