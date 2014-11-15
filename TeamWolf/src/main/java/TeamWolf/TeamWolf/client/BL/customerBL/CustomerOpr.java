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
	
	public CustomerOpr(String IP){
		
	}
	
	CustomerDATAservice cds;
	ArrayList<CustomerVO> voList;
	ArrayList<CustomerPO> poList;

	public int Customerupdate(CustomerVO vo, CustomerVO newvo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int Customeradd(CustomerVO vo) {
		
		return 0;
	}

	public int Customerdel(CustomerVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	public ArrayList<CustomerVO> getAlluserList(){
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

}
