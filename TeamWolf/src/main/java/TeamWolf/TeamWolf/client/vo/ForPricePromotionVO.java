package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
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
	
	
}
