package TeamWolf.TeamWolf.server.saleDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class CustomerDATA extends UnicastRemoteObject implements CustomerDATAservice{
	
	static ArrayList<CustomerPO> list = null;
	
	public CustomerDATA() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
		getList();
		if(list == null){
			list = new ArrayList<CustomerPO>();
		}
		System.out.println("gyqgyqgyqgyq   " + list.size());
	}
	
	public int addCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		list.add(cpo);
		try {
			FileOpr.writeFile(FileName.customerFile, list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 30001;
		}
		return 0;
	}

	public int delCustomer(CustomerPO cpo) throws RemoteException {
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getNum().equals(cpo.getNum())){
				list.remove(i);
				try {
					FileOpr.writeFile(FileName.customerFile,list);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 30002;
				}
			}
		}
		return 0;
	}

	public ArrayList<CustomerPO> checkPO() throws RemoteException {
		// TODO Auto-generated method stub
		return list;
	}
	
	public ArrayList<CustomerVO> checkVO() throws RemoteException{
		ArrayList<CustomerVO> volist = new ArrayList<CustomerVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new CustomerVO(list.get(i)));
		}
		return volist;		
	}

	public int modCustomer(CustomerPO po, CustomerPO newpo) throws RemoteException {
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getNum().equals(po.getName())){
			  list.remove(list.get(i));
			  list.add(i,newpo);
				try {
					FileOpr.writeFile(FileName.customerFile, list);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 30003;
				}
			}
		}
		return 0;
	}

	public CustomerPO findCustomer(String name, String number)
			throws RemoteException {
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getNum().equals(number)||list.get(i).getName().equals(name)){
				return list.get(i);
			}
		}
		return null;
	}

	public ArrayList<String> getCustomerList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void getList(){
		try {
			list = (ArrayList<CustomerPO>) FileOpr.readFile(FileName.customerFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
