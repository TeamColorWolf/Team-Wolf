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

	
	public int addGood(GoodsVO g){		
		return 0;
	}
	public int delGood(GoodsVO g){
		return 0;
	}
	public int updGood(GoodsVO g){
		return 0;
	}
	public int finGood(GoodsVO g){
		return 0;
	}
	public GoodsList shoGood(GoodsVO g){
		return null;
	}
	public GoodsStockList shoStockList(int beginDate, int endDate){
		return null;
	}
	public GoodsStockList shoStockDaily(){
		return null;
	}
	public int goodsExport(/*���۵�����*/){
		return 0;
	}
	public int goodsExportReturn(/*�����˻�������*/){
		return 0;
	}
	public int goodsImport(/*���������*/){
		return 0;
	}
	public int goodsImportReturn(/*����˻�������*/){
		return 0;
	}
	public int PresentList(GoodsVO g){
		return 0;
	}
	public int handlePresentList(PresentList p){
		return 0;
	}
	public int setGoodWL(GoodsVO g){
		return 0;
	}
	public int increaseGood(GoodsVO g){
		return 0;
	}
	public int decreaseGood(GoodsVO g){
		return 0;
	}
	public int MonitoringWL(GoodsVO g){
		return 0;
	}
	public int increaseToMatch(GoodsVO toIncrease) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int decreaseToMatch(GoodsVO toDecrease) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int setWaringLine(GoodsVO goodWL) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int presentList(GoodsVO present) {
		// TODO Auto-generated method stub
		return 0;
	}
	public TeamWolf.TeamWolf.client.vo.PresentList checkPL(int number) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<TeamWolf.TeamWolf.client.vo.PresentList> shoSimplifiedPL() {
		// TODO Auto-generated method stub
		return null;
	}
	public int addGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}
	public GoodsVO finGoods(GoodsVO g) {
		// TODO Auto-generated method stub
		return null;
	}
	public GoodsList shoGoods() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
