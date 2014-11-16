package TeamWolf.TeamWolf.client.BL.manageBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.ApproveBLservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApproveController implements ApproveBLservice {

	ApproveBL app;
	
	public ApproveController(String IP){
		app = new ApproveBL(IP);
	}
	
	public ArrayList<ApplicationVO> checkApplication() {
		// TODO Auto-generated method stub
		return app.checkApplication();
	}

	public int approveOver(ArrayList<ApplicationVO> list) {
		// TODO Auto-generated method stub
		return app.approveOver(list);
	}

}
