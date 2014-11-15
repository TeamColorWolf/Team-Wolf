package TeamWolf.TeamWolf.client.BL.promotionBL;

import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
/**
 * 
 * @author WHJ
 *为销售人员每次创建销售单和进货单后，调用以下2个方法对填写的初始单据的数据依照特价包进行修改
 */
public interface PromotionForSaleService {
	public SaleListVO adaptPromotionForSaleList(SaleListVO vo);
	
	public ImportListVO adaptPromotionForImportList(ImportListVO vo);
}
