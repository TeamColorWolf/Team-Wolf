package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class ForVIPPromotionVO extends PromotionVO{
	public ArrayList<GiftForPromotionVO> list;
	public double discount;
	public double cashCoupon;
	
	public ForVIPPromotionVO(ArrayList<String> gNameList, ArrayList<String> sendNum, String Discount, String CashCoupon){
		super(PromotionTypeVO.forVIP);
		discount = string_to_double(Discount);
		cashCoupon = string_to_double(CashCoupon);
		list = setGiftList(gNameList, sendNum);
	}
	
}
