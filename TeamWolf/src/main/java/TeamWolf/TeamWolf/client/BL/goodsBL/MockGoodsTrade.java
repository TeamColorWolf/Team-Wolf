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
public class MockGoodsTrade {

    GoodsBLAssistant_stub assistant ;
	
	public MockGoodsTrade(String iP) {
		// TODO Auto-generated constructor stub
		assistant=new GoodsBLAssistant_stub(iP);
	}
	public int goodsExport(SaleListVO sl){
		//分析销售单
		System.out.println("处理销售！");
		//处理销售
		return 0;
	}
	public int goodsExportReject(SaleRejectListVO srl){
		//分析销售退货单
		System.out.println("处理销售退货！");
		//处理销售退货
		return 0;
	}
	public int goodsImport(ImportListVO il){
		//分析进货单
		System.out.println("处理进货！");
		//处理进货
		return 0;
	}
	public int goodsImportReject(ImportRejectListVO irl){
		//分析进货退货单
		System.out.println("处理销售退货！");
		//处理进货退货
		return 0;
	}
	
	public int presentList(ArrayList<GoodsVO> present, String operator, CustomerVO customer){
		//分析赠送单
		System.out.println("提交赠送单！");
		//调用applicationBL，提交申请
		return 0;
	}
	
	public int handlePresentList(PresentListVO p){
		//分析赠送单
		//判断能否执行
		System.out.println("处理赠送单！");
		//执行
		return 0;
	}
		
	public PresentListVO checkPL(int number) {
		// TODO Auto-generated method stub
	
		
		return null;
	}
	
	public ArrayList<PresentListVO> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		ArrayList<PresentListVO> apl=new ArrayList<PresentListVO>();
		System.out.println("查看赠送单列表！");
		return apl;
	}
}
