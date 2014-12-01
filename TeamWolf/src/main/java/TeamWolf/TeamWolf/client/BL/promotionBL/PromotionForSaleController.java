package TeamWolf.TeamWolf.client.BL.promotionBL;

import TeamWolf.TeamWolf.client.vo.ImportListVO;
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
	
	public SaleListVO adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		return b.adaptPromotionForSaleList(vo);
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		return b.adaptPromotionForImportList(vo);
	}

}
