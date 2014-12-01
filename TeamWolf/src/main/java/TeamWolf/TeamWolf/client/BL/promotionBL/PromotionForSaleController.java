package TeamWolf.TeamWolf.client.BL.promotionBL;

import TeamWolf.TeamWolf.client.vo.SaleListVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionForSaleController implements PromotionForSaleService{
	
	PromotionForOther b;
	
	public PromotionForSaleController(String IP){
		b = new PromotionForOther(IP);
	}
	
	public double adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		return b.adaptPromotionForSaleList(vo);
	}
}
