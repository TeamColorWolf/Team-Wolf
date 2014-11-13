package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author WHJ
 *
 */
public class SpecialGoodsPromotionVO extends PromotionVO{
	public ArrayList<GiftForPromotionVO> list;
	public double totalPrice;
	
	public SpecialGoodsPromotionVO(ArrayList<String> gNameList, ArrayList<String> gNumList, String TotalPrice, TimeVO begin, TimeVO end){
		super(PromotionTypeVO.specialGoods, begin, end);
		totalPrice = string_to_double(TotalPrice);
		list = setGiftList(gNameList, gNumList);
	}
}
