package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.SpecialGoodsPromotionPO;
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
	
	public SpecialGoodsPromotionVO(SpecialGoodsPromotionPO po){
		super(po.type, po.begin, po.end);
		totalPrice = po.totalPrice;
		list = setGiftList(po.list);
	}
}
