package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;

public class RecieptApplication extends Application {

	RecieptApplicationVO vo;
	String URL;
	CustomerController cc;
	financeController fc;
	
	
	public RecieptApplication(RecieptApplicationVO vo, String IP) {
		super(vo, IP);
		this.vo = vo;
		URL = "rmi://" + IP + "/financeApplicationDATAservice";
		cc = new CustomerController(IP);
		fc = new financeController(IP);
	}

	@Override
	public RecieptApplicationVO getApplicationVO() {
		return vo;
	}

	@Override
	public RecieptApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new RecieptApplicationPO(vo);
	}

	@Override
	public int submit() {
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			finance.submitRecieptApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int approve() {
		vo.condition = 1;
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			finance.approvalRecieptApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cc.RecieptListMod(getApplicationVO());
		fc.RecieptMod(getApplicationVO());
		return 0;
	}

	@Override
	public int reject() {
		vo.condition = -1;
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			finance.rejectRecieptApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
