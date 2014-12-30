package TeamWolf.TeamWolf.server.applicationDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;
import TeamWolf.TeamWolf.server.logDATA.LogDATA;
//账户类单据处理
public class FinanceApplicationDATA extends UnicastRemoteObject implements FinanceApplicationDATAservice{

	private ArrayList<RecieptApplicationPO> recieptlist;
	private ArrayList<PaymentApplicationPO> paymentlist;
	private ArrayList<CashApplicationPO> cashlist;
	public FinanceApplicationDATA() throws RemoteException {
		super();
		init();
		if(recieptlist==null){
			recieptlist = new ArrayList<RecieptApplicationPO>();
		}
		if(paymentlist== null){
			paymentlist = new ArrayList<PaymentApplicationPO>();
		}
		if(cashlist==null){
			cashlist = new ArrayList<CashApplicationPO>();
		}
		
		// TODO Auto-generated constructor stub
	}
	//初始化
	private void init() {
		try {
			recieptlist =(ArrayList<RecieptApplicationPO>)FileOpr.readFile(FileName.recieptFile);
			paymentlist =(ArrayList<PaymentApplicationPO>)FileOpr.readFile(FileName.paymentFile);
			cashlist=(ArrayList<CashApplicationPO>)FileOpr.readFile(FileName.cashFile);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
//提交收款单
	public int submitRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		int success=0;
		recieptlist.add(po);
		try {
			FileOpr.writeFile(FileName.recieptFile,recieptlist);
			LogDATA log = new LogDATA();
			log.submitApplication(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			success=-1;
		}
		return success;
	}
//提交付款单
	public int submitPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		int success=0;
		paymentlist.add(po);
		try {
			FileOpr.writeFile(FileName.paymentFile, paymentlist);
			LogDATA log = new LogDATA();
			log.submitApplication(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//提交现金费用单
	public int submitCashApplication(CashApplicationPO po)
			throws RemoteException {
		int success=0;
		cashlist.add(po);
		try {
			FileOpr.writeFile(FileName.cashFile, cashlist);
			LogDATA log = new LogDATA();
			log.submitApplication(po);
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//通过收款单
	public int approvalRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<recieptlist.size();i++){
			if(po.number.equals(recieptlist.get(i).number)){
				recieptlist.remove(i);
				recieptlist.add(po);
			 	break;
			}
		}
		try {
			FileOpr.writeFile(FileName.recieptFile,recieptlist);
			success = 0;
			LogDATA log = new LogDATA();
			log.approveApplication(po);
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//通过付款单
	public int approvalPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<paymentlist.size();i++){
			if(po.number.equals(paymentlist.get(i).number)){
				paymentlist.remove(i);
				paymentlist.add(po);
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.paymentFile,paymentlist);
			LogDATA log = new LogDATA();
			log.approveApplication(po);
			success = 0;
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//通过现金费用单
	public int approvalCashApplication(CashApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<cashlist.size();i++){
			if(po.number.equals(cashlist.get(i).number)){
				cashlist.remove(i);
				cashlist.add(po);
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.cashFile,cashlist);
			LogDATA log = new LogDATA();
			log.approveApplication(po);
			success = 0;
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//驳回收款单
	public int rejectRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<recieptlist.size();i++){
			if(po.number.equals(recieptlist.get(i).number)){
				recieptlist.remove(i);
				recieptlist.add(po);
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.recieptFile,recieptlist);
			LogDATA log = new LogDATA();
			log.rejectApplication(po);
			success = 0;
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//驳回付款单
	public int rejectPaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<paymentlist.size();i++){
			if(po.number.equals(paymentlist.get(i).number)){
				paymentlist.remove(i);
				paymentlist.add(po);
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.paymentFile,paymentlist);
			LogDATA log = new LogDATA();
			log.rejectApplication(po);
			success = 0;
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
//驳回现金费用单
	public int rejectCashApplication(CashApplicationPO po)
			throws RemoteException {
		int success=-1;
		for(int i=0;i<cashlist.size();i++){
			if(po.number.equals(cashlist.get(i).number)){
				cashlist.remove(i);
				cashlist.add(po);
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.cashFile,cashlist);
			LogDATA log = new LogDATA();
			log.rejectApplication(po);
			success = 0;
			return success;
		} catch (IOException e) {
			success=-1;
			e.printStackTrace();
		}
		return success;
	}
	//修改单据的方法
	public int changeRecieptApplication(RecieptApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changePaymentApplication(PaymentApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeCashApplication(CashApplicationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
//以下几个方法均用于获取所有的不同单据
	public ArrayList<RecieptApplicationPO> getRecieptlist() {
		return recieptlist;
	}

	public void setRecieptlist(ArrayList<RecieptApplicationPO> recieptlist) {
		this.recieptlist = recieptlist;
	}

	public ArrayList<PaymentApplicationPO> getPaymentlist() {
		return paymentlist;
	}

	public void setPaymentlist(ArrayList<PaymentApplicationPO> paymentlist) {
		this.paymentlist = paymentlist;
	}

	public ArrayList<CashApplicationPO> getCashlist() {
		return cashlist;
	}

	public void setCashlist(ArrayList<CashApplicationPO> cashlist) {
		this.cashlist = cashlist;
	}
	public ArrayList<RecieptApplicationPO> getAllRecieptList() {
		return recieptlist;
	}
	public ArrayList<PaymentApplicationPO> getAllPaymentList() {
		// TODO 自动生成的方法存根
		return paymentlist;
	}
	public ArrayList<CashApplicationPO> getAllCashList() {
		// TODO 自动生成的方法存根
		return cashlist;
	}

}
