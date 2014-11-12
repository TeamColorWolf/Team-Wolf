package TeamWolf.TeamWolf.client.BL.goodsBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PresentList;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsTrade_stub {

    GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	public int goodsExport(SaleListPO sl){
		;
		return 0;
	}
	public int goodsExportReject(SaleRejectListPO srl){
		return 0;
	}
	public int goodsImport(ImportListPO il){
		return 0;
	}
	public int goodsImportReject(ImportRejectListPO irl){
		return 0;
	}
	
	public int presentList(GoodsVO present){
		return 0;
	}
	
	public int handlePresentList(PresentList p){
		return 0;
	}
		
	public PresentList checkPL(int number) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<PresentList> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		return null;
	}
}
