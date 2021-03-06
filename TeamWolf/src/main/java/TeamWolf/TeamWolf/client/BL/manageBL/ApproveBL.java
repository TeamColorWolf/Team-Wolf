package TeamWolf.TeamWolf.client.BL.manageBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forManage.ManageApproveController;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApproveBL{
	ManageApproveService MAs;
	Application app;
	String URL;
	
	public ApproveBL(String IP){
		MAs = new ManageApproveController(IP);
	}
	public ArrayList<ApplicationVO> checkApplication() {
		// TODO Auto-generated method stub
		return MAs.getUnsetApplicationList();
	}

	public int approveOver(ArrayList<ApplicationVO> list) {
		// TODO Auto-generated method stub
		return MAs.approveOver(list);
	}
	
	public ApplicationVO findApplication(String number){
		return MAs.findApplication(number);
	}
	
	public int change(ApplicationVO vo){
		return app.change(vo);
	}

}
