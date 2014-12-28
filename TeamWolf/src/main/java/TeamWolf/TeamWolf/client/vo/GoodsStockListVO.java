package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsStockListVO implements Serializable{

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
	public ArrayList<GoodsStockVO> getGoodsSL(){
		return goodsSL;
	}
}
