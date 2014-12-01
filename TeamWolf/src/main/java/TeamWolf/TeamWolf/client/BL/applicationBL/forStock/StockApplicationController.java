package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.StockApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public class StockApplicationController extends MutiRoleController implements StockApplicationService{
	
	StockSubmit submit;
	StockRead read;
	
	public StockApplicationController(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		submit=new StockSubmit(IP);
		read=new StockRead(IP);
	}

	
	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		return submit.submitIncreaseToMatch(vo);
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		return submit.submitDecreaseToMatch(vo);
	}
	
	public int submitPresentList(PresentListVO vo){
		return submit.submitPresentList(vo);
	}
	
	public ArrayList<String> getITMList(){			       
		
		return read.getITMList();
	}
	
	public ArrayList<String> getDTMList(){
	    
		return read.getDTMList();
	}

}
