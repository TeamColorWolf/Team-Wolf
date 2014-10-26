package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class GoodsStockList {

	ArrayList<GoodStockVO> goodSL=new ArrayList<GoodStockVO>();
	
	public void addGoodSVO(GoodStockVO gs){
		goodSL.add(gs);
	}
	public String getStockInfo(){
		return null;
	}
}
