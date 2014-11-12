package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class ManageApproveController extends MutiRoleController implements ManageApproveService{
	
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		return new ManageApprove(IP).getUnsetApplicationList();
	}
	
	public int approveOver(ArrayList<ApplicationVO> list){
		return new ManageApprove(IP).approveOver(list);
	}
}
