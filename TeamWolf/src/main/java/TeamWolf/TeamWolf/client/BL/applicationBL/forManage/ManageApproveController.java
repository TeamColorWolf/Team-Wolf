package TeamWolf.TeamWolf.client.BL.applicationBL.forManage;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class ManageApproveController extends MutiRoleController implements ManageApproveService{
	
	ManageApprove app;
	
	public ManageApproveController(String IP){
		super(IP);
	}
	
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		return app.getUnsetApplicationList();
	}
	
	public int approveOver(ArrayList<ApplicationVO> list){
		return app.approveOver(list);
	}
}
