package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsStockList {

	ArrayList<GoodStockVO> goodSL=new ArrayList<GoodStockVO>();
	
	public void addGoodSVO(GoodStockVO gs){
		goodSL.add(gs);
	}
	public String getStockInfo(){
		return null;
	}
}
