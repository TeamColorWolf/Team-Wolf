package TeamWolf.TeamWolf.client.BLservice.manageBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPpromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public interface PromotionBLservice {
	public void setForVIP(ForVIPpromotionVO vo);
	
	public void setForSpecialGoods(SpecialGoodsPromotionVO vo);
	
	public void setForPrice(ForPricePromotionVO vo);
	
	public PromotionVO getPromotion(String describe);
	
	public int delet(PromotionVO vo);//删除当前查看的Promotion
	
	public ArrayList<String> check();//列表返回促销策略声明
}
