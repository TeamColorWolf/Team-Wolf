package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsManager;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsTrade;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class ExternalServiceController implements ExternalService{

	StockBLManager man;
	GoodsManager gm;
	GoodsTrade gt;
	String IP;
	
	public ExternalServiceController(String IP){
		this.IP=IP;
		man=new StockBLManager(IP);
		gm=new GoodsManager(IP);
		gt=new GoodsTrade(IP);
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

	public int handlePresentList(ArrayList<GiftForPromotionVO> gpl, String customer){
		return gt.handlePresentList(gpl, customer);
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
		
		ExternalServiceController esc=new ExternalServiceController("192.168.1.102");
		ArrayList<TypeVO> typeList=esc.getLeaveType();
		
		for(TypeVO t: typeList){
			
			System.out.println(t.getName());
			ArrayList<GoodsVO> gl=t.getAllLeave();
		    for(GoodsVO g: gl)
				System.out.println(g.getName());
		}
		
		String s="specialGoods";
		
		System.out.println(!s.contains("specialGoods"));
	}

	public int addSpecialPackage(SpecialGoodsPromotionVO sp) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
