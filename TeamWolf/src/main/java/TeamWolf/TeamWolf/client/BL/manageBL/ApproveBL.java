package TeamWolf.TeamWolf.client.BL.manageBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationController;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApproveBL{
	ApplicationController controller;
	public ArrayList<ApplicationVO> checkApplication() {
		// TODO Auto-generated method stub
		return controller.getUnsetApplicationList();
	}

	public int approveOver(ArrayList<ApplicationVO> list) {
		// TODO Auto-generated method stub
		return controller.approveOver(list);
	}

}
