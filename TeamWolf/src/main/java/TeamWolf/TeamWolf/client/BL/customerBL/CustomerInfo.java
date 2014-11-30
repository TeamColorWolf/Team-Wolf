package TeamWolf.TeamWolf.client.BL.customerBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
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
	
	
	CustomerDATAservice cds;
	
	public CustomerInfo(String IP){
		URL = "rmi://" + IP + "/customerDATAservice";
	}
	
	public int ImportListInfoMod(ImportListVO vo) {
		// TODO 自动生成的方法存根
		CustomerVO newvo = new CustomerVO("","","","","", "", "","","","","","");
		CustomerPO po = null;//zheliyaogai
		CustomerPO newpo = new CustomerPO(newvo);
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
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
			return cds.modCustomer(po,newpo);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 90001;
				}

	public int ImportRejectListMod(ImportRejectListVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int SaleListMod(SaleListVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int SaleRejectListMod(SaleRejectListVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int RecieptListMod(RecieptApplicationVO vo) {
		// TODO 自动生成的方法存根
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
