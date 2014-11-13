package TeamWolf.TeamWolf.client.BL.goodsBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsTrade_stub {

    GoodsBLAssistant assistant =new GoodsBLAssistant();
	
	public int goodsExport(SaleListVO sl){
		//分析销售单
		
		//处理销售
		return 0;
	}
	public int goodsExportReject(SaleRejectListVO srl){
		//分析销售退货单
		
		//处理销售退货
		return 0;
	}
	public int goodsImport(ImportListVO il){
		//分析进货单
		
		//处理进货
		return 0;
	}
	public int goodsImportReject(ImportRejectListVO irl){
		//分析进货退货单
		
		//处理进货退货
		return 0;
	}
	
	public int presentList(ArrayList<GoodsVO> present, String operator, CustomerVO customer){
		//分析赠送单
		
		//调用applicationBL，提交申请
		return 0;
	}
	
	public int handlePresentList(PresentListVO p){
		//分析赠送单
		//判断能否执行
		//执行
		return 0;
	}
		
	public PresentListVO checkPL(int number) {
		// TODO Auto-generated method stub
		PresentListVO pl=new PresentListVO();
		return pl;
	}
	
	public ArrayList<PresentListVO> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		ArrayList<PresentListVO> apl=new ArrayList<PresentListVO>();
		return apl;
	}
}
