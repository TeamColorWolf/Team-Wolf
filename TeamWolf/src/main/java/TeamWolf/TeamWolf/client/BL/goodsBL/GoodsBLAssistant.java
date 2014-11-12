package TeamWolf.TeamWolf.client.BL.goodsBL;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */

public class GoodsBLAssistant {

	public int getPresentDate(){
		//返回当前日期
    	return 0;
    }
	public boolean canAdd(GoodsVO g){
		//判断商品能否被加入系统
		return true;
	}
	public boolean canDel(GoodsVO g){
		//判断商品能否从系统中删除
		return true;
	}
	public boolean canUpd(GoodsVO g){
		//判断商品能否在系统中被修改
		return true;
	}
	public boolean canFin(GoodsVO g){
		//判断能否找到某商品
		return true;
	}	
	public boolean isExisted(GoodsVO g){
    	return true;
    }
	public boolean beenTraded(GoodsVO g){
		return true;
	}
    
}
