package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class PromotionForStockController implements PromotionForStockService{
	
	PromotionBL bl;
	
	public PromotionForStockController(String IP){
		bl = new PromotionBL(IP);
	}

	public ArrayList<SpecialGoodsPromotionVO> specialGoodsPackage() {
		// TODO Auto-generated method stub
		return bl.specialGoodsPackage();
	}
	
}
