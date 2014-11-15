package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApplicationBL {
	protected ArrayList<Application> list;
	protected ArrayList<ApplicationPO> poList;
	protected ArrayList<ApplicationVO> voList;
	protected String URL;
	protected ApproveDATAservice approve;
	
	public ApplicationBL(String IP){
		
	}
	
}
