package TeamWolf.TeamWolf.client.BLservice.manageBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public interface PromotionBLservice {
	public int addPromotion(PromotionVO vo);
	
	public PromotionVO getPromotion(String number);
	
	public int delet(String number);//删除当前查看的Promotion
	
	public int update(PromotionVO vo);//修改当前的Promotion
	
	public ArrayList<PromotionVO> check();//列表返回促销策略声明
	
	public ArrayList<TypeVO> typeList();
	
	public GoodsVO findGoods(String number);
}
