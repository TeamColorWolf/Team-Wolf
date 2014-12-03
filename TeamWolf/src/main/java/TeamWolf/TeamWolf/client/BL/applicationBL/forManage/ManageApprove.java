package TeamWolf.TeamWolf.client.BL.applicationBL.forManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ManageApprove extends ApplicationBL{
	
	public ManageApprove(String IP) {
		super(IP);
		URL = "rmi://" + IP + "/approveDATAservice";
	}
	
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		initial();
		return voList;
	}
	
	public int approveOver(ArrayList<ApplicationVO> list){
		//TODO 
		System.out.println("approve over!");
		return 0;
	}
	
	private void initial(){
		try {
			approve = (ApproveDATAservice)Naming.lookup(URL);
			poList = approve.getUnsetApplicationList();
			voList = new ArrayList<ApplicationVO>();
			if(poList != null){
				for(int i = 0; i < poList.size(); i++){
					voList.add(getVOfromPO(poList.get(i)));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
