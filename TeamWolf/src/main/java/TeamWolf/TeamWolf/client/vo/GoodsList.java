package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsList {

	ArrayList<GoodsVO> gList=new ArrayList<GoodsVO>();
	
	public void addGood(GoodsVO g){
		gList.add(g);
	}
	public String getListInfo(){
		return null;
	}
}
