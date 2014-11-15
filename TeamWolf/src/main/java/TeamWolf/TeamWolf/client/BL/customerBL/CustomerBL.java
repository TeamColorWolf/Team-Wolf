package TeamWolf.TeamWolf.client.BL.customerBL;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.customerDATAservice.CustomerDATAservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class CustomerBL implements CustomerBLservice, CustomerDATAservice{
	
//	private String number;
//	private String type;
//	private String level;
//	private String tel;
//	private String address;
//	private String postnumber;
//	private String email;
//	private double shouldpay;
//	private double shouldcollect;
//	private double couldcollect;
//	private String defaultuser;

	
	public String getNumber() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getType() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getLevel() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getTel() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getAddress() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getPostnumber() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getEmail() {
		// TODO 自动生成的方法存根
		return null;
	}

	public double getShouldpay() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getCouldCollect() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public double getShouldCollect() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public String getDefaultUser() {
		// TODO 自动生成的方法存根
		return null;
	}

	public int setNumber(String number) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setType(String type) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setLevel(String level) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setTel(String tel) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setAddress(String address) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setPostnumber(String postnumber) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setEmail(String email) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setShouldpay(double shouldpayUPANDDOWN) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setCouldCollect(double couldpayUPANDDOWN) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setShouldCollect(double shouldcollectUPANDDOWN) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int setDefaultUser(String defaultUser) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public void addCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public CustomerPO modCustomer(CustomerPO cpo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 找到客户PO
	 * @param name
	 * @param number
	 * @return
	 * @throws RemoteException
	 */
	public CustomerPO findCustomer(String name, String number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
