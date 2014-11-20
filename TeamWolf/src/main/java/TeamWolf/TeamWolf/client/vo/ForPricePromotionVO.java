package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
/**
 * 
 * @author WHJ
 *
 */
public class ForPricePromotionVO extends PromotionVO{
	public double workCondition;
	public ArrayList<GiftForPromotionVO> list;
	public double cashCoupon;
	
	public ForPricePromotionVO(ArrayList<String> gNameList, ArrayList<String> sendNum, String CashCoupon, String WorkCondition, TimeVO begin, TimeVO end){
		super(PromotionTypeVO.forPrice, begin, end);
		cashCoupon = string_to_double(CashCoupon);
		workCondition = string_to_double(WorkCondition);
		list = setGiftList(gNameList, sendNum);
	}
	
	public ForPricePromotionVO(ForPricePromotionPO po){
		super(po.type, po.begin, po.end);
		cashCoupon = po.cashCoupon;
		workCondition = po.workCondition;
		list = setGiftList(po.list);
	}
}
