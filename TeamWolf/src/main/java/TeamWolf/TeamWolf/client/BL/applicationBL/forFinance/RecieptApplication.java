package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class RecieptApplication extends Application {

	RecieptApplicationVO vo;
	
	public RecieptApplication(RecieptApplicationVO vo, String URL) {
		super(vo, URL);
		this.vo = vo;
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		try {
			finance.approvalRecieptApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerController.RecieptListMod(getApplicationVO());
		return 0;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
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
