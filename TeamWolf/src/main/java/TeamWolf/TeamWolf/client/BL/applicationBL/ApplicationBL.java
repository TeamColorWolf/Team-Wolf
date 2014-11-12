package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
/**
 * Author WHJ
 */
public class ApplicationBL {
	ArrayList<Application> list;
	ArrayList<ApplicationPO> poList;
	ArrayList<ApplicationVO> voList;
	String URL;
	ApproveDATAservice approve;
	
	public ApplicationBL(String IP){
		
	}
	
}
