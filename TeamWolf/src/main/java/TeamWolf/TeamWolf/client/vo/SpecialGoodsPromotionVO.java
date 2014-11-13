package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class SpecialGoodsPromotionVO extends PromotionVO{
	public ArrayList<GiftForPromotionVO> list;
	public double totalPrice;
	
	public SpecialGoodsPromotionVO(ArrayList<String> gNameList, ArrayList<String> gNumList, String TotalPrice){
		super(PromotionTypeVO.specialGoods);
		totalPrice = string_to_double(TotalPrice);
		list = setGiftList(gNameList, gNumList);
	}
}
