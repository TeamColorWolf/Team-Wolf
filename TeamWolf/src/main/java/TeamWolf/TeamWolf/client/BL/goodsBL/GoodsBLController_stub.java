package TeamWolf.TeamWolf.client.BL.goodsBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsListVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class GoodsBLController_stub {

	MockGoodsManager gma;
	MockGoodsMonitor gmo;
	MockGoodsTrade gt;
	

	
	
	public GoodsBLController_stub(String IP) {
		// TODO Auto-generated constructor stub
		gma=new MockGoodsManager(IP);
		gmo=new MockGoodsMonitor(IP);
		gt=new MockGoodsTrade(IP);
	}


	public GoodsStockListVO shoStockList(int beginDate, int endDate){
		return gma.shoStockList(beginDate, endDate);
	}
	public GoodsStockListVO shoStockDaily(){
		return gma.shoStockDaily();
	}
	public int goodsExport(SaleListVO sl){
		return gt.goodsExport(sl);
	}
	public int goodsExportReject(SaleRejectListVO srl){
		return gt.goodsExportReject(srl);
	}
	public int goodsImport(ImportListVO il){
		return gt.goodsImport(il);
	}
	public int goodsImportReject(ImportRejectListVO irl){
		return gt.goodsImportReject(irl);
	}
	public int handlePresentList(PresentListVO p){
		return gt.handlePresentList(p);
	}
	public int MonitoringWL(GoodsVO g){
		return gmo.MonitoringWL(g);
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		return gmo.increaseToMatch(toIncrease);
	}
	public int decreaseToMatch(GoodsVO toDecrease) {
		// TODO Auto-generated method stub
		return gmo.decreaseToMatch(toDecrease);
	}
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		return gmo.setWaringLine(goodWL);
	}
	public int presentList(ArrayList<GoodsVO> present, String operator, CustomerVO customer) {
		// TODO Auto-generated method stub
		return gt.presentList(present, operator, customer);
	}
	public PresentListVO checkPL(int number) {
		// TODO Auto-generated method stub
		return gt.checkPL(number);
	}
	public ArrayList<PresentListVO> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		return gt.shoSimplifiedPL();
	}
	public int addGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return gma.addGoods(g);
	}
	public int delGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return gma.delGoods(g);
	}
	public int updGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return gma.updGoods(g);
	}
	public GoodsVO finGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return gma.finGoods(g);
	}
	public GoodsListVO shoGoods() {
		// TODO Auto-generated method stub
		return gma.shoGoods();
	}
}
