package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;

public class ForPricePromotionPO extends PromotionPO{
	ArrayList<GiftForPromotionPO> list;
	double cashCoupon;
	
	public ForPricePromotionPO(ForPricePromotionVO vo){
		super(PromotionTypePO.forPrice);
		cashCoupon = vo.cashCoupon;
		list = setGiftList(vo.list);
	}
}
