package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.vo.*;
import TeamWolf.TeamWolf.client.po.*;

public class GoodsTrade {

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
