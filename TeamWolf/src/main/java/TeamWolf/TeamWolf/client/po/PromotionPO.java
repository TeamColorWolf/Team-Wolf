package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionPO implements Serializable{
	public PromotionTypePO type;
	public TimePO begin;
	public TimePO end;
	public PromotionPO(PromotionTypePO t, PromotionVO vo){
		type = t;
		begin = new TimePO(vo.begin);
		end = new TimePO(vo.end);
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
