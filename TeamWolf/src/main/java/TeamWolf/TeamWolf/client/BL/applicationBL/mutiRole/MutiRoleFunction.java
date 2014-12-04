package TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class MutiRoleFunction extends ApplicationBL{

	public MutiRoleFunction(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		URL = "rmi://" + IP + "/approveDATAservice";
	}
	
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			poList = approve.getApprovalApplicationList();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voList;
	}
	
	public ApplicationVO findApplication(String number){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			ApplicationPO po = approve.findApplication(number);
			ApplicationVO vo = null;
			return vo;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getResult(String workNumber){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			return approve.getResult(workNumber);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
