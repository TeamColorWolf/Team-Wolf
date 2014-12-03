package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import TeamWolf.TeamWolf.client.BL.applicationBL.ApplicationBL;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
/**
 * Author WHJ
 */
public class StockSubmit extends ApplicationBL{
	
    String IP;
	
	public StockSubmit(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		this.IP=IP;
	}

	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		IncreaseToMatch app = new IncreaseToMatch(vo, IP);//有的表单没有写继承Application，自行补充
		return app.submit();
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		DecreaseToMatch app = new DecreaseToMatch(vo,  IP);
		return app.submit();
	}
	
	public int submitPresentList(PresentListVO vo){
		PresentList app = new PresentList(vo, IP);
		return app.submit();
	}
}
