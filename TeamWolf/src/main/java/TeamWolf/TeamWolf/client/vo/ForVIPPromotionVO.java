package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author WHJ
 *
 */
public class ForVIPPromotionVO extends PromotionVO{
	public int VIPrank;
	public ArrayList<GiftForPromotionVO> list;
	public double discount;
	public double cashCoupon;
	
	public ForVIPPromotionVO(ArrayList<String> gNameList, ArrayList<String> sendNum, String Discount, String CashCoupon, String WorkCondition, TimeVO begin, TimeVO end){
		super(PromotionTypeVO.forVIP, begin, end);
		VIPrank = string_to_int(WorkCondition);
		discount = string_to_double(Discount);
		cashCoupon = string_to_double(CashCoupon);
		list = setGiftList(gNameList, sendNum);
	}
	
}
