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
		URL = "rmi://" + IP + "/CustomerDATAservice";
	}
	
	public int ImportListInfoMod(ImportListVO ivo) {
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = ivo.getCustomer().getNum();
			String name = ivo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should pay = " + oldCustomer.getPay());
			ivo.getCustomer().setPay(oldCustomer.getPay() + ivo.getTotal());
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
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = irvo.getCustomer().getNum();
			String name = irvo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should receive = " + oldCustomer.getReceive());
			irvo.getCustomer().setReceive(oldCustomer.getReceive() + irvo.getTotal());
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
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = svo.getCustomer().getNum();
			String name = svo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should receive = " + oldCustomer.getReceive());
			svo.getCustomer().setReceive(oldCustomer.getReceive() + svo.getTotalAfterDiscount());
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
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = srvo.getCustomer().getNum();
			String name = srvo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should pay = " + oldCustomer.getPay());
			srvo.getCustomer().setPay(srvo.getCustomer().getPay() + srvo.getTotalAfterDiscount());
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

		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = vo.getCustomer().getNum();
			String name = vo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			vo.getCustomer().setReceive(oldCustomer.getReceive() - Double.parseDouble(vo.getAddup()));
			cds.modCustomer(oldCustomer,new CustomerPO(vo.getCustomer()));
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
		return 0;
	}

	public int PaymentListMod(PaymentApplicationVO vo) {
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = vo.getCustomer().getNum();
			String name = vo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			vo.getCustomer().setPay(oldCustomer.getPay() + Double.parseDouble(vo.getAddup()));
			cds.modCustomer(oldCustomer,new CustomerPO(vo.getCustomer()));
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
		return 0;
	}

	public int CashListMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}



}
