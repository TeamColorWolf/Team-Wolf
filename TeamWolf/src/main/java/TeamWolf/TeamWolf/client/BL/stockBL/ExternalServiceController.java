package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsManager;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
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
    
	public ArrayList<IncreaseToMatchVO> getITM() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DecreaseToMatchVO> getDTM() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		
		ExternalServiceController esc=new ExternalServiceController("114.212.42.159");
		ArrayList<TypeVO> typeList=esc.getLeaveType();
		for(TypeVO t: typeList){
			
			System.out.println(t.getName());
		}
	}
	
}
