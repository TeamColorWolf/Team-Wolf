package TeamWolf.TeamWolf.client.BLservice.manageBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public interface ApproveBLservice {
	public ArrayList<ApplicationVO> checkApplication();
	
	public int approveOver(ArrayList<ApplicationVO> list);
	
	public ApplicationVO findApplication(String number);
	
	public int change(ApplicationVO vo);
}
