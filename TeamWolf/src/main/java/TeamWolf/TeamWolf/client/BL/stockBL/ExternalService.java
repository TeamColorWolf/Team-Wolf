package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public interface ExternalService {

	public ArrayList<TypeVO> getLeaveType();
	
	public GoodsVO finGoods(String number);
	
	public int addSpecialPackage ();
	
	
}
