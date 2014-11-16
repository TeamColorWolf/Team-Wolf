package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsListVO {

	public ArrayList<GoodsVO> gList=new ArrayList<GoodsVO>();
	public String GLInfo;
	
	public void addGood(GoodsVO g){
		gList.add(g);
	}
	public String getListInfo(){
		GLInfo="";
		for(GoodsVO g:gList){
			GLInfo+=g.getInfo();
		}
		return GLInfo;
	}
}
