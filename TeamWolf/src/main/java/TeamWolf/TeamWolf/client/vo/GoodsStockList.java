package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsStockList {

	ArrayList<GoodsStockVO> goodSL=new ArrayList<GoodsStockVO>();
	
	public void addGoodSVO(GoodsStockVO gs){
		goodSL.add(gs);
	}
	public String getStockInfo(){
		return null;
	}
}
