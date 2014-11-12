package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

/**
 * 
 * @author XYJ
 *
 */
public class PresentList {

	private ArrayList<GoodsVO> pl=new ArrayList<GoodsVO>();
	private String presentListInfo;
	
	public void addPresent(GoodsVO p){
		pl.add(p);
	}
	public ArrayList<GoodsVO> getPList(){
		return pl;
	}
	public String getPresentListInfo(){
		return presentListInfo;
	}
}
