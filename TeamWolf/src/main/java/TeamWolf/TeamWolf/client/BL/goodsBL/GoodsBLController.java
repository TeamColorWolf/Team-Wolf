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
    
	static String IP;
	GoodsManager gma;
	GoodsMonitor gmo;
	GoodsTrade gt;
	
	public GoodsBLController(String IP){
		this.IP=IP;
		gma=new GoodsManager(IP);
		gmo=new GoodsMonitor(IP);
		gt=new GoodsTrade(IP);
	}
	
	public GoodsBLController(){
		gma=new GoodsManager(IP);
		gmo=new GoodsMonitor(IP);
		gt=new GoodsTrade(IP);
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
	public int MonitoringWL(GoodsVO g){
		return gmo.MonitoringWL(g);
	}
	public int increaseToMatch(GoodsVO toIncrease, String operator) {
		// TODO Auto-generated method stub
		return gmo.increaseToMatch(toIncrease, operator);
	}
	public int decreaseToMatch(GoodsVO toDecrease, String operator) {
		// TODO Auto-generated method stub
		return gmo.decreaseToMatch(toDecrease, operator);
	}
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		return gmo.setWaringLine(goodWL);
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
	public ArrayList<GoodsVO> dimFinGoods(GoodsVO g){
		
		return gma.dimFinGoods(g);
	}
	public ArrayList<GoodsAlarmVO> getGoodsAlarm(){
		
		return gmo.getAlarmList();
	}
	
    /*public static void main(String[] args){
		
		GoodsBLController gbc=new GoodsBLController("192.168.1.102");
		GoodsListVO gl=gbc.shoGoods();
		ArrayList<GoodsVO> ggl=gl.gList;
		
		for(GoodsVO g :ggl){
			System.out.println(g.getNumber()+g.getName());
		}
	}*/
}
