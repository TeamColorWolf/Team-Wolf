package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPpromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class PromotionBL implements PromotionBLservice{

	public int createForVIP(CustomerVO cvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createGoods(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createGifts(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createDiscount(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createCashCoupon(String discount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PromotionVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionVO> selectShow(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delPromotion(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setForVIP(ForVIPpromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void setForSpecialGoods(SpecialGoodsPromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void setForPrice(ForPricePromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	public PromotionVO getPromotion(String describe) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delet(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<String> check() {
		// TODO Auto-generated method stub
		return null;
	}

}
