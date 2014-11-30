package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;

public class PaymentApplication extends Application {

	PaymentApplicationVO vo;
	
	public PaymentApplication(PaymentApplicationVO vo, String URL) {
		super(vo, URL);
		this.vo = vo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public PaymentApplicationVO getApplicationVO() {
		return vo ;
	}

	@Override
	public PaymentApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return new PaymentApplicationPO(vo);
	}

	@Override
	public int submit() {
		// TODO Auto-generated method stub
		try {
			finance.submitPaymentApplication(getApplicationPO());
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
			finance.approvalPaymentApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerController.PaymentListMod(getApplicationVO());
		return 0;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
		try {
			finance.rejectPaymentApplication(getApplicationPO());
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
