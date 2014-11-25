package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionBLController implements PromotionBLservice{

	PromotionBL bl;
	public PromotionBLController(String IP){
		bl = new PromotionBL(IP);
	}
	
	public int addPromotion(PromotionVO vo){
		return bl.addPromotion(vo);
	}

	public PromotionVO getPromotion(String number) {
		// TODO Auto-generated method stub
		return bl.getPromotion(number);
	}

	public int delet(String number) {
		// TODO Auto-generated method stub
		return bl.delet(number);
	}
	
	public int update(PromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.update(vo);
	}

	public ArrayList<PromotionVO> check() {
		// TODO Auto-generated method stub
		return bl.check();
	}

	public ArrayList<TypeVO> typeList() {
		// TODO Auto-generated method stub
		return bl.getLeaveType();
	}

}
