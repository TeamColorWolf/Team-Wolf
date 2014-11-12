package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsStockList {

	ArrayList<GoodsStockVO> goodsSL=new ArrayList<GoodsStockVO>();
	String GStockListInfo;
	
	public void addGoodSVO(GoodsStockVO gs){
		goodsSL.add(gs);
	}
	public String getStockInfo(){
		GStockListInfo="";
		for(GoodsStockVO gs: goodsSL){
			GStockListInfo+=gs.getInfo();
		}
		return GStockListInfo;
	}
}
