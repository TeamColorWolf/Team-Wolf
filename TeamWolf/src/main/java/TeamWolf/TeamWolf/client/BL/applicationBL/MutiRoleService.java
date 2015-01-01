package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public interface MutiRoleService {
	public ArrayList<ApplicationVO> getApprovalApplicationList();//审批通过的单据list
	public ApplicationVO findApplication(String number);
	public ArrayList<String> getResult(String workNumber);
}
