package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class ForPricePromotionPO extends PromotionPO{
	public double workCondition;
	public ArrayList<GiftForPromotionPO> list;
	public double cashCoupon;
	
	public ForPricePromotionPO(ForPricePromotionVO vo){
		super(PromotionTypePO.forPrice, vo);
		workCondition = vo.workCondition;
		cashCoupon = vo.cashCoupon;
		list = setGiftList(vo.list);
	}
}
