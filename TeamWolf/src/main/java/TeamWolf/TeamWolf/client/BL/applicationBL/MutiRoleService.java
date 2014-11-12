package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public interface MutiRoleService {
	public ArrayList<ApplicationVO> getApprovalApplicationList();
	public ApplicationVO findApplication(String number);
	public ArrayList<String> getResult(String workNumber);
}
