package TeamWolf.TeamWolf.client.BL.customerBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class CustomerOpr implements CustomerOprBLservice{
	
	public String URL = null;
	public CustomerVO customer =null;
	
	
	CustomerDATAservice cds;
	ArrayList<CustomerVO> voList;
	ArrayList<CustomerPO> poList;

	public CustomerOpr(String IP){
		
	}
	
	public int Customerupdate(CustomerVO vo, CustomerVO newVO) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int Customeradd(CustomerVO vo) {
		CustomerPO po = new CustomerPO(vo);
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
			return cds.addCustomer(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		};
		return 12138;
	}

	public int Customerdel(CustomerVO cvo) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	public CustomerVO findCustomer(String name){
		// TODO 自动生成的方法存根
		return null;
	}
	
	public ArrayList<CustomerVO> getAllCustomerList(){
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			poList = cds.checkPO();
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
		return voList;
	}

	public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String num) {
		// TODO 自动生成的方法存根
		return null;
	}

}
