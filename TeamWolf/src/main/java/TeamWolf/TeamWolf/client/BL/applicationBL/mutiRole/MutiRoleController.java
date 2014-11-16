package TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.MutiRoleService;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class MutiRoleController implements MutiRoleService{
	MutiRoleFunction fun;
	
	public MutiRoleController(String IP){
		fun = new MutiRoleFunction(IP);
	}
	
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		return fun.getApprovalApplicationList();
	}
	
	public ApplicationVO findApplication(String number){
		return fun.findApplication(number);
	}
	
	public ArrayList<String> getResult(String workNumber){
		return fun.getResult(workNumber);
	}
	
}
