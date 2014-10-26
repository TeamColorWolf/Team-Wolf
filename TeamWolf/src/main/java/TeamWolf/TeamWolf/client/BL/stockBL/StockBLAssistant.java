package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLAssistant {

	
	public boolean canAdd(TypeVO t){
		return true;
	}
	public boolean canDel(TypeVO t){
		return true;
	}
	public boolean canUpd(TypeVO t){
		return true;
	}
	public boolean isExisted(TypeVO t){
		return false;
	}
	public boolean haveChild(TypeVO t){
		return false;
	}
	public int getPresentDate(){
		return 0;
	}
}
