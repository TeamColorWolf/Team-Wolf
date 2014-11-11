package TeamWolf.TeamWolf.client.BL.manageBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.ApproveBLservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApproveController implements ApproveBLservice {

	public ArrayList<ApplicationVO> checkApplication() {
		// TODO Auto-generated method stub
		return new ApproveBL().checkApplication();
	}

	public int approveOver(ArrayList<ApplicationVO> list) {
		// TODO Auto-generated method stub
		return new ApproveBL().approveOver(list);
	}

}
