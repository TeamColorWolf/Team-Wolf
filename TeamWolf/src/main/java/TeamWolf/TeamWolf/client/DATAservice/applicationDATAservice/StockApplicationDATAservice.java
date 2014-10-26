package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;

public interface StockApplicationDATAservice {
	public int submitIncreaseToMatch(IncreaseToMatchPO po);
	
	public int submitDecreaseToMatch(DecreaseToMatchPO po);
	
	public int submitPresentList(PresentListPO po);
	
	public int approvalIncreaseToMatch(IncreaseToMatchPO po);
	
	public int approvalDecreaseToMatch(DecreaseToMatchPO po);
	
	public int approvalPresentList(PresentListPO po);
}
