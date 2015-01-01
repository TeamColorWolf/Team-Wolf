package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public interface ManageApproveService extends MutiRoleService{
	public ArrayList<ApplicationVO> getUnsetApplicationList();//待审批的单据list
	public int approveOver(ArrayList<ApplicationVO> list);//审批完成的处理
}
