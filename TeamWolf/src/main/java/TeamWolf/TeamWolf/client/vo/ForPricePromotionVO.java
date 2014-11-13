package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class ForPricePromotionVO extends PromotionVO{
	public ArrayList<GiftForPromotionVO> list;
	public double cashCoupon;
	
	public ForPricePromotionVO(ArrayList<String> gNameList, ArrayList<String> sendNum, String CashCoupon){
		super(PromotionTypeVO.forPrice);
		cashCoupon = string_to_double(CashCoupon);
		list = setGiftList(gNameList, sendNum);
	}
	
	
}
