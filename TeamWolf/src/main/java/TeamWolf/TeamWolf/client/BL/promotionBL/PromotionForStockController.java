package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class PromotionForStockController implements PromotionForStockService{
	
	PromotionForOther b;
	
	public PromotionForStockController(String IP){
		b = new PromotionForOther(IP);
	}

	public ArrayList<SpecialGoodsPromotionVO> specialGoodsPackage() {
		// TODO Auto-generated method stub
		return b.specialGoodsPackage();
	}
	
}
