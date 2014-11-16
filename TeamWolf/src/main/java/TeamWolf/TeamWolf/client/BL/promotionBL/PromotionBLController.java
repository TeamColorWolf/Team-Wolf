package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionBLController implements PromotionBLservice{

	PromotionBL bl;
	public PromotionBLController(String IP){
		bl = new PromotionBL_stub(IP);
	}
	
	public int setForVIP(ForVIPPromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.setForVIP(vo);
	}

	public int setForSpecialGoods(SpecialGoodsPromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.setForSpecialGoods(vo);
	}

	public int setForPrice(ForPricePromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.setForPrice(vo);
	}

	public PromotionVO getPromotion(String describe) {
		// TODO Auto-generated method stub
		return bl.getPromotion(describe);
	}

	public int delet(PromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.delet(vo);
	}
	
	public int update(PromotionVO vo) {
		// TODO Auto-generated method stub
		return bl.update(vo);
	}

	public ArrayList<PromotionVO> check() {
		// TODO Auto-generated method stub
		return bl.check();
	}

}
