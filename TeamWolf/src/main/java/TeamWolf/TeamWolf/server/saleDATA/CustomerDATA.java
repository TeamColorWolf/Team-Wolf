package TeamWolf.TeamWolf.server.saleDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;
import TeamWolf.TeamWolf.server.logDATA.LogDATA;

public class CustomerDATA extends UnicastRemoteObject implements CustomerDATAservice{
	
	static ArrayList<CustomerPO> list = null;
	
	public CustomerDATA() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
		getList();

		if(list == null){
			list = new ArrayList<CustomerPO>();
		}
	}
	
	public int addCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNum().equals(cpo.getNum())){
				return ErrorTW.haveAlreadyExist;
			}
		}
		list.add(cpo);
		try {
			FileOpr.writeFile(FileName.customerFile, list);
			LogDATA log = new LogDATA();
			log.addCustomer(cpo);
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
					LogDATA log = new LogDATA();
					log.deleteCustomer(cpo);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 30002;
				}
			}
		}
		return ErrorTW.notFondCustomer;
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
		getList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum().equals(po.getNum())) {
				// if(!list.contains(findCustomer(newpo.getNum()))){
				list.remove(list.get(i));
				list.add(i, newpo);
				try {
					FileOpr.writeFile(FileName.customerFile, list);
					LogDATA log = new LogDATA();
					log.updateCustomer(newpo);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ErrorTW.webError;
				}
			}
		}
		return ErrorTW.cannotOperateForNotExist;
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

	public CustomerPO findCustomer(String nameOrnumber) throws RemoteException {
		CustomerPO tofind = null;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getNum().equals(nameOrnumber)||list.get(i).getName().equals(nameOrnumber)){
				tofind =  list.get(i);
				break;
			}
		}
		return tofind;
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
