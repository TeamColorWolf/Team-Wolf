package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;

public class CashApplication extends Application {
	
	CashApplicationVO vo;
	
	public CashApplication(CashApplicationVO vo, String URL) {
		super(vo, URL);
		this.vo = vo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public CashApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return vo;
	}

	@Override
	public CashApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new CashApplicationPO(vo);
	}

	@Override
	public int submit() {
		// TODO Auto-generated method stub
		try {
			finance.submitCashApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int approve() {
		// TODO Auto-generated method stub
		try {
			finance.approvalCashApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerController.CashListMod(this.getApplicationVO());
		return 0;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
		try {
			finance.rejectCashApplication(getApplicationPO());
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
