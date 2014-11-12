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
		//分析销售单
		
		//处理销售
		return 0;
	}
	public int goodsExportReject(SaleRejectListPO srl){
		//分析销售退货单
		
		//处理销售退货
		return 0;
	}
	public int goodsImport(ImportListPO il){
		//分析进货单
		
		//处理进货
		return 0;
	}
	public int goodsImportReject(ImportRejectListPO irl){
		//分析进货退货单
		
		//处理进货退货
		return 0;
	}
	
	public int presentList(GoodsVO present){
		//分析赠送单
		
		//调用applicationBL，提交申请
		return 0;
	}
	
	public int handlePresentList(PresentList p){
		//分析赠送单
		//判断能否执行
		//执行
		return 0;
	}
		
	public PresentList checkPL(int number) {
		// TODO Auto-generated method stub
		PresentList pl=new PresentList();
		return pl;
	}
	
	public ArrayList<PresentList> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		ArrayList<PresentList> apl=new ArrayList<PresentList>();
		return apl;
	}
}
