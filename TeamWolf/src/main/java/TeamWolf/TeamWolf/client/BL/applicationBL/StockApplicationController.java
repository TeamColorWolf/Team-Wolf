package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public class StockApplicationController extends MutiRoleController implements StockApplicationService{

	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		return new StockSubmit(IP).submitIncreaseToMatch(vo);
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		return new StockSubmit(IP).submitDecreaseToMatch(vo);
	}
	
	public int submitPresentList(PresentListVO vo){
		return new StockSubmit(IP).submitPresentList(vo);
	}

}
