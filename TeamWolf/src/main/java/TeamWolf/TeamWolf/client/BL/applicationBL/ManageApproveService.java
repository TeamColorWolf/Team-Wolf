package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public interface ManageApproveService {
	public ArrayList<ApplicationVO> getUnsetApplicationList();
	public int approveOver(ArrayList<ApplicationVO> list);
}
