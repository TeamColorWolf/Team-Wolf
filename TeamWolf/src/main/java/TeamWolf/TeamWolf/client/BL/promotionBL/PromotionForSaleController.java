package TeamWolf.TeamWolf.client.BL.promotionBL;

import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionForSaleController implements PromotionForSaleService{
	
	PromotionBL bl;
	
	public PromotionForSaleController(String IP){
		bl = new PromotionBL(IP);
	}
	
	public SaleListVO adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		return bl.adaptPromotionForSaleList(vo);
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		return bl.adaptPromotionForImportList(vo);
	}

}
