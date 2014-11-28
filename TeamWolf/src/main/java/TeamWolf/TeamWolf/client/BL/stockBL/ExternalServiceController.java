package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsManager;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class ExternalServiceController implements ExternalService{

	StockBLManager man;
	GoodsManager gm;
	String IP;
	
	public ExternalServiceController(String IP){
		this.IP=IP;
		man=new StockBLManager(IP);
		gm=new GoodsManager(IP);
	}
	
	public ArrayList<TypeVO> getLeaveType() {
		// TODO Auto-generated method stub
		return man.getLeaveType();
	}

	public GoodsVO finGoods(String number) {
		// TODO Auto-generated method stub
		GoodsVO tofin=new GoodsVO(null, null, number, null, null, null, null, null, null, null, null);
		return gm.finGoods(tofin);
	}

	public int addSpecialPackage(SpecialGoodsPromotionVO sp) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	/*public static void main(String[] args){
		
	}*/
}
