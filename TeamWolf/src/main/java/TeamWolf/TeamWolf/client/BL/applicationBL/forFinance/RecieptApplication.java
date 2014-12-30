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

//该类用于收款单的审批，通过，驳回
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

	
	//获取当前单据VO
	@Override
	public RecieptApplicationVO getApplicationVO() {
		return vo;
	}

	//获取当前单据PO
	@Override
	public RecieptApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new RecieptApplicationPO(vo);
	}

	//提交当前单据
	@Override
	public int submit() {
		vo.condition = 0;
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

	//通过当前单据
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
		cc.RecieptListMod(getApplicationVO());//根据单据修改客户信息
		fc.RecieptMod(getApplicationVO());//根据单据修改账户信息
		return 0;
	}

    //拒绝当前单据	
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
