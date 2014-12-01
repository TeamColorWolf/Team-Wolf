package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public interface ExternalService {

	public ArrayList<TypeVO> getLeaveType();
	
	public GoodsVO finGoods(String number);
	
	public int addSpecialPackage (SpecialGoodsPromotionVO sp);
	
	public ArrayList<IncreaseToMatchVO> getITM();
	
	public ArrayList<DecreaseToMatchVO> getDTM();

	public int handlePresentList(ArrayList<GiftForPromotionVO> gpl, String customer);
}
