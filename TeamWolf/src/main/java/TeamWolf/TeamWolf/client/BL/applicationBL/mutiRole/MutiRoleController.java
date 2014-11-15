package TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.MutiRoleService;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class MutiRoleController implements MutiRoleService{
	protected String IP;
	
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		return new MutiRoleFunction(IP).getApprovalApplicationList();
	}
	
	public ApplicationVO findApplication(String number){
		return new MutiRoleFunction(IP).findApplication(number);
	}
	
	public ArrayList<String> getResult(String workNumber){
		return new MutiRoleFunction(IP).getResult(workNumber);
	}
	
}
