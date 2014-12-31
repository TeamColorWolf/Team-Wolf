package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

/***
 * 此接口包含商品交易类（进货、进货退货、销售、销售退货、赠送单）功能
 * @author XYJ
 *
 */
public interface GoodTService {


	public PresentListVO checkPL(int number);
	
	public ArrayList<PresentListVO> shoSimplifiedPL();
	
	public int goodsExport(SaleListVO sl);
	
	public int goodsExportReject(SaleRejectListVO srl);
	
	public int goodsImport(ImportListVO il);
	
	public int goodsImportReject(ImportRejectListVO irl);
	
}
