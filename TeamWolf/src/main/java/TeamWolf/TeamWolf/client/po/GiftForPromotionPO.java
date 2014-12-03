package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

public class GiftForPromotionPO implements Serializable{
	
	public String GoodsNum;
	public int sendNumber;
	
	public GiftForPromotionPO(String gNum, int number){
		GoodsNum = gNum;
		sendNumber = number;
	}
}
