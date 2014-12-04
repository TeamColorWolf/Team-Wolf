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
		URL = "rmi://" + IP + "/approveDATAservice";
	}
	
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			poList = approve.getApprovalApplicationList();
			voList = new ArrayList<ApplicationVO>();
			if(poList != null){
				for(int i = 0; i < poList.size(); i++){
					voList.add(this.getVOfromPO(poList.get(i)));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
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
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getResult(String workNumber){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			return approve.getResult(workNumber);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
