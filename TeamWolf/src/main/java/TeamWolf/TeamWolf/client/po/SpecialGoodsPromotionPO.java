package TeamWolf.TeamWolf.client.po;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class SpecialGoodsPromotionPO extends PromotionPO{
	public ArrayList<GiftForPromotionPO> list;
	public double totalPrice;
	
	public SpecialGoodsPromotionPO(SpecialGoodsPromotionVO vo){
		super(PromotionTypePO.specialGoods, vo);
		totalPrice = vo.totalPrice;
		list = setGiftList(vo.list);
	}
}
