package TeamWolf.TeamWolf.client.BLservice.manageBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public interface PromotionBLservice {
	public int setForVIP(ForVIPPromotionVO vo);
	
	public int setForSpecialGoods(SpecialGoodsPromotionVO vo);
	
	public int setForPrice(ForPricePromotionVO vo);
	
	public PromotionVO getPromotion(String describe);
	
	public int delet(PromotionVO vo);//删除当前查看的Promotion
	
	public int update(PromotionVO vo);//修改当前的Promotion
	
	public ArrayList<PromotionVO> check();//列表返回促销策略声明
}
