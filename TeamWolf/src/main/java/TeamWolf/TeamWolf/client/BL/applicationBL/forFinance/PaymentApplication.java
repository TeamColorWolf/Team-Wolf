package TeamWolf.TeamWolf.client.BL.applicationBL.forFinance;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.BL.financeBL.financeController;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import  TeamWolf.TeamWolf.client.BL.financeBL.financeController;

public class PaymentApplication extends Application {

	String URL;
	PaymentApplicationVO vo;	
	CustomerController cc;
	financeController fc;
	public PaymentApplication(PaymentApplicationVO vo, String IP) {
		super(vo, IP);
		URL = "rmi://" + IP + "/financeApplicationDATAservice";
		this.vo = vo;
		cc= new CustomerController(IP);
		fc = new financeController(IP);
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
		vo.condition = 1;
		try {
			finance.approvalPaymentApplication(getApplicationPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cc.PaymentListMod(getApplicationVO());
		fc.PaymentMod(vo);
		return 0;
	}

	@Override
	public int reject() {
		vo.condition = -1;
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
