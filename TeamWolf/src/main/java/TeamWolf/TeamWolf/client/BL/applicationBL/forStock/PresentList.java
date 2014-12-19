package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public class PresentList extends Application{

	String URL;
	StockApplicationDATAservice dataService;
	PresentListPO application;
	
	public PresentList(PresentListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
		URL="rmi://"+IP+"/stockApplicationDATAservice";
		application=new PresentListPO(vo);
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
			String number=dataService.todayQuantityOfPL();
			application.number="ZSD-"+number;
			dataService.submitPresentList(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			result=dataService.approvalPresentList(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=30000; //通信错误
		}
		return result;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
		int result=0;
		application.condition=-1;
		try {
			result=dataService.rejectPresentList(application);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=30000; //通信错误
		}
		return result;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
