package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
/**
 * 
 * @author YQ
 *
 */

//该类用于现金费用单提交，通过，与驳回

public class CashApplication extends Application {
	
	CashApplicationVO vo;
	String URL ="";
	financeController fc;
	
	//构造方法
	public CashApplication(CashApplicationVO vo, String IP) {
		super(vo, IP);
		URL = "rmi://" + IP + "/financeApplicationDATAservice";
		this.vo = vo;
		fc = new financeController(IP);
	}

	//获取当前正在操作的单据VO
	@Override	
	public CashApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return vo;
	}

	//获取当前正在操作的单据PO
	@Override
	public CashApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new CashApplicationPO(vo);
	}

	//提交当前正在操作的单据
	@Override
	public int submit() {
		vo.condition = 0;
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		}
		try {
			finance.submitCashApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;
		}
		return 0;
	}

	//通过当前正在操作的单据
	@Override
	public int approve() {
		vo.condition = 1;
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		}
		try {
			finance.approvalCashApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;
		}
		//customerController.CashListMod(this.getApplicationVO());
		fc.CashMod(getApplicationVO());//根据单据内容进行相关修改
		return 0;
	}

	//驳回单据
	@Override
	public int reject() {
		vo.condition = -1;
		try {
			finance = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return ErrorTW.webError;
		}
		try {
			finance.rejectCashApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;
		}
		return 0;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
