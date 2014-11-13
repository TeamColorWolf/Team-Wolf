package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class SpecialGoodsPromotionPO extends PromotionPO{
	ArrayList<GiftForPromotionPO> list;
	double totalPrice;
	
	public SpecialGoodsPromotionPO(SpecialGoodsPromotionVO vo){
		super(PromotionTypePO.specialGoods);
		totalPrice = vo.totalPrice;
		list = setGiftList(vo.list);
	}
}
