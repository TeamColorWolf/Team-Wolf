package TeamWolf.TeamWolf.server.saleDATA;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;

public class CustomerDATA implements CustomerDATAservice{

	public int addCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CustomerPO> checkPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int modCustomer(CustomerPO po, CustomerPO newpo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public CustomerPO findCustomer(String name, int number)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getCustomerList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
