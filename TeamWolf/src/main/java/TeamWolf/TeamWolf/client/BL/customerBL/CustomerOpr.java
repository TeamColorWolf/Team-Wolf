package TeamWolf.TeamWolf.client.BL.customerBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class CustomerOpr implements CustomerOprBLservice{
	
	public String URL = null;
	public CustomerVO customer =null;
	
	
	CustomerDATAservice cds;
	ArrayList<CustomerVO> voList;
	ArrayList<CustomerPO> poList;

	public CustomerOpr(String IP){
		URL = "rmi://" + IP + "/CustomerDATAservice";
		this.CheckPO();
		this.getAllCustomerList();
	}
	
	public int Customerupdate(CustomerVO vo, CustomerVO newVO) {
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
		CustomerPO po = new CustomerPO(vo);
	    CustomerPO newpo = new CustomerPO(newVO);
	    try {
			int success = cds.modCustomer(po, newpo);
			if(success==0){
			   voList.set(voList.indexOf(vo),newVO);
			   for (int i = 0; i < poList.size(); i++) {
				   if(poList.get(i).getNum().equals(po.getName())){
					   poList.remove(i);
					   poList.add(po);
					   break;
				   }
			   }
			   return success;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    
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
			int success = cds.addCustomer(po);
			poList.add(new CustomerPO(vo));
			voList.add(vo);
			return success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		};
		return 12138;
	}

	public int Customerdel(CustomerVO cvo) {
		CustomerPO po = new CustomerPO(cvo);
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
			int success = cds.delCustomer(po);
			voList.remove(cvo);
			poList.remove(new CustomerPO(cvo));
			return success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 12138;
	}
	
	public CustomerVO findCustomer(String name,String number){
        try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			CustomerPO cpo = cds.findCustomer(name, number);
			if(cpo == null){
				return null;
			} else {
				return new CustomerVO(cpo);
			}
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
		return null;
	}
	
	public ArrayList<CustomerVO> getAllCustomerList(){
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			voList = cds.checkVO();
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
	
	
	public ArrayList<CustomerPO> CheckPO(){
		try {
			cds = (CustomerDATAservice)Naming.lookup(URL);
			poList =cds.checkPO();
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
		return poList;
	}

	public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String num) {
		// TODO 自动生成的方法存根
		return null;
	}

	public CustomerVO findCustomer(String nameOrnumber) {
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
			return new CustomerVO(cds.findCustomer(nameOrnumber));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
