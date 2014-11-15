package TeamWolf.TeamWolf.client.DATAservice.customerDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;

public interface CustomerDATAservice extends Remote{

	public int addCustomer (CustomerPO cpo) throws RemoteException;
	
	public int delCustomer (CustomerPO cpo) throws RemoteException;
	
	public ArrayList<CustomerPO> checkPO()throws RemoteException;
	
	public int modCustomer (CustomerPO po,CustomerPO newpo)  throws RemoteException;
	
	public CustomerPO findCustomer (String name, String number) throws RemoteException;
	
	public ArrayList<String> getCustomerList() throws RemoteException;
	
}
