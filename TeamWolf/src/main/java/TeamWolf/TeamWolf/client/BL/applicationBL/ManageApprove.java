package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ManageApprove extends ApplicationBL{
	private ApproveDATAservice approve;
	
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			poList = approve.getUnsetApplicationList();
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
	
	public int approveOver(ArrayList<ApplicationVO> list){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			return approve.approveOver(poList);
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
		return 0;
	}
}
