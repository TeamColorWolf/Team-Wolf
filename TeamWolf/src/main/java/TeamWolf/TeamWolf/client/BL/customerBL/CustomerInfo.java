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

//客户信息修改类
//处理各种单据等原因引起的客户信息修改
public class CustomerInfo implements CustomerInfoBLservice{

	public String URL = null;
	public static CustomerDATAservice cds;
	
	public CustomerInfo(String IP){
		URL = "rmi://" + IP + "/CustomerDATAservice";
	}
	 //处理进货单引起的客户信息修改
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
	//处理进货退货单引起的客户信息修改
	public int ImportRejectListMod(ImportRejectListVO irvo) {
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = irvo.getCustomer().getNum();
			String name = irvo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should pay = " + oldCustomer.getPay());
			irvo.getCustomer().setPay(oldCustomer.getPay() - irvo.getTotal());
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
	//处理销售单引起的客户信息修改
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
	//处理销售退货单引起的客户信息修改

	public int SaleRejectListMod(SaleRejectListVO srvo) {
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			String number = srvo.getCustomer().getNum();
			String name = srvo.getCustomer().getName();
			CustomerPO oldCustomer = cds.findCustomer(name, number);
			System.out.println("oldCustomer should receive = " + oldCustomer.getReceive());
			srvo.getCustomer().setReceive(srvo.getCustomer().getReceive() - srvo.getTotalAfterDiscount());
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
	//处理收款单引起的客户信息修改
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
	//处理付款单引起的客户信息修改
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
	//设计为修改现金费用单的客户修改
	//但是现金费用单不需要修改客户信息......
	public int CashListMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}



}
