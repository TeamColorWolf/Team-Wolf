package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public interface StockApplicationService extends MutiRoleService{
	
	public int submitIncreaseToMatch(IncreaseToMatchVO vo);
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo);
	
	public int submitPresentList(PresentListVO vo);
	
	public ArrayList<String> getITMList();
	
	public ArrayList<String> getDTMList();
	
	public int todayQuantityOfITM();
	
	public int todayQuantityOfDTM();
	
	public ArrayList<PresentListVO> getPresentList();
}
