package TeamWolf.TeamWolf.client.DATAservice.customerDATAservice;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.po.CustomerPO;

public interface CustomerDATAservice {

	public void addCustomer (CustomerPO cpo) throws RemoteException;
	
	public void delCustomer (CustomerPO cpo) throws RemoteException;
	
	public CustomerPO modCustomer (CustomerPO cpo)  throws RemoteException;
	
	public CustomerPO findCustomer (String name, String number) throws RemoteException;
	
}
