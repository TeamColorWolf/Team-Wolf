package TeamWolf.TeamWolf.client.BL.customerBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class CustomerInfo implements CustomerInfoBLservice{

	public String URL = null;
	public CustomerVO customer =null;
	FinanceApplicationDATAservice fad;
	
	public CustomerInfo(String IP){
		URL = "rmi://" + IP + "/customerDATAservice";
	}
	
	public int ImportListInfoMod(ImportListVO ivo) {
		ivo.getCustomer().setPay(ivo.getTotal());
		return 0;
	}

	public int ImportRejectListMod(ImportRejectListVO irvo) {
		irvo.getCustomer().setReceive(irvo.getTotal());
		return 0;
	}

	public int SaleListMod(SaleListVO svo) {
		svo.getCustomer().setReceive(svo.getTotalAfterDiscount());
		return 0;
	}

	public int SaleRejectListMod(SaleRejectListVO srvo) {
		srvo.getCustomer().setPay(srvo.getTotalAfterDiscount());
		return 0;
	}

	public int RecieptListMod(RecieptApplicationVO vo) {
		try {
			fad = (FinanceApplicationDATAservice) Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			fad.approvalRecieptApplication(new RecieptApplicationPO(vo));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	public int PaymentListMod(PaymentApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int CashListMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}



}
