package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public interface StockApplicationService extends MutiRoleService{
	public int submitIncreaseToMatch(IncreaseToMatchVO vo);
	public int submitDecreaseToMatch(DecreaseToMatchVO vo);
	public int submitPresentList(PresentListVO vo);
}
