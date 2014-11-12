package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLAssistant {

	public int getPresentDate(){
		//获得当前日期
		return 0;
	}
	public boolean canAdd(TypeVO t){
		//检查此商品分类是否能加入系统的逻辑判断
		return true;
	}
	public boolean canDel(TypeVO t){
		//检查是否能将此分类从系统中删除的逻辑判断
		return true;
	}
	public boolean canUpd(TypeVO t){
		//检查是否能修改系统中此商品分类的逻辑判断
		return true;
	}
	
	
	//逻辑判断中需要用到的私有方法
	private boolean isExisted(TypeVO t){
		return false;
	}
	private boolean haveChild(TypeVO t){
		return false;
	}
	
}
