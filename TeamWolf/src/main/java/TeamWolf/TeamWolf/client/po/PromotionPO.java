package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;

public class PromotionPO implements Serializable{
	public PromotionTypePO type;
	
	public PromotionPO(PromotionTypePO t){
		type = t;
	}
	
	protected ArrayList<GiftForPromotionPO> setGiftList(ArrayList<GiftForPromotionVO> vo){
		ArrayList<GiftForPromotionPO> list = new ArrayList<GiftForPromotionPO>();
		for(int i = 0; i < list.size(); i++){
			GiftForPromotionPO po = new GiftForPromotionPO(vo.get(i).GoodsName, vo.get(i).sendNumber);
			list.add(po);
		}
		return list;
	}
}
