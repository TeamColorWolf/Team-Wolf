package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApplicationBL {
	ArrayList<Application> list;
	ArrayList<ApplicationPO> poList;
	ArrayList<ApplicationVO> voList;
	String URL;
	private ApproveDATAservice approve;
	
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
