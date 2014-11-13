package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class ForVIPPromotionPO extends PromotionPO implements Serializable{
	int VIPrank;
	ArrayList<GiftForPromotionPO> list;
	double discount;
	double cashCoupon;
	
	public ForVIPPromotionPO(ForVIPPromotionVO vo){
		super(PromotionTypePO.forVIP, vo);
		VIPrank = vo.VIPrank;
		discount = vo.discount;
		cashCoupon = vo.cashCoupon;
		list = setGiftList(vo.list);
	}
}
