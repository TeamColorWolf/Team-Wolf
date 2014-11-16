package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

public class Promotion_driver {
	PromotionBL bl;
	ArrayList<PromotionPO> poList;
	ArrayList<PromotionVO> voList;
	public Promotion_driver(String IP){
		bl = new PromotionBL_stub(IP);
		
		ArrayList<String> gift = new ArrayList<String>();
		ArrayList<String> send = new ArrayList<String>();
		System.out.println(gift.size());
		TimeVO time = new TimeVO("2000", "01", "01");
		ForVIPPromotionVO fVvo = new ForVIPPromotionVO(gift, send, "1000", "500", "1", time, time);
		ForPricePromotionVO fPvo = new ForPricePromotionVO(gift, send, "1000", "100000", time, time);
		SpecialGoodsPromotionVO spvo = new SpecialGoodsPromotionVO(gift, send, "0", time, time);
		
		bl.setForPrice(fPvo);
		bl.setForSpecialGoods(spvo);
		bl.setForVIP(fVvo);
		
		voList = bl.check();
		
		bl.delet(fVvo);
	}
	
	public static void main(String[] args){
		Promotion_driver pd = new Promotion_driver("127.0.0.1");
	}
}
