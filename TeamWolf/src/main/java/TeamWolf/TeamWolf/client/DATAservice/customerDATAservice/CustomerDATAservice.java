package TeamWolf.TeamWolf.client.DATAservice.customerDATAservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;

public interface CustomerDATAservice {

	public void addCustomer (CustomerPO cpo) throws RemoteException;
	
	public void delCustomer (CustomerPO cpo) throws RemoteException;
	
	public ArrayList<CustomerPO> checkPO()throws RemoteException;
	
	public CustomerPO modCustomer (CustomerPO cpo)  throws RemoteException;
	
	public CustomerPO findCustomer (String name, String number) throws RemoteException;
	
	public ArrayList<String> getCustomerList() throws RemoteException;
	
}
