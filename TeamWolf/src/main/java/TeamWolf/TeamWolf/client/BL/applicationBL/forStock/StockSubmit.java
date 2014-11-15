package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
/**
 * Author WHJ
 */
public class StockSubmit extends ApplicationBL{
	
	public StockSubmit(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
	}

	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		IncreaseToMatch app = new IncreaseToMatch(vo, URL);//有的表单没有写继承Application，自行补充
		return app.submit();
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		return 0;
	}
	
	public int submitPresentList(PresentListVO vo){
		return 0;
	}
}
