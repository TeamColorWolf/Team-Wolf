package TeamWolf.TeamWolf.client.BL.applicationBL.forManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * 
 * @author WHJ
 *
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
		int success = 0;
		int somethingError = 0;//记录是否有失败
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).condition == 1){
					System.out.println(list.get(i).number + " approval");
					success = Application.getApplication(list.get(i), IP).approve();
					if(success != 0){
						System.out.println(list.get(i).number + "approve failed");
						somethingError = ErrorTW.someApplicationFailed;
					}
				}
				else if(list.get(i).condition == -1){
					Application.getApplication(list.get(i), IP).reject();
				}
			}
		}
		return somethingError;
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
			else{
				voList = null;
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
