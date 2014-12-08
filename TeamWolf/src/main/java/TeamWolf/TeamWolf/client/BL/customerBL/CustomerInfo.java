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
	public static CustomerDATAservice cds;
	
	public CustomerInfo(String IP){
		URL = "rmi://" + IP + "/customerDATAservice";
	}
	
	public int ImportListInfoMod(ImportListVO ivo) {
		CustomerPO oldCustomer = new CustomerPO(ivo.getCustomer());
		ivo.getCustomer().setPay(ivo.getCustomer().getPay() + ivo.getTotal());
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
			cds.modCustomer(oldCustomer, new CustomerPO(ivo.getCustomer()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int ImportRejectListMod(ImportRejectListVO irvo) {
		CustomerPO oldCustomer = new CustomerPO(irvo.getCustomer());
		irvo.getCustomer().setReceive(irvo.getCustomer().getReceive() + irvo.getTotal());
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
			cds.modCustomer(oldCustomer, new CustomerPO(irvo.getCustomer()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int SaleListMod(SaleListVO svo) {
		CustomerPO oldCustomer = new CustomerPO(svo.getCustomer());
		svo.getCustomer().setReceive(svo.getCustomer().getReceive() + svo.getTotalAfterDiscount());
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
			cds.modCustomer(oldCustomer, new CustomerPO(svo.getCustomer()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int SaleRejectListMod(SaleRejectListVO srvo) {
		CustomerPO oldCustomer = new CustomerPO(srvo.getCustomer());
		srvo.getCustomer().setPay(srvo.getCustomer().getPay() + srvo.getTotalAfterDiscount());
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
			cds.modCustomer(oldCustomer, new CustomerPO(srvo.getCustomer()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int RecieptListMod(RecieptApplicationVO vo) {
		CustomerPO oldCustomer = new CustomerPO(vo.getCustomer());
		vo.getCustomer().setReceive(vo.getCustomer().getReceive()-Double.parseDouble(vo.getAddup()));
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
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
			cds.modCustomer(oldCustomer,new CustomerPO(vo.getCustomer()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	public int PaymentListMod(PaymentApplicationVO vo) {
		CustomerPO oldCustomer = new CustomerPO(vo.getCustomer());
		vo.getCustomer().setPay(vo.getCustomer().getPay()-Double.parseDouble(vo.getAddup()));
		try {
			cds = (CustomerDATAservice)Naming.lookup("CustomerDATAservice");
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
			cds.modCustomer(oldCustomer,new CustomerPO(vo.getCustomer()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	public int CashListMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}



}
