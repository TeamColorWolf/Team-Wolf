package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class PresentList {

	ArrayList<GoodsVO> pl=new ArrayList<GoodsVO>();
	
	public void addPresent(GoodsVO p){
		pl.add(p);
	}
	public ArrayList<GoodsVO> getPList(){
		return pl;
	}
}
