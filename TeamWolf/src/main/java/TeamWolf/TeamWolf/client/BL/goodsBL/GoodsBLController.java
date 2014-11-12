package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodMonService;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodTService;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsBLController implements GoodManService,GoodTService,GoodMonService {

	GoodsManager gma;
	GoodsMonitor gmo;
	GoodsTrade gt;
	
	public GoodsBLController(){
		gma=new GoodsManager();
		gmo=new GoodsMonitor();
		gt=new GoodsTrade();
	}
	
	
	public GoodsStockList shoStockList(int beginDate, int endDate){
		return gma.shoStockList(beginDate, endDate);
	}
	public GoodsStockList shoStockDaily(){
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
	public int handlePresentList(PresentList p){
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
	public int presentList(GoodsVO present) {
		// TODO Auto-generated method stub
		return gt.presentList(present);
	}
	public PresentList checkPL(int number) {
		// TODO Auto-generated method stub
		return gt.checkPL(number);
	}
	public ArrayList<PresentList> shoSimplifiedPL() {
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
	public GoodsList shoGoods() {
		// TODO Auto-generated method stub
		return gma.shoGoods();
	}
	
	
}
