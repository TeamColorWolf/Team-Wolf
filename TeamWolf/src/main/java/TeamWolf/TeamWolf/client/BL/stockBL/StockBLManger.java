package TeamWolf.TeamWolf.client.BL.stockBL;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.StockBLservice;
import TeamWolf.TeamWolf.client.vo.*;

public class StockBLManger implements StockBLservice{

	StockBLAssistant assistant;

	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TypeList shoAllType() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addGood(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delGood(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updGood(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int finGood(GoodsVO g) {
		// TODO Auto-generated method stub
		return 0;
	}

	public GoodList shoGood() {
		// TODO Auto-generated method stub
		return null;
	}

	public GoodsStockList shoStockList(int beginDate, int endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoodsStockList shoStockDaily() {
		// TODO Auto-generated method stub
		return null;
	}

	public int presentList(GoodsVO present) {
		// TODO Auto-generated method stub
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
	
	
}
